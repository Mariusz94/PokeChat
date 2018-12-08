package pl.lyszczarzmariusz.PokeChat.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
public class CityModel {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    int id;
    String city;
}
