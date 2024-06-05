package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.dto.DashboardResultDTO;
import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.service.AttendanceService;
import it.pi.registro.registro.service.DashboardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardResultDTO> getStatistics(){
        return new ResponseEntity<>(DashboardResultDTO
                .builder()
                .usersByCity(dashboardService.getUsersByCity())
                .usersByYears(dashboardService.getUsersByYear())
                .usersBySchoolClasses(dashboardService.getUsersBySchoolCLass())
                .build(),
                HttpStatus.OK);
    }

}
