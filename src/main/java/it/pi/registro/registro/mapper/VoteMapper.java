package it.pi.registro.registro.mapper;

import it.pi.registro.registro.dto.request.UserVotesRequestDTO;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.dto.response.UserVotesByEmailResponse;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserSchoolClass;
import it.pi.registro.registro.entity.UserType;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface VoteMapper {

    UserVotesByEmailResponse voteToDTO(Set<UserSchoolClass> userSchoolClasses, UserType userType);
}
