package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.*;
import it.pi.registro.registro.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthService {
    User registerUser(UserRegisterRequest userRegisterRequest);

}
