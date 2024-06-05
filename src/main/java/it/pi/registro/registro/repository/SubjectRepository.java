package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.enums.UserSubjectEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByName(String name);
}

