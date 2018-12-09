package pl.lyszczarzmariusz.PokeChat.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterForm {
    String name;
    String password;
    String repeatPassword;
    String team;
    int age;
    String city;
    int lvl;
}
