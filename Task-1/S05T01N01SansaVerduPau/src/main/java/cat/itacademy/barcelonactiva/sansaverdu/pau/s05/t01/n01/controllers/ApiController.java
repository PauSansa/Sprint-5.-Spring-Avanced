package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class ApiController{

    @Autowired
    EnterpriseService  service;

    @PostMapping("/add")
    public ResponseEntity addBranch(@RequestParam String name, @RequestParam String country){
        Branch branch  = new Branch();
        branch.setBranchName(name);
        branch.setBranchCountry(country);

        if (service.save(branch)){
            return ResponseEntity.status(201).body("The Object has been created");
        } else{
            return ResponseEntity.status(500).body("The Object hasn't been created");
        }
    }

    @GetMapping("/getAll")
    public List<BranchDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity getOne(@PathVariable int id){
        Optional<BranchDTO> branch = service.getOne(id);
        if(branch.isEmpty()){
            return ResponseEntity.status(404).body("The sended id doesn't exists");
        } else{
            return ResponseEntity.of(branch);
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.status(200).body("Ok");
    }
}
