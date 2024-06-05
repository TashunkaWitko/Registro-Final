package it.pi.registro.registro.entity;

import it.pi.registro.registro.enums.LangEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String lang;
    @Column
    private Boolean isDark;

    public Settings(String lang, Boolean isDark) {
        this.lang = lang;
        this.isDark = isDark;
    }


    //    @PrePersist
//    public void prePersist(){
//        this.lang = "en";
//        this.isDark = false;
//    }
}
