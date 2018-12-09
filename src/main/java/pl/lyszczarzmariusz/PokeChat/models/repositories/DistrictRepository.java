package pl.lyszczarzmariusz.PokeChat.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lyszczarzmariusz.PokeChat.models.DistrictModel;

import java.util.List;

public interface DistrictRepository extends CrudRepository<DistrictModel, Integer> {
    List<DistrictModel> findAllByCity(String city);
}
