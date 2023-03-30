package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.services;


import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerShopServiceImpl implements FlowerShopService{
    @Autowired
    FlowerToDTO flowerToDTO;
    @Autowired
    FlowerRepository flowerData;

    public List<FlowerDTO> getAll(){
        return flowerData.findAll().stream().map(flowerToDTO).toList();
    }

    public Optional<FlowerDTO> getOne(int id){
        return flowerData.findById(id).map(flowerToDTO);
    }

    public Flower save(Flower flower){
        return flowerData.save(flower);
    }

    public boolean delete(int id){
        if(flowerData.existsById(id)){
            flowerData.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
