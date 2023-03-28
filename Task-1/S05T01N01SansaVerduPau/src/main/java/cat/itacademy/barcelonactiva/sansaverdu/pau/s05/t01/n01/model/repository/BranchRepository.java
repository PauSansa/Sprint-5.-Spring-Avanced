package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Integer> {
}
