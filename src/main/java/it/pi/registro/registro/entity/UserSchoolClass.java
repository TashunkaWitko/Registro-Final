package it.pi.registro.registro.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_school_class")
@NoArgsConstructor
@Getter
@Setter
public class UserSchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime start_date;

    @Column
    private LocalDateTime end_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

    @Override
    public String toString() {
        return "UserSchoolClass{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", user=" + user +
                ", schoolClass=" + schoolClass +
                '}';
    }
}
