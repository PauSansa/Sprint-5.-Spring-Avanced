package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.dto.BranchDTO;

import java.util.List;
import java.util.Optional;


public interface EnterpriseService {
    boolean save(Branch branch);
    List<BranchDTO> getAll();
    Optional<BranchDTO> getOne(int id);
    void delete(int id);

}
