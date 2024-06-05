package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.ApiKey;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApikeyRepository extends JpaRepository<ApiKey, Long> {
    @Query("SELECT a from ApiKey a where CURDATE() " +
            "BETWEEN DATE(a.initialDate) AND DATE(a.expireDate) AND " +
            "a.apiKey = :apikey")
    List<ApiKey> findApiKeyByKey(@Param("apikey")String apikey);
}

