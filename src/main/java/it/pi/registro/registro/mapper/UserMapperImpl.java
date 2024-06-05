package it.pi.registro.registro.mapper;

import it.pi.registro.registro.configuration.RegistroProp;
import it.pi.registro.registro.dto.UserSubjectDTO;
import it.pi.registro.registro.dto.request.UserVotesRequestDTO;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.dto.response.UserVoteResponseDTO;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import it.pi.registro.registro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class UserMapperImpl implements UserMapper{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistroProp registroProp;

    @Override
    public UserDataResponseDTO toDataResponseDTO(User user) {

        System.out.println(("\n\n\n\n\n"));
        System.out.println(user.getActiveClass());
        System.out.println(("\n\n\n\n\n"));

        UserDataResponseDTO userDataResponseDTO = new UserDataResponseDTO(
                user.getId().toString(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getBirth_date(),
                user.getUserDetail()!=null && user.getUserDetail().getAddress() != null ? user.getUserDetail().getAddress() : "NO ADDRESS",
                user.getUserDetail()!=null && user.getUserDetail().getCity() != null ? user.getUserDetail().getCity() : "NO CITY",
                user.getUserDetail()!=null && user.getUserType().getDescription() != null ? user.getUserType().getType() : "NO TYPE",
                new ArrayList<>(),
                user.getActiveClass()
        );

        user.getSubjectUsers()
                .forEach(subjectUser -> {
                    userDataResponseDTO.getVotes().add(
                            new UserSubjectDTO(
                                    subjectUser.getSubject().getName(),
                                    subjectUser.getSubject().getDescription(),
                                    subjectUser.getTeacher().getFirstName() + " " + subjectUser.getTeacher().getLastName() + " " + subjectUser.getTeacher().getEmail(),
                                    subjectUser.getVote(),
                                    subjectUser.getNotes(),
                                    subjectUser.getVote_date()
                            )
                    );
                });

        return userDataResponseDTO;
    }

    @Override
    public UserVotesRequestDTO toUserVoteResponse(UserVotesRequestDTO userVotesRequestDTO) {
        Optional<User> student = userRepository.findById(userVotesRequestDTO.getUserId());

        LocalDateTime now = LocalDateTime.now();
        int startingYear = 0;
        int endingYear = 0;

        if(student.isEmpty()) {
            throw new ResourceNotFoundException("Not Found");
        }

        if(userVotesRequestDTO.getStartDate() == null && userVotesRequestDTO.getEndDate() == null) {
            if(now.getMonthValue() >= registroProp.getVoteStartDate()){
                startingYear = now.getYear();
                endingYear = now.getYear() + 1;

                LocalDateTime startingDate = LocalDateTime.now();
                startingDate = startingDate.withMonth(registroProp.getVoteStartDate());
                startingDate = startingDate.withDayOfMonth(1);
                startingDate = startingDate.withYear(startingYear);

                LocalDateTime endingDate = LocalDateTime.now();
                endingDate = endingDate.withMonth(registroProp.getVoteEndDate());
                endingDate = endingDate.withDayOfMonth(1);
                endingDate = endingDate.withYear(endingYear);

                userVotesRequestDTO.setStartDate(startingDate);
                userVotesRequestDTO.setEndDate(endingDate);

                return userVotesRequestDTO;
            } else {
                startingYear = now.getYear() - 1;
                endingYear = now.getYear();

                LocalDateTime startingDate = LocalDateTime.now();
                startingDate = startingDate.withMonth(registroProp.getVoteStartDate());
                startingDate = startingDate.withDayOfMonth(1);
                startingDate = startingDate.withYear(startingYear);

                LocalDateTime endingDate = LocalDateTime.now();
                endingDate = endingDate.withMonth(registroProp.getVoteEndDate());
                endingDate = endingDate.withDayOfMonth(1);
                endingDate = endingDate.withYear(endingYear);

                userVotesRequestDTO.setStartDate(startingDate);
                userVotesRequestDTO.setEndDate(endingDate);

                return userVotesRequestDTO;
            }
        }

        if(userVotesRequestDTO.getStartDate() == null || userVotesRequestDTO.getEndDate() == null){
            throw new BadRequestException("Both date null or set");
        }


        if(userVotesRequestDTO.getStartDate().isAfter(userVotesRequestDTO.getEndDate())){
            throw new BadRequestException("Start date must be before end date");
        }


        if(registroProp.getVoteEndDate() >= registroProp.getVoteStartDate()){
            //Il mese della data di inizio deve essere successivo al mese di fine
            throw new BadRequestException("Bad Request");

        }

        return userVotesRequestDTO;
    }

    private LocalDateTime getStartDate(){
        return LocalDateTime.now();
    }
}
