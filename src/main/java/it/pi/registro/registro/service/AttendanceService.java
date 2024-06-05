package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AttendanceService {
    AttendanceRegisterResponseDTO registerAttendance(AttendanceRegisterRequestDTO attendanceRegisterRequestDTO);

    List<Attendance> getAttendances();

    Attendance updateAttendance(Attendance attendance);
}
