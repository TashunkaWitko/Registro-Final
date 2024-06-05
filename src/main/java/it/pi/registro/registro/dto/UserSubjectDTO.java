package it.pi.registro.registro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSubjectDTO {

    private String subjectName;
    private String subjectDescription;
    private String teacherName;
    private double vote;
    private String notes;
    private LocalDateTime vote_date;

}
