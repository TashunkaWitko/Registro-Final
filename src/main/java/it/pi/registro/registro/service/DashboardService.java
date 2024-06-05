package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.DashboardResultDTO;
import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.dto.response.UsersByCity;
import it.pi.registro.registro.dto.response.UsersBySchoolClass;
import it.pi.registro.registro.dto.response.UsersByYearsDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DashboardService {

    List<UsersByYearsDTO> getUsersByYear();

    List<UsersByCity> getUsersByCity();

    List<UsersBySchoolClass> getUsersBySchoolCLass();
}
