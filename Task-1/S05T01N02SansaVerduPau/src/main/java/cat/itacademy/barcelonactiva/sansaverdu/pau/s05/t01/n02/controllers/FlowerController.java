package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerRequest;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.entity.Flower;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.service.FlowerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/flor")
@AllArgsConstructor
public class FlowerController {
    private final FlowerService service;

    @PostMapping("/add")
    public ResponseEntity<String> addFlower(@RequestBody FlowerRequest fr){
        Flower flower = Flower.builder()
                .flowerName(fr.getFlowerName())
                .flowerCountry(fr.getFlowerCountry()).build();

        service.saveFlower(flower);
        return ResponseEntity.status(200).body("Successfully Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFlower(
            @PathVariable int id,
            @RequestBody FlowerRequest fr){
        Optional<FlowerDTO> dto = service.getOne(id);
        if(dto.isEmpty()){
            return ResponseEntity.status(404).body("Flower id not found");
        }
        Flower updated = dto.get().toEntity();
        updated.setFlowerName(fr.getFlowerName());
        updated.setFlowerCountry(fr.getFlowerCountry());
        service.saveFlower(updated);
        return ResponseEntity.status(200).body("Flower successfully updated");
    }

    @GetMapping("/getall")
    public List<FlowerDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/getone/{id}")
    public FlowerDTO getOne(@PathVariable int id){
        return service.getOne(id).orElseThrow(NoSuchElementException::new);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        if(service.getOne(id).isPresent()){
            service.deleteFlower(id);
            return ResponseEntity.status(202).body("Successfully deleted");
        } else {
            return ResponseEntity.status(404).body("Flower Not Found");
        }


    }

}
