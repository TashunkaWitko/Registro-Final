package it.pi.registro.registro.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "attendance")
@NoArgsConstructor
@Getter
@Setter
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime referenceDate;

    @Column
    private LocalDateTime insertionDate;

    @Column
    private LocalDateTime entranceDate;

    @Column
    private LocalDateTime exitDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("attendances")
    private User student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties("attendances")
    private User teacher;

    @PrePersist
    @PreUpdate
    public void prePersist() throws Exception {
        int result = this.entranceDate.compareTo(this.exitDate);
        if(result > 0){
            throw new Exception("except");
        }
        if(this.referenceDate == null){
            this.referenceDate = LocalDateTime.now();
        }
    }

    public Attendance(LocalDateTime referenceDate, LocalDateTime insertionDate, LocalDateTime entranceDate, LocalDateTime exitDate, User student, User teacher) {
        this.referenceDate = referenceDate;
        this.insertionDate = insertionDate;
        this.entranceDate = entranceDate;
        this.exitDate = exitDate;
        this.student = student;
        this.teacher = teacher;
    }
}
