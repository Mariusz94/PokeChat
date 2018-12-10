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
    int id;
    String name;
    String password;
    String team;
    @Column(name = "year_birth")
    int yearOfBirth;
    String city;
    int lvl;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "creation_date")
    private LocalDateTime creationTime;
}
