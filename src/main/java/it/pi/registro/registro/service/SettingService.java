package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.Settings;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SettingService {

    Settings getSettings();

    Settings updateSettings(Settings settings);

}
