package pl.lyszczarzmariusz.PokeChat.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lyszczarzmariusz.PokeChat.models.UserModel;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findByNameAndPassword(String name, String password);
    boolean existsByName(String name);
}
