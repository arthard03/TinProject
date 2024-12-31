package tin.tinproject.Controllers;

import jakarta.servlet.http.PushBuilder;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tin.tinproject.DTO.BountyClaimDTO;
import tin.tinproject.DTO.BountyClaimRelationDTO;
import tin.tinproject.Service.BountyClaimService;

import java.util.List;

@Controller
@RequestMapping("/bountiesClaim")
public class BountyClaimController {
    private  final BountyClaimService bountyClaimService;

    public BountyClaimController(BountyClaimService bountyClaimService) {
        this.bountyClaimService = bountyClaimService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<Page<BountyClaimDTO>> getAllBountyClaim(
            @RequestParam(defaultValue ="0") int page,
            @RequestParam(defaultValue ="2") int size
    ) {
        Page<BountyClaimDTO> bountyClaimDTOS = bountyClaimService.getAllBountyClaim(page,size);
        return  new ResponseEntity<>(bountyClaimDTOS, HttpStatus.OK);
    }
    @GetMapping("/relations/{id}")
    public ResponseEntity<BountyClaimRelationDTO> getAllBountyClaimRelations(@PathVariable Long id){
        BountyClaimRelationDTO bountyClaimRelationDTOS=bountyClaimService.getAllBountyClaimRealations(id);
        return  new ResponseEntity<>(bountyClaimRelationDTOS,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<BountyClaimDTO> addBountyClaim(@Valid @RequestBody BountyClaimDTO bountyClaimDTO){
        BountyClaimDTO saveBountyClaim = bountyClaimService.addBountyClaim(bountyClaimDTO);
        return  new ResponseEntity<>(saveBountyClaim,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<BountyClaimDTO> editBountyClaim(@PathVariable Long id,@Valid @RequestBody BountyClaimDTO bountyClaimDTO){
        BountyClaimDTO bountyClaimDTO1=bountyClaimService.editBountyClaim(id,bountyClaimDTO);
        return  new ResponseEntity<>(bountyClaimDTO1,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> removeBountyClaim(@PathVariable Long id){
        bountyClaimService.removeBountyClaim(id);
        return  ResponseEntity.noContent().build();
    }

}
