package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n03.controllers;


import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n03.model.entity.FlowerDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flor")
@AllArgsConstructor
public class ApiController {

    private final WebClient.Builder webClientBuilder;

    @GetMapping("/clientFlorsGetOne/{id}")
    public Mono<FlowerDTO> getone(@PathVariable int id){

        return webClientBuilder.build()
                .get()
                .uri("/getOne/" + id)
                .retrieve()
                .bodyToMono(FlowerDTO.class);
    }

    @GetMapping("/clientFlorsAll")
    public Flux<FlowerDTO> getAll(){
        return webClientBuilder.build()
                .get()
                .uri("/getall")
                .retrieve()
                .bodyToFlux(FlowerDTO.class);
    }

    @PostMapping("/clientFlorsAdd")
    public Mono<String> addFlower(@RequestBody FlowerRequest fr){
        return webClientBuilder.build()
                .post()
                .uri("/add")
                .bodyValue(fr)
                .retrieve()
                .bodyToMono(String.class);
    }

    @PutMapping("/clientFlorsUpdate/{id}")
    public Mono<String> updateFlower(@RequestBody FlowerRequest fr, @PathVariable int id){
        return webClientBuilder.build()
                .put()
                .uri("/update/{id}",id)
                .bodyValue(fr)
                .retrieve()
                .bodyToMono(String.class);
    }

    @DeleteMapping("/clientFlorsDelete/{id}")
    public Mono<String> deleteFlower(@PathVariable int id){
        return webClientBuilder.build()
                .delete()
                .uri("/delete/{id}",id)
                .retrieve()
                .bodyToMono(String.class);
    }

}
