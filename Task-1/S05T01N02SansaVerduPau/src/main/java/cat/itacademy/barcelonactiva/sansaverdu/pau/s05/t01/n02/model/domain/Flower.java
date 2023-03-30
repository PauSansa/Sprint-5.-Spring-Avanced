package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Flower {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int flowerId;
    private String flowerName;
    private String flowerCountry;
}
