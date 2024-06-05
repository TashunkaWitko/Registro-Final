package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.SubjectUser;
import it.pi.registro.registro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserSubjectRepository extends JpaRepository<SubjectUser, Long> {
    @Query("SELECT us from SubjectUser us WHERE us.vote_date BETWEEN :start AND :end AND us.user.id = :userId")
    List<SubjectUser> findVotesByRange(@Param("start")LocalDateTime start, @Param("end")LocalDateTime end, @Param("userId") Long userId);
}


