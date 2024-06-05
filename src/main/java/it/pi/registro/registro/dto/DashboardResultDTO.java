package it.pi.registro.registro.dto;

import it.pi.registro.registro.dto.response.UsersByCity;
import it.pi.registro.registro.dto.response.UsersBySchoolClass;
import it.pi.registro.registro.dto.response.UsersByYearsDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardResultDTO {

    private List<UsersByYearsDTO> usersByYears;
    private List<UsersByCity> usersByCity;
    private List<UsersBySchoolClass> usersBySchoolClasses;
}
