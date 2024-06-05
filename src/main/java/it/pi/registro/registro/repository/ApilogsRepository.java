package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.ApiKey;
import it.pi.registro.registro.entity.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApilogsRepository extends JpaRepository<ApiLog, Long> {

}

