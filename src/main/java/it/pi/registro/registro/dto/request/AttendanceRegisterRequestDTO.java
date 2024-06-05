package it.pi.registro.registro.dto.request;

import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRegisterRequestDTO {

    private LocalDateTime entranceDate;
    private LocalDateTime exitDate;
    private LocalDateTime referDate;
    @NotNull
    private Long studentId;
    @NotNull
    private Long teacherId;
    private String notes;

}
