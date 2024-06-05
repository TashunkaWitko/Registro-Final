package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.annotation.NotZeroAndPositive;
import it.pi.registro.registro.dto.request.*;
import it.pi.registro.registro.dto.response.UserClassResponse;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.dto.response.UserDateResponseDTO;
import it.pi.registro.registro.dto.response.UserVoteResponseDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import it.pi.registro.registro.mapper.UserMapper;
import it.pi.registro.registro.repository.SubjectRepository;
import it.pi.registro.registro.repository.UserSubjectRepository;
import it.pi.registro.registro.service.AttendanceService;
import it.pi.registro.registro.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;
    private AttendanceService attendanceService;
    private UserSubjectRepository userSubjectRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<UserDataResponseDTO>> getAllUsers(){

        logger.info("getAllUsers");
        return new ResponseEntity<>(userService.getAllUsers()
                .stream()
                .map(userMapper::toDataResponseDTO)
                .collect(Collectors.toList()), HttpStatus.OK);

    }

    @GetMapping("/date")
    public ResponseEntity<List<UserDateResponseDTO>> getAllUsersWithDate(){

        return new ResponseEntity<>(userService.getAllUsersWithDate(), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUserInfo(@RequestBody UserInfoRequestDTO userInfoRequestDTO){

        try{
            return new ResponseEntity<>(userService.getUserInfoByEmail(userInfoRequestDTO), HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDataResponseDTO> getUserById(@PathVariable("id") Long userId){
        UserDataResponseDTO user = userMapper.toDataResponseDTO(userService.getUserById(userId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/votes")
    public ResponseEntity<List<UserVoteResponseDTO>> getUserVotes(@Valid @RequestBody UserVotesRequestDTO userVotesRequestDTO){


        userService.getVotesByUserId(userVotesRequestDTO);
        return new ResponseEntity<>(userService.getVotesByUserId(userVotesRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/findByMail")
    public ResponseEntity<User> getUserByEmail(@RequestBody String email){
        User user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getStudentByClass")
    public ResponseEntity<List<UserClassResponse>> getUsersByClass(@Valid @RequestBody UserClassRequest userClassRequest){
        System.out.println(userClassRequest);
        List<UserClassResponse> usersFromClasses = userService.getUsersFromClass(userClassRequest);
        return new ResponseEntity<>(usersFromClasses, HttpStatus.OK);
    }

    @GetMapping("/getUsersByClass/{name}")
    public ResponseEntity<List<UserClassResponse>> getUsersByClassName(@PathVariable("name") String name){
        List<UserClassResponse> usersFromClasses = userService.getAllUsersFromClass(name);
        return new ResponseEntity<>(usersFromClasses, HttpStatus.OK);
    }

    @GetMapping("/getStudentByName")
    public ResponseEntity<List<User>> getUserByName(@Valid @RequestBody UserNameRequest userNameRequest){
        List<User> users = userService.getUsersWithString(userNameRequest);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Create simple user without details
     */
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * Create user with details
     */
    @PostMapping("/withDetails")
    public ResponseEntity<User> createUserWithDetails(@Valid @RequestBody UserCreateRequestDTO userCreateRequestDTO){
        User savedUser = userService.createUserWithDetails(userCreateRequestDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId ,@RequestBody User user){
        User updatedUser = userService.getUserById(userId);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        userService.updateUser(updatedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    @Transactional
    public ResponseEntity<?> deleteUser(@NotZeroAndPositive @PathVariable("id") Long userId, @RequestBody Boolean isSoftDelete){
        userService.deleteUser(userId, isSoftDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
