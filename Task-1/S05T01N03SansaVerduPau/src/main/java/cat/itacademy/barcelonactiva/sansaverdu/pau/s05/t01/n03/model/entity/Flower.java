package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n03.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flower {


    private Integer flowerId;

    private String flowerName;
    private String flowerCountry;
}
