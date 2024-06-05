package it.pi.registro.registro.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteAssignRequestDTO {

    @NotNull
    private double vote;
    private String notes;
//    private LocalDateTime vote_date;
    @Email
    private String studentEmail;
    @Email
    private String teacherEmail;
    private String subjectName;

    @Override
    public String toString() {
        return "VoteAssignRequestDTO{" +
                "vote=" + vote +
                ", notes='" + notes + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
