package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.entity.Flower;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlowerDTO {
    private Integer flowerId;

    private String flowerName;
    private String flowerCountry;
    private String flowerKind;

    public Flower toEntity(){

        return Flower.builder()
                .flowerId(this.flowerId)
                .flowerName(this.flowerName)
                .flowerCountry(this.flowerCountry)
                .build();
    }
}
