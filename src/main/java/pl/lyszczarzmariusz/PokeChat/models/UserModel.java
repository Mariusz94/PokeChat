package pl.lyszczarzmariusz.PokeChat.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String password;
    private String team;
    @Column(name = "year_birth")
    private int yearOfBirth;
    private String city;
    private int lvl;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "creation_date")
    private LocalDateTime creationTime;

    public String escapeDiacritics(){

        return this.getCity().replace("ą", "a").replace("Ą", "A")
                .replace("ć", "c").replace("Ć", "C")
                .replace("ę", "e").replace("Ę", "E")
                .replace("ł", "l").replace("Ł", "L")
                .replace("ń", "n").replace("Ń", "N")
                .replace("ó", "o").replace("Ó", "O")
                .replace("ś", "s").replace("Ś", "S")
                .replace("ż", "z").replace("Ż", "Z")
                .replace("ź", "z").replace("Ź", "Z")
                .replace(" ", "-");
    }
}
