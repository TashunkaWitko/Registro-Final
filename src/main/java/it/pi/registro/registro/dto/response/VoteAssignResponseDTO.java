package it.pi.registro.registro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteAssignResponseDTO {

    private Double vote;
    private LocalDateTime vote_date;
    private String teacherName;
    private String teacherSurname;
    private String subject;

    public VoteAssignResponseDTO(String s, LocalDateTime voteDate) {
    }
}
