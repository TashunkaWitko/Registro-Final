package it.pi.registro.registro.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectCreateRequestDTO {

    @Size(min = 3, max = 20)
    private String subjectName;

    @Size(min = 3, max = 20)
    private String subjectDescription;

    @Override
    public String toString() {
        return "SubjectCreateDTO{" +
                "subjectName='" + subjectName + '\'' +
                ", subjectDescription='" + subjectDescription + '\'' +
                '}';
    }
}
