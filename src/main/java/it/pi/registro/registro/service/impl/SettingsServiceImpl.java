package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.configuration.RegistroProp;
import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.Settings;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.enums.LangEnum;
import it.pi.registro.registro.repository.AttendanceRepository;
import it.pi.registro.registro.repository.SettingsRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.service.AttendanceService;
import it.pi.registro.registro.service.SettingService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SettingsServiceImpl implements SettingService {

    private SettingsRepository settingsRepository;

    @Autowired
    private RegistroProp registroProp;

    @Override
    public Settings getSettings() {
        try{
            return settingsRepository.findAll().get(0);
        } catch(Exception e) {
            return Settings
                    .builder()
                    .isDark(false)
                    .lang(registroProp.getDefaultLang())
                    .build();
        }


    }

    @Override
    public Settings updateSettings(Settings requestSettings) {
        Settings settings = settingsRepository.findAll().get(0);
        settings.setLang(requestSettings.getLang());
        settings.setIsDark(requestSettings.getIsDark());
        return settingsRepository.save(settings);
    }
}
