package pl.lyszczarzmariusz.PokeChat.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lyszczarzmariusz.PokeChat.models.RaidModel;

import java.util.List;

public interface RaidRepository extends CrudRepository<RaidModel, Integer> {
    List<RaidModel> findAllByDistrict(String district);
}
