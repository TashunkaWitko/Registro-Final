package it.pi.registro.registro.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "subject_user")
@NoArgsConstructor
@Getter
@Setter
public class SubjectUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double vote;

    @Column
    private LocalDateTime vote_date;

    @Column
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("subjectUsers")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonIgnoreProperties("subjectUsers")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties("subjectUsers")
    private User teacher;

    @PrePersist
    public void prePersist(){
        this.vote_date = LocalDateTime.now();
        this.notes = this.notes != null && !this.notes.isEmpty() ? this.notes : "Nessuna nota";
    }
}
