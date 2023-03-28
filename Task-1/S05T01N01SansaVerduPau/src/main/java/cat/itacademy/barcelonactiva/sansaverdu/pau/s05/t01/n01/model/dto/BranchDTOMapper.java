package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.domain.Branch;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Service
public class BranchDTOMapper implements Function<Branch,BranchDTO> {
    @Override
    public BranchDTO apply(Branch branch) {
        BranchDTO dto = new BranchDTO();

        dto.setPk_BranchID(branch.getPk_BranchID());
        dto.setBranchName(branch.getBranchName());
        dto.setBranchCountry(branch.getBranchCountry());
        dto.setBranchType(getType(branch));
        return dto;
    }

    public String getType(Branch branch){
        List<String> paisosEU = Arrays.asList("alemania","austria","bélgica","bulgaria","chipre","croacia","dinamarca","eslovaquia","eslovenia","españa","estonia","finlandia","francia","grecia","hungria","irlanda","italia","letonia","lituania","luxemburgo","malta","países bajos","polonia","portugal","república checa","rumania","suecia");
        if(paisosEU.contains(branch.getBranchCountry().toLowerCase())){
            return "Inside EU";
        } else{
            return "Outside EU";
        }
    }
}
