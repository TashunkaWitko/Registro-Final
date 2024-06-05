package it.pi.registro.registro.entity;

import it.pi.registro.registro.constant.Constants;
import it.pi.registro.registro.enums.UserTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 1, message = "Id must be positive and not 0")
    private Long id;
    @NotBlank(message = "Il nome non può essere vuoto")
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean isActive;
    @Column(nullable = false)
    private LocalDate birth_date;
    @Column
    private LocalDateTime createdDate;
    @Column
    private LocalDateTime updatedDate;

    private String activeClass;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_detail_id", referencedColumnName = "id")
    private UserDetail userDetail;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    private UserType userType;

    @OneToMany(mappedBy = "student")
    private Set<Attendance> attendances;

    @OneToMany(mappedBy = "user")
    private Set<UserSchoolClass> userSchoolClasses = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<SubjectUser> subjectUsers = new HashSet<>();

    public User(String firstName, String lastName, String email, String password, LocalDate birth_date,
                String address, String city, UserType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
        this.userDetail = new UserDetail(address, city);
        this.userType = type;
    }

    public String getActiveClass() {
        String activeClass = Constants.NO_CLASS;
        for(UserSchoolClass userSchoolClass : this.getUserSchoolClasses()){
            if(userSchoolClass.getEnd_date() == null){
                activeClass = userSchoolClass.getSchoolClass().getName();
                break;
            }
        }
        return activeClass;
    }

    @PrePersist
    public void prePersist(){

        this.isActive = true;
        this.password = "123456";
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedDate = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birth_date=" + birth_date +
                ", userDetail=" + userDetail +
                ", userType=" + userType +
                '}';
    }
}

