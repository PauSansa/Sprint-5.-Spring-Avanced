package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.repository;


import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n02.model.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower,Integer> {
}
