package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.service;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.entity.Flower;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Service
public class FlowerToDTO implements Function<Flower, FlowerDTO> {
    private final List<String> UE_COUNTRIES = Arrays.asList("austria", "austria", "belgium", "bélgica", "bulgaria", "bulgaria", "croatia", "croacia", "cyprus", "chipre", "czech republic", "república checa", "denmark", "dinamarca", "estonia", "estonia", "finland", "finlandia", "france", "francia", "germany", "alemania", "greece", "grecia", "hungary", "hungría", "ireland", "irlanda", "italy", "italia", "latvia", "letonia", "lithuania", "lituania", "luxembourg", "luxemburgo", "malta", "malta", "netherlands", "países bajos", "poland", "polonia", "portugal", "portugal", "romania", "rumania", "slovakia", "eslovaquia", "slovenia", "eslovenia", "spain", "españa", "sweden", "suecia");

    @Override
    public FlowerDTO apply(Flower flower) {
        return
        FlowerDTO.builder()
                .flowerId(flower.getFlowerId())
                .flowerName(flower.getFlowerName())
                .flowerCountry(flower.getFlowerCountry())
                .flowerKind(getKind(flower))
                .build();
    }

    public String getKind(Flower flower){
        if(UE_COUNTRIES.contains(flower.getFlowerCountry().toLowerCase())){
            return "INSIDE UE";
        }else{
            return "OUTSIDE UE";
        }
    }
}
