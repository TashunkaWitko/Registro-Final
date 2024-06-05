package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.repository.AttendanceRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);

    private AttendanceRepository attendanceRepository;
    private UserRepository userRepository;

    @Override
    public AttendanceRegisterResponseDTO registerAttendance(AttendanceRegisterRequestDTO attendanceRegisterRequestDTO) {
        logger.info("RegisterAttendanceService");

        User student = userRepository.findById(attendanceRegisterRequestDTO.getStudentId()).get();
        User teacher = userRepository.findById(attendanceRegisterRequestDTO.getTeacherId()).get();

        attendanceRepository.save(new Attendance(
                attendanceRegisterRequestDTO.getReferDate(),
                LocalDateTime.now(),
                attendanceRegisterRequestDTO.getEntranceDate(),
                attendanceRegisterRequestDTO.getExitDate(),
                student,
                teacher
        ));
        return new AttendanceRegisterResponseDTO(
                LocalDateTime.now(),
                attendanceRegisterRequestDTO.getEntranceDate(),
                attendanceRegisterRequestDTO.getExitDate(),
                attendanceRegisterRequestDTO.getReferDate(),
                student.getFirstName(),
                student.getLastName(),
                teacher.getFirstName(),
                teacher.getLastName()
        );
    }

    @Override
    public List<Attendance> getAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance updateAttendance(Attendance attendance) {
        Attendance existingAttendance = attendanceRepository.findById(attendance.getId()).get();
        existingAttendance.setTeacher(attendance.getTeacher());
        existingAttendance.setStudent(attendance.getStudent());
        existingAttendance.setEntranceDate(attendance.getEntranceDate());
        existingAttendance.setExitDate(attendance.getExitDate());
        existingAttendance.setInsertionDate(attendance.getInsertionDate());
        existingAttendance.setReferenceDate(attendance.getReferenceDate());
        return attendanceRepository.save(existingAttendance);
    }
}
