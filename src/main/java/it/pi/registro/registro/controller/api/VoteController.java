package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.dto.response.UserVoteResponseDTO;
import it.pi.registro.registro.dto.response.UserVotesByEmailResponse;
import it.pi.registro.registro.service.VoteService;
import it.pi.registro.registro.service.impl.VoteServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/votes")
public class VoteController {

    private VoteService voteService;
    private VoteServiceImpl voteServiceImpl;

    @GetMapping("/getVotesByMail")
    public ResponseEntity<UserVotesByEmailResponse> getVotesByMail(@Valid @RequestBody UserInfoRequestDTO userInfoRequestDTO){
        return new ResponseEntity<>( voteServiceImpl.getVotesByEmail(userInfoRequestDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> assignVote(@Valid @RequestBody VoteAssignRequestDTO voteAssignRequestDTO){
        try {
            return new ResponseEntity<>(voteService.assignVote(voteAssignRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
