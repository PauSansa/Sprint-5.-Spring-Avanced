package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.dto.BranchDTOMapper;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    private final BranchDTOMapper branchDTOMapper;
    @Autowired
    BranchRepository data;


    public EnterpriseServiceImpl(BranchDTOMapper branchDTOMapper) {
        this.branchDTOMapper = branchDTOMapper;
    }


    @Override
    public boolean save(Branch branch) {
        Branch saved = data.save(branch);
        if(saved == null){
            return false;
        }else {
            return true;
        }
    }



    @Override
    public List<BranchDTO> getAll() {
        return data.findAll().stream().map(branchDTOMapper).toList();
    }

    @Override
    public Optional<BranchDTO> getOne(int id) {
        Optional<Branch> branch = data.findById(id);
        return branch.map(branchDTOMapper);
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }


}
