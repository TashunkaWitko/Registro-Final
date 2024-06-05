package it.pi.registro.registro.repository;

import it.pi.registro.registro.dto.DashboardResultDTO;
import it.pi.registro.registro.dto.response.UsersByCity;
import it.pi.registro.registro.dto.response.UsersBySchoolClass;
import it.pi.registro.registro.dto.response.UsersByYearsDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<User, Long> {

    @Query("SELECT new it.pi.registro.registro.dto.response.UsersByYearsDTO(YEAR(u.createdDate), count(u)) " +
            "FROM User u WHERE YEAR(u.createdDate) IS NOT NULL GROUP BY YEAR(u.createdDate)")
    List<UsersByYearsDTO> findUsersByYear();

    @Query("SELECT new it.pi.registro.registro.dto.response.UsersByCity(u.userDetail.city as citta, count(u)) " +
            "FROM User u GROUP BY citta")
    List<UsersByCity> findUsersByCity();

    @Query("SELECT new it.pi.registro.registro.dto.response.UsersBySchoolClass(sc.name, count(u)) " +
            "FROM User u JOIN u.userSchoolClasses usc JOIN usc.schoolClass sc " +
            "WHERE u.userType.type = 'STUDENT' " +
            "GROUP BY sc.name")
    List<UsersBySchoolClass> findUsersBySchoolClass();


}

