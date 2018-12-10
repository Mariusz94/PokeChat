package pl.lyszczarzmariusz.PokeChat.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "raid")
@Data
@NoArgsConstructor
public class RaidModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;
    private String district;
    @Column(name = "name_gym")
    private String nameGym;
    @Column(name = "name_boss")
    private String nameBoss;
    @Column(name = "lvlBoss")
    private int lvlBoss;
    private LocalDateTime start;
    private LocalDateTime end;
    private String description;
    @Column(name = "time_add")
    private LocalDateTime timeAdd;

    @Override
    public String toString() {
        return "RaidModel{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", nameGym='" + nameGym + '\'' +
                ", nameBoss='" + nameBoss + '\'' +
                ", lvlBoss=" + lvlBoss +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }
}
