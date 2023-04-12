package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowerRequest {
    private String flowerName;
    private String flowerCountry;
}
