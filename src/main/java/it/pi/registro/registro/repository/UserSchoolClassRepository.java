package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserSchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSchoolClassRepository extends JpaRepository<UserSchoolClass, Long> {
    @Query("SELECT u from UserSchoolClass u where u.user.id = :userId")
    List<UserSchoolClass> findByUserId(@Param("userId")Long userId);

    @Query("SELECT u from UserSchoolClass u where u.schoolClass.name = :name")
    List<UserSchoolClass> findBySchoolClassName(@Param("name")String name);

}

