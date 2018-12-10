package pl.lyszczarzmariusz.PokeChat.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RegisterForm {
    @NotNull
    @Size(min = 4, max = 30)
    String name;
    @NotNull
    @Size(min = 6, max = 20)
    String password;
    @NotNull
    @Size(min = 6, max = 20)
    String repeatPassword;
    String team;
    @NotNull
    @Min(5)
    @Max(100)
    int age;
    @NotNull
    @Size(min = 3, max = 30)
    String city;
    @NotNull
    @Min(1)
    @Max(40)
    int lvl;

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
