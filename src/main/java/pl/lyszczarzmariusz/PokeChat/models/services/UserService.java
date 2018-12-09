package pl.lyszczarzmariusz.PokeChat.models.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.lyszczarzmariusz.PokeChat.models.UserModel;

import java.util.Optional;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {
    @Getter @Setter
    private Optional<UserModel> user;
}
