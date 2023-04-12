package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n03.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
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
