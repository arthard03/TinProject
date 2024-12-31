package tin.tinproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tin.tinproject.DTO.*;
import tin.tinproject.Model.Bounty;
import tin.tinproject.Model.BountyClaim;
import tin.tinproject.Model.Player;
import tin.tinproject.Repository.BountyClaimRepository;
import tin.tinproject.Repository.BountyRepository;
import tin.tinproject.Repository.PlayerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BountyClaimService {
    private  final BountyClaimRepository bountyClaimRepository;
    private  final BountyRepository bountyRepository;
    private  final PlayerRepository playerRepository;

@Autowired
    public BountyClaimService(BountyClaimRepository bountyClaimRepository, BountyRepository bountyRepository, PlayerRepository playerRepository) {
        this.bountyClaimRepository = bountyClaimRepository;
        this.bountyRepository = bountyRepository;
        this.playerRepository = playerRepository;
    }
    public Page<BountyClaimDTO> getAllBountyClaim(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<BountyClaim> bountyClaimPage =(Page<BountyClaim>)  bountyClaimRepository.findAll(pageable);
return bountyClaimPage.map(bountyClaim -> {
        BountyClaimDTO bountyClaimDTO=new BountyClaimDTO();
                   bountyClaimDTO.setClaimID(bountyClaim.getClaimID());
                   bountyClaimDTO.setClaimDate(bountyClaim.getClaimDate());
                   bountyClaimDTO.setFinishDate(bountyClaim.getFinishDate());
                   bountyClaimDTO.setPlayerID(bountyClaim.getPlayer().getId());
                   bountyClaimDTO.setBountyID(bountyClaim.getBounty().getBountyID());
                   return  bountyClaimDTO;
});
};
public  BountyClaimRelationDTO getAllBountyClaimRealations(Long id){
    BountyClaim bountyClaim = bountyClaimRepository.findById(id).orElse(null);
                BountyClaimRelationDTO bountyClaimDTO=new BountyClaimRelationDTO();
                bountyClaimDTO.setClaimID(bountyClaim.getClaimID());
                bountyClaimDTO.setClaimDate(bountyClaim.getClaimDate());
                bountyClaimDTO.setFinishDate(bountyClaim.getFinishDate());
                Optional<Bounty> bounty= bountyRepository.findById(bountyClaim.getClaimID());
                bountyClaimDTO.setBountyDTOS(bounty.stream()
                        .map(bounty1 -> {
                            BountyDTO bountyDTO=new BountyDTO();
                            bountyDTO.setBountyID(bounty1.getBountyID());
                            bountyDTO.setDifficulty(bounty1.getDifficulty());
                            bountyDTO.setDescription(bounty1.getDescription());
                            bountyDTO.setStatus(bounty1.getStatus());
                            bountyDTO.setReward(bounty1.getReward());
                            bountyDTO.setGuildID(bounty1.getGuild().getGuildID());
                            return bountyDTO;
                        }).collect(Collectors.toList()));
                Player player=playerRepository.findById(bountyClaim.getPlayer().getId()).orElse(null);
                if(player!=null){
                    PlayerDTO playerDTO= new PlayerDTO();
                    playerDTO.setId(player.getId());
                    playerDTO.setName(player.getName());
                    playerDTO.setClazz(player.getClazz());
                    playerDTO.setSpeciality(player.getSpeciality());
                    playerDTO.setPersuasionLevel(player.getPersuasionLevel());
                    bountyClaimDTO.setPlayerDTOS(List.of(playerDTO));
                }
                return  bountyClaimDTO;
            }
//2023-11-26
public  BountyClaimDTO addBountyClaim(BountyClaimDTO bountyClaimDTO) {
    BountyClaim bountyClaim = new BountyClaim();
    bountyClaim.setClaimDate(bountyClaimDTO.getClaimDate());
    bountyClaim.setFinishDate(bountyClaimDTO.getFinishDate());
    bountyClaim.setClaimID(bountyClaimDTO.getClaimID());
    Long playerId = bountyClaimDTO.getPlayerID();
    Long bountyId = bountyClaimDTO.getBountyID();
    if (playerId != null && bountyId != null) {
        Optional<Player> player = playerRepository.findById(playerId);
        Optional<Bounty> bounty = bountyRepository.findById(bountyId);
        if (player.isPresent() && bounty.isPresent()) {
            bountyClaim.setPlayer(player.get());
            bountyClaim.setBounty(bounty.get());
        } else {
            throw new RuntimeException("Player" + playerId + "or Bounty" + bountyId + "does not exsists");
        }
    }
        BountyClaim saveBountyClaim = bountyClaimRepository.save(bountyClaim);
        bountyClaimDTO.setClaimID(saveBountyClaim.getClaimID());
        return bountyClaimDTO;

}
    public BountyClaimDTO editBountyClaim(Long id, BountyClaimDTO bountyClaimDTO) {
        BountyClaim bountyClaim = bountyClaimRepository.findById(id).orElse(null);
        if (bountyClaim != null) {
            bountyClaim.setClaimDate(bountyClaimDTO.getClaimDate());
            bountyClaim.setFinishDate(bountyClaimDTO.getFinishDate());

            Optional<Player> newPlayer = playerRepository.findById(bountyClaimDTO.getPlayerID());
            Optional<Bounty> newBounty = bountyRepository.findById(bountyClaimDTO.getBountyID());
            if (newPlayer.isPresent()) {
                bountyClaim.setPlayer(newPlayer.get());
            }
            if (newBounty.isPresent()) {
                bountyClaim.setBounty(newBounty.get());
            } else {
              throw new RuntimeException("bad");
            }

            bountyClaimRepository.save(bountyClaim);
        }
        return bountyClaimDTO;
    }

public void removeBountyClaim(Long id){
    bountyClaimRepository.deleteById(id);
}
}
