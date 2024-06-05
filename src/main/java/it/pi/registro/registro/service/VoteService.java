package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.dto.response.VoteAssignResponseDTO;

public interface VoteService {

    VoteAssignResponseDTO assignVote(VoteAssignRequestDTO voteAssignRequestDTO) throws Exception;

}
