package it.pi.registro.registro.dto.response;

import it.pi.registro.registro.dto.UserSubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVoteResponseDTO {

    private Double vote;
    private LocalDateTime voteDate;
    private String teacherName;
    private String teacherSurname;
    private String subject;

}
