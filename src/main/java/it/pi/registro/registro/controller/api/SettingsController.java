package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.Settings;
import it.pi.registro.registro.service.AttendanceService;
import it.pi.registro.registro.service.SettingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/settings")
public class SettingsController {

    private static final Logger logger = LoggerFactory.getLogger(SettingsController.class);

    @Autowired
    private SettingService settingService;

    @GetMapping
    public ResponseEntity<Settings> getSettings(){
        return new ResponseEntity<>(settingService.getSettings(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Settings> updateSettings(@Valid @RequestBody Settings settings) {
        return new ResponseEntity<>(settingService.updateSettings(settings), HttpStatus.OK);
    }

}
