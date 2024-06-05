package it.pi.registro.registro.dto.response;

import it.pi.registro.registro.dto.UserSubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserClassResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String className;

}
