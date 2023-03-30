package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Service
public class FlowerToDTO implements Function<Flower,FlowerDTO> {
    private final List<String> ueCountries = Arrays.asList("alemania","germany","austria","austria","bélgica","belgium","bulgaria","bulgaria","chipre","cyprus","croacia","croatia","dinamarca","denmark","eslovaquia","slovakia","eslovenia","slovenia","españa","spain","estonia","estonia","finlandia","finland","francia","france","grecia","greece","hungría","hungary","irlanda","ireland","italia","italy","letonia","latvia","lituania","lithuania","luxemburgo","luxembourg","malta","malta","países bajos","netherlands","polonia","poland","portugal","portugal","reino unido","united kingdom","república checa","czech republic","romania","romania","suecia","sweden");

    @Override
    public FlowerDTO apply(Flower flower) {
        FlowerDTO dto = new FlowerDTO();
        dto.setFlowerId(flower.getFlowerId());
        dto.setFlowerName(flower.getFlowerName());
        dto.setFlowerCountry(flower.getFlowerCountry());
        dto.setFlowerType(getType(flower));
        return dto;
    }

    public String getType(Flower flower){
        if(ueCountries.contains(flower.getFlowerCountry().toLowerCase())){
            return "Inside UE";
        }else{
            return "Outside UE";
        }
    }
}
