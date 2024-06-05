package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.SchoolClass;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    SchoolClass findByName(String name);
}

