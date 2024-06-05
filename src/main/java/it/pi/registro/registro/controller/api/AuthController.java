package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.annotation.NotZeroAndPositive;
import it.pi.registro.registro.dto.request.*;
import it.pi.registro.registro.dto.response.UserClassResponse;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.dto.response.UserDateResponseDTO;
import it.pi.registro.registro.dto.response.UserVoteResponseDTO;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.mapper.UserMapper;
import it.pi.registro.registro.repository.UserSubjectRepository;
import it.pi.registro.registro.service.AttendanceService;
import it.pi.registro.registro.service.AuthService;
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
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRegisterRequest userRegisterRequest){
        return new ResponseEntity<>(authService.registerUser(userRegisterRequest), HttpStatus.CREATED);
    }
}
