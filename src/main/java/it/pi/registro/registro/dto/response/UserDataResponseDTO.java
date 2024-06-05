package it.pi.registro.registro.dto.response;

import it.pi.registro.registro.dto.UserSubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDataResponseDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birth_date;
    private String address;
    private String city;
    private String role;
    private List<UserSubjectDTO> votes;
    private String currentSchoolClass;

}
