package it.pi.registro.registro.service;

import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserType;

import java.util.List;

public interface UserTypeService {
    UserType createUserType(UserType userType);

    UserType getUserTypeById(Long userTypeId);

    List<UserType> getAllUserTypes();

    UserType updateUserType(UserType userType);

    void deleteUserType(Long userTypeId);
}
