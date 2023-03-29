package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.domain;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Branch {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_BranchID;
    private String branchName;
    private String branchCountry;
}
