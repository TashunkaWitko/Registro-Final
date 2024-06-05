package it.pi.registro.registro.mapper;

import it.pi.registro.registro.configuration.RegistroProp;
import it.pi.registro.registro.dto.UserSubjectDTO;
import it.pi.registro.registro.dto.request.UserVotesRequestDTO;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.dto.response.UserVotesByEmailResponse;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserSchoolClass;
import it.pi.registro.registro.entity.UserType;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import it.pi.registro.registro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;

public class VoteMapperImpl implements VoteMapper {

    @Override
    public UserVotesByEmailResponse voteToDTO(Set<UserSchoolClass> userSchoolClasses, UserType userType) {

        Map<String, Map<String, String>> results = new HashMap<>();
        Map<String, String> resultContent = new HashMap<>();


        if(userType.getType().equals(UserTypeEnum.TEACHER.toString())){

        }

        resultContent.put("A", "B");

        System.out.println();

        UserVotesByEmailResponse userVotesByEmailResponse = new UserVotesByEmailResponse();

        userVotesByEmailResponse.setResults(resultContent);

        return userVotesByEmailResponse;
    }
}
