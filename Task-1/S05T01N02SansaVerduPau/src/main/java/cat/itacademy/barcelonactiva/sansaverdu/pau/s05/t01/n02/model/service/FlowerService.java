package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.service;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.entity.Flower;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface FlowerService {
    void saveFlower(Flower flower);

    void deleteFlower(int flowerId);

    Optional<FlowerDTO> getOne(int flowerId);

    List<FlowerDTO> getAll();
}
