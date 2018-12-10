package pl.lyszczarzmariusz.PokeChat.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RaidForm {
    private String city;
    private String district;
    private String nameGym;
    private String nameBoss;
    private int lvlBoss;
    private LocalDateTime start;
    private LocalDateTime end;
    private String description;

}
