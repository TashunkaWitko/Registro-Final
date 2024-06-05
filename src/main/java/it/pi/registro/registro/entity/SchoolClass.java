package it.pi.registro.registro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "school_class")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private boolean active = true;

    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL)
    private Set<UserSchoolClass> userSchoolClasses = new HashSet<>();

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                //", userSchoolClasses=" + userSchoolClasses +
                '}';
    }
}
