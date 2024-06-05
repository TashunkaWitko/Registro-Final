package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/attendances")
public class AttendanceController {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    private AttendanceService attendanceService;


    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendances(){

        return new ResponseEntity<>(attendanceService.getAttendances(), HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerAttendance(@Valid @RequestBody AttendanceRegisterRequestDTO attendanceRegisterRequestDTO){
        logger.info("RegisterAttendance... ");
        return new ResponseEntity<>(attendanceService.registerAttendance(attendanceRegisterRequestDTO), HttpStatus.CREATED);
    }

}
