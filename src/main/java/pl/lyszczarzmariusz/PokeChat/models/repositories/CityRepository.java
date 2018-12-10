package pl.lyszczarzmariusz.PokeChat.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lyszczarzmariusz.PokeChat.models.CityModel;

public interface CityRepository extends CrudRepository<CityModel, Integer> {
    boolean existsByCity (String city);
}
