package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerDTO;

import java.util.List;
import java.util.Optional;

public interface FlowerShopService {
    List<FlowerDTO> getAll();
    Optional<FlowerDTO> getOne(int id);
    Flower save(Flower flower);
    boolean delete(int id);
}
