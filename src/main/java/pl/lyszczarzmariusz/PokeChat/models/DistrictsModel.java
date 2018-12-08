package pl.lyszczarzmariusz.PokeChat.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "districts")
@Data
@NoArgsConstructor
public class DistrictsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String city;
    String districts;
}
