package it.pi.registro.registro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDateResponseDTO {

    private String name;
    private String surname;
    private String email;
    private String birth;
    private String days_to_birthday;
    private String age;

}
