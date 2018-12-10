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
    private int id;
    private String city;
    private String district;
    @Column(name = "district_escape_diacritics_lc")
    private  String districtEdLc;

    public String escapeDiacritics(){

        return this.getDistrict().replace("ą", "a").replace("Ą", "A")
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
