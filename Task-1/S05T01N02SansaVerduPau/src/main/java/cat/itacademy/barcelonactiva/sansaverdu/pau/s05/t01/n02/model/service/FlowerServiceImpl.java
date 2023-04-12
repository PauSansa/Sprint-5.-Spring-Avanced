package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.service;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.entity.Flower;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.repository.FlowerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlowerServiceImpl implements FlowerService{
    private final FlowerRepository data;
    private final FlowerToDTO toDTO;

    public void saveFlower(Flower flower){
        data.save(flower);
    }

    public void deleteFlower(int flowerId){
        data.deleteById(flowerId);
    }

    public Optional<FlowerDTO> getOne(int flowerId){
        return data.findById(flowerId).map(toDTO);
    }

    public List<FlowerDTO> getAll(){
        return data
                .findAll()
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }

}
