package it.pi.registro.registro.dto.response;

import it.pi.registro.registro.dto.UserSubjectDTO;
import jakarta.validation.constraints.NotNull;
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
public class AttendanceRegisterResponseDTO {

    private LocalDateTime insertionDate;
    private LocalDateTime entranceDate;
    private LocalDateTime exitDate;
    private LocalDateTime referDate;
    private String studentName;
    private String studentSurname;
    private String teacherName;
    private String teacherSurname;

}
