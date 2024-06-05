package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {
}

