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
    @Column(name = "city_escape_diacritics_lc")
    String cityEdLc;

    public String escapeDiacritics(){

        return this.getCity().replace("ą", "a").replace("Ą", "A")
                .replace("ć", "c").replace("Ć", "C")
                .replace("ę", "e").replace("Ę", "E")
                .replace("ł", "l").replace("Ł", "L")
                .replace("ń", "n").replace("Ń", "N")
                .replace("ó", "o").replace("Ó", "O")
                .replace("ś", "s").replace("Ś", "S")
                .replace("ż", "z").replace("Ż", "Z")
                .replace("ź", "z").replace("Ź", "Z");
    }
}
