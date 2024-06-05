package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.*;
import it.pi.registro.registro.dto.response.UserClassResponse;
import it.pi.registro.registro.dto.response.UserDateResponseDTO;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.dto.response.UserVoteResponseDTO;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);

    User createUserWithDetails(UserCreateRequestDTO userCreateRequestDTO);

    User getUserById(Long userId);

    List<UserVoteResponseDTO> getVotesByUserId(UserVotesRequestDTO userVotesRequestDTO) throws ResourceNotFoundException, BadRequestException;

    List<UserVoteResponseDTO> getVotesByEmail(UserInfoRequestDTO userInfoRequestDTO) throws ResourceNotFoundException, BadRequestException;

    User getUserByEmail(String email);

    UserInfoResponseDTO getUserInfoByEmail(UserInfoRequestDTO userInfoRequestDTO);

    List<User> getAllUsers();

    List<User> getUsersWithoutDetails();

    List<User> getUsersWithString(UserNameRequest userNameRequest);

    List<UserDateResponseDTO> getAllUsersWithDate();

    List<UserClassResponse> getUsersFromClass(UserClassRequest userClassRequest);

    List<UserClassResponse> getAllUsersFromClass(String className);

    User updateUser(User user);

    void deleteUser(Long userId, Boolean isSoftDelete);
}
