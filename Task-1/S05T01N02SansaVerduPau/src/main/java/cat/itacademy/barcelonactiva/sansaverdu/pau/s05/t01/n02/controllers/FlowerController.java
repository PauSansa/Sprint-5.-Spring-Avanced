package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.controllers;


import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.services.FlowerShopService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    FlowerShopService service;

    @GetMapping("/getAll")
    public List<FlowerDTO> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Flower flower){
        if(service.save(flower) != null){
            return ResponseEntity.status(201).body("The object has been created Successfully");
        }else{
            return ResponseEntity.status(400).body("There was an error creating the object");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(service.delete(id)){
            return ResponseEntity.status(200).body("The item has been deleted");
        } else {
            return ResponseEntity.status(404).body("Item not found");
        }
    }

    @GetMapping("/getone/{id}")
    public Optional<FlowerDTO> getOne(@PathVariable int id){
        return service.getOne(id);
    }

    //TODO implementar update
}
