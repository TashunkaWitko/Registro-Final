package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.DashboardResultDTO;
import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.dto.response.UsersByCity;
import it.pi.registro.registro.dto.response.UsersBySchoolClass;
import it.pi.registro.registro.dto.response.UsersByYearsDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.repository.AttendanceRepository;
import it.pi.registro.registro.repository.DashboardRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.service.AttendanceService;
import it.pi.registro.registro.service.DashboardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Override
    public List<UsersByYearsDTO> getUsersByYear() {
        return dashboardRepository.findUsersByYear();
    }

    @Override
    public List<UsersByCity> getUsersByCity() {
        return dashboardRepository.findUsersByCity();
    }

    @Override
    public List<UsersBySchoolClass> getUsersBySchoolCLass() {
        return dashboardRepository.findUsersBySchoolClass();
    }
}
