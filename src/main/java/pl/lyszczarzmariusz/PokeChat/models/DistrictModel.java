package pl.lyszczarzmariusz.PokeChat.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "district")
@Data
@NoArgsConstructor
public class DistrictModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String city;
    String district;
    @Column(name = "district_escape_diacritics_lc")
    String districtEdLc;
}
