package tin.tinproject.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tin.tinproject.DTO.BountryRelationDTO;
import tin.tinproject.DTO.BountyDTO;
import tin.tinproject.Service.BountyService;

import java.util.List;

@Controller
@RequestMapping("/bounties")
public class BountyController {

    private final BountyService bountyService;
    public BountyController(BountyService bountyService) {
        this.bountyService = bountyService;
    };
    @GetMapping("/getAll")
    public ResponseEntity<List<BountyDTO>> getAllBounties() {
        List<BountyDTO> bountyDTOS = bountyService.getAllBounties();
        return  new ResponseEntity<>(bountyDTOS, HttpStatus.OK);
    };
    @GetMapping("/relations/{id}")
    public ResponseEntity<BountryRelationDTO>getAllBountiesRelations(@PathVariable Long id){
       BountryRelationDTO bountryRelationDTOS=bountyService.getAllBountyRelations(id);
       return  new ResponseEntity<>(bountryRelationDTOS,HttpStatus.OK);
    };
    @PostMapping
    public  ResponseEntity<BountyDTO> addBounty(@Valid @RequestBody BountyDTO bountyDTO){
       BountyDTO updateBounty= bountyService.addBounty(bountyDTO);
       return  new ResponseEntity<>(updateBounty, HttpStatus.OK);
    };
    @PutMapping("/{id}")
    public  ResponseEntity<BountyDTO> editBounty(@PathVariable Long id,@Valid @RequestBody BountyDTO bountyDTO) {
        BountyDTO editBounty = bountyService.editBounty(id, bountyDTO);
        return new ResponseEntity<>(bountyDTO, HttpStatus.OK);
    };
       @DeleteMapping("/{id}")
        public  ResponseEntity<Void> removeBounty(@PathVariable Long id){
           bountyService.removeBounty(id);
           return  ResponseEntity.noContent().build();
        };
    }

