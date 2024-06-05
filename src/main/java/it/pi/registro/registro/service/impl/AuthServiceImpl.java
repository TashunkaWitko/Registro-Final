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
import it.pi.registro.registro.service.AuthService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private UserTypeRepository userTypeRepository;

    @Override
    public User registerUser(UserRegisterRequest userRegisterRequest) {

        User newUser = new User(userRegisterRequest.getFirstName(),
                userRegisterRequest.getLastName(),
                userRegisterRequest.getEmail(),
                userRegisterRequest.getPassword(),
                userRegisterRequest.getDateOfBirth(),
                userRegisterRequest.getAddress(),
                userRegisterRequest.getCity(),
                userTypeRepository.findByType(userRegisterRequest.getType() == null ? UserTypeEnum.GUEST.toString() :
                        userRegisterRequest.getType().name()));

        userRepository.save(newUser);

        return newUser;
    }

}
