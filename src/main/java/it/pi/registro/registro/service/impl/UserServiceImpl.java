package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.controller.api.UserController;
import it.pi.registro.registro.dto.request.*;
import it.pi.registro.registro.dto.response.UserClassResponse;
import it.pi.registro.registro.dto.response.UserDateResponseDTO;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.dto.response.UserVoteResponseDTO;
import it.pi.registro.registro.entity.*;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import it.pi.registro.registro.mapper.UserMapper;
import it.pi.registro.registro.repository.*;
import it.pi.registro.registro.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private UserSubjectRepository userSubjectRepository;
    @Autowired
    private UserSchoolClassRepository userSchoolClassRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private SchoolClassRepository schoolClassRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUserWithDetails(UserCreateRequestDTO userCreateRequestDTO) {

        User user = new User();
        user.setFirstName(userCreateRequestDTO.getFirstName());
        user.setLastName(userCreateRequestDTO.getLastName());
        user.setEmail(userCreateRequestDTO.getEmail());
        user.setPassword(userCreateRequestDTO.getPassword());

        UserDetail userDetail = new UserDetail();
        userDetail.setAddress(userCreateRequestDTO.getAddress());
        userDetail.setCity(userCreateRequestDTO.getCity());

        UserType userType = userTypeRepository.findByType(UserTypeEnum.GUEST.toString());

        if (userCreateRequestDTO.getType() != null) {
            userType = userTypeRepository.findByType((userCreateRequestDTO.getType().toString()));
        }

        user.setUserDetail(userDetail);
        user.setUserType(userType);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<UserVoteResponseDTO> getVotesByUserId(UserVotesRequestDTO userVotesRequestDTO)
            throws ResourceNotFoundException, BadRequestException {

        List<UserVoteResponseDTO> userVoteResponseDTOS = new ArrayList<>();

        UserVotesRequestDTO userVotesRequestDTO1 = userMapper.toUserVoteResponse(userVotesRequestDTO);

        for(SubjectUser subjectUser: userSubjectRepository.findVotesByRange(
                userVotesRequestDTO1.getStartDate(),
                userVotesRequestDTO1.getEndDate(),
                userVotesRequestDTO1.getUserId()))
        {
            UserVoteResponseDTO userVoteResponseDTO = new UserVoteResponseDTO(
                    subjectUser.getVote(),
                    subjectUser.getVote_date(),
                    subjectUser.getTeacher().getFirstName(),
                    subjectUser.getTeacher().getLastName(),
                    subjectUser.getSubject().getDescription()
            );
            userVoteResponseDTOS.add(userVoteResponseDTO);
        }
        return userVoteResponseDTOS;
    }

    @Override
    public List<UserVoteResponseDTO> getVotesByEmail(UserInfoRequestDTO userInfoRequestDTO) throws ResourceNotFoundException, BadRequestException {
        User user = userRepository.findByEmail(userInfoRequestDTO.getEmail());
        Set<SubjectUser> votes = user.getSubjectUsers();
        List<UserVoteResponseDTO> userVotes = new ArrayList<>();
        votes.forEach(subjectUser -> {
            userVotes.add(new UserVoteResponseDTO(subjectUser.getVote(), subjectUser.getVote_date(),
                    subjectUser.getTeacher().getFirstName(), subjectUser.getTeacher().getLastName(),
                    subjectUser.getSubject().getName()));
        });
        return userVotes;
    }


    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public UserInfoResponseDTO getUserInfoByEmail(UserInfoRequestDTO userInfoRequestDTO) {

        User user = userRepository.findByEmail(userInfoRequestDTO.getEmail());
        return new UserInfoResponseDTO(user.getFirstName(), user.getLastName(), user.getUserType().getDescription());
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("getAllUsers");
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersWithoutDetails() {
        return userRepository.findUsersWhereDetailIsNull();
    }

    @Override
    public List<User> getUsersWithString(UserNameRequest userNameRequest) {
        return userRepository.findUsersWithString(userNameRequest.getName(), userNameRequest.getIsCaseSensitive());
    }

    @Override
    public List<UserDateResponseDTO> getAllUsersWithDate() {
        List<User> users = userRepository.findAll();
        List<UserDateResponseDTO> usersDate = new java.util.ArrayList<>(List.of());
        for(User item : users) {
            LocalDate today = LocalDate.now();
            LocalDate birthday = item.getBirth_date();
            LocalDate todayDays = LocalDate.now().withYear(2024);
            LocalDate birthdayDays = item.getBirth_date().withYear(2024);
            long days_to_birthday = ChronoUnit.DAYS.between(todayDays, birthdayDays) >= 0 ? ChronoUnit.DAYS.between(todayDays, birthdayDays) : ChronoUnit.DAYS.between(birthdayDays, todayDays);
            long age = ChronoUnit.YEARS.between(birthday, today);
            usersDate.add(new UserDateResponseDTO(item.getFirstName(), item.getLastName(), item.getEmail(), item.getBirth_date().format(DateTimeFormatter.ofPattern( "dd-MM-uuuu" )), String.valueOf(days_to_birthday), String.valueOf(age)));
        }
        return usersDate;
    }

    @Override
    public List<UserClassResponse> getUsersFromClass(UserClassRequest userClassRequest) {
        User teacher = userRepository.findByEmail(userClassRequest.getTeacherEmail());

        if(teacher == null){
            throw new ResourceNotFoundException("This User doesn't exists");
        }

        if(!Objects.equals(teacher.getUserType().getType(), UserTypeEnum.TEACHER.toString())){
            throw new BadRequestException("This User isn't a teacher");
        }

        List<UserSchoolClass> teacherSchoolClasses = userSchoolClassRepository.findByUserId(teacher.getId());

        if(teacherSchoolClasses.isEmpty()){
            throw new ResourceNotFoundException("This teacher doesn't have any class");
        }

        List<UserSchoolClass> schoolClassesFromTeacherEmail = new ArrayList<>();
        teacherSchoolClasses.forEach(userSchoolClass -> {
            schoolClassesFromTeacherEmail.addAll(userSchoolClass.getSchoolClass().getUserSchoolClasses());
        });

        List<UserClassResponse> studentsFromClasses = new ArrayList<>();

        if(userClassRequest.getClassName() != null){
            schoolClassesFromTeacherEmail.forEach(userSchoolClass -> {
                User student = userSchoolClass.getUser();
                if(Objects.equals(student.getUserType().getType(), UserTypeEnum.STUDENT.toString())
                        && Objects.equals(userSchoolClass.getSchoolClass().getName(), userClassRequest.getClassName())){
                    studentsFromClasses.add(new UserClassResponse(student.getFirstName(),
                            student.getLastName(),
                            student.getEmail(),
                            userSchoolClass.getSchoolClass().getName()));
                }
            });
        } else {
            schoolClassesFromTeacherEmail.forEach(userSchoolClass -> {
                User student = userSchoolClass.getUser();
                if(Objects.equals(student.getUserType().getType(), UserTypeEnum.STUDENT.toString())){
                    studentsFromClasses.add(new UserClassResponse(student.getFirstName(),
                            student.getLastName(),
                            student.getEmail(),
                            userSchoolClass.getSchoolClass().getName()));
                }
            });
        }

        if(studentsFromClasses.isEmpty()){
            throw new ResourceNotFoundException("There isn't any student in this class with this teacher");
        }

        return studentsFromClasses;
    }

    @Override
    public List<UserClassResponse> getAllUsersFromClass(String className) {
        List<UserSchoolClass> userSchoolClassList = userSchoolClassRepository.findBySchoolClassName(className);
        List<UserClassResponse> classUsers =  new ArrayList<>();
        userSchoolClassList.forEach(userSchoolClass -> {
            classUsers.add(new UserClassResponse(userSchoolClass.getUser().getFirstName(),
                    userSchoolClass.getUser().getLastName(),
                    userSchoolClass.getUser().getEmail(),
                    className));
        });
        return classUsers;
    }

    @Override
    public User updateUser(User user) {

        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId, Boolean isSoftDelete) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("This User doesn't exists");
        }

        if(Objects.equals(user.get().getUserType().getType(), UserTypeEnum.TEACHER.toString() ) ||
                Objects.equals(user.get().getUserType().getType(),UserTypeEnum.ADMIN.toString()) ){
            throw new BadRequestException("You can't delete this User");
        }

        if(isSoftDelete){
            User softDeletedUser = userRepository.findById(userId).get();
            softDeletedUser.setIsActive(false);
            userRepository.save(softDeletedUser);
        } else {
            User hardDeletedUser = userRepository.findById(userId).get();
            if (Objects.equals(hardDeletedUser.getUserType().getType(), UserTypeEnum.STUDENT.toString())) {
                for(Attendance attendance : hardDeletedUser.getAttendances()){
                    attendance.setStudent(null);
                    attendanceRepository.save(attendance);
                }
                hardDeletedUser.getSubjectUsers().forEach(subjectUser -> {
                    subjectUser.setUser(null);
                    userSubjectRepository.save(subjectUser);
                });
            }
            userRepository.delete(hardDeletedUser);
        }
    }
}
