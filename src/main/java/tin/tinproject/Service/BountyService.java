package tin.tinproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tin.tinproject.DTO.BountryRelationDTO;
import tin.tinproject.DTO.BountyClaimDTO;
import tin.tinproject.DTO.BountyDTO;
import tin.tinproject.DTO.GuildDTO;
import tin.tinproject.Model.Bounty;
import tin.tinproject.Model.BountyClaim;
import tin.tinproject.Model.Guild;
import tin.tinproject.Repository.BountyClaimRepository;
import tin.tinproject.Repository.BountyRepository;
import tin.tinproject.Repository.GuildRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BountyService {

    private  final BountyRepository bountyRepository;
    private  final GuildRepository guildRepository;
    private  final BountyClaimRepository bountyClaimRepository;
@Autowired
    public BountyService(BountyRepository bountyRepository, GuildRepository guildRepository, BountyClaimRepository bountyClaimRepository) {
        this.bountyRepository = bountyRepository;
        this.guildRepository = guildRepository;
        this.bountyClaimRepository = bountyClaimRepository;
    }
    public List<BountyDTO> getAllBounties(){
        return StreamSupport.stream(bountyRepository.findAll().spliterator(),false)
                .map(bounty -> {
                    BountyDTO bountyDTO=new BountyDTO();
                    bountyDTO.setBountyID(bounty.getBountyID());
                    bountyDTO.setReward(bounty.getReward());
                    bountyDTO.setStatus(bounty.getStatus());
                    bountyDTO.setDifficulty(bounty.getDifficulty());
                    bountyDTO.setDescription(bounty.getDescription());
                    return bountyDTO;
                }).collect(Collectors.toList());
    };
    public List<BountryRelationDTO> getAllBountyRelations() {
        return StreamSupport.stream(bountyRepository.findAll().spliterator(), false)
                .map(bounty -> {
                    BountryRelationDTO relationDTO = new BountryRelationDTO();
                    relationDTO.setBountyID(bounty.getBountyID());
                    relationDTO.setDescription(bounty.getDescription());
                    relationDTO.setReward(bounty.getReward());
                    relationDTO.setStatus(bounty.getStatus());
                    relationDTO.setDifficulty(bounty.getDifficulty());

                    Optional<BountyClaim> bountyClaims = bountyClaimRepository.findById(bounty.getBountyID());
                    relationDTO.setBountyClaims(bountyClaims.stream()
                            .map(claim -> {
                                BountyClaimDTO claimDTO = new BountyClaimDTO();
                                claimDTO.setClaimID(claim.getClaimID());
                                claimDTO.setClaimDate(claim.getClaimDate());
                                claimDTO.setFinishDate(claim.getFinishDate());
                                return claimDTO;
                            })
                            .collect(Collectors.toList()));

                    Guild guild = guildRepository.findById(bounty.getGuild().getGuildID()).orElse(null);
                    if (guild != null) {
                        GuildDTO guildDTO = new GuildDTO();
                        guildDTO.setGuildID(guild.getGuildID());
                        guildDTO.setName(guild.getName());
                        guildDTO.setDescription(guild.getDescription());
                        guildDTO.setMembers(guild.getMembers());
                        relationDTO.setGuildDTOS(List.of(guildDTO));
                    }

                    return relationDTO;
                })
                .collect(Collectors.toList());
    }
    public BountyDTO addBounty(BountyDTO bountyDTO) {
        Bounty bounty = new Bounty();
        bounty.setDescription(bountyDTO.getDescription());
        bounty.setDifficulty(bountyDTO.getDifficulty());
        bounty.setReward(bountyDTO.getReward());
        bounty.setStatus(bountyDTO.getStatus());
        Long guildId = bountyDTO.getGuildID();
        if (guildId != null) {
            Optional<Guild> guild = guildRepository.findById(guildId);
            if (guild.isPresent()) {
                bounty.setGuild(guild.get());
            } else {
                throw new RuntimeException("Guild with ID " + guildId + " not found.");
            }
        }
        Bounty savedBounty = bountyRepository.save(bounty);
        bountyDTO.setBountyID(savedBounty.getBountyID());
        return bountyDTO;
    }
public BountyDTO editBounty(Long id,BountyDTO bountyDTO){
    Bounty bounty=bountyRepository.findById(id).orElse(null);
    if(bounty!=null){
        bounty.setStatus(bountyDTO.getStatus());
        bounty.setReward(bountyDTO.getReward());
        bounty.setDescription(bountyDTO.getDescription());
        bounty.setDifficulty(bountyDTO.getDifficulty());
        bountyRepository.save(bounty);
    }
    return bountyDTO;
};
public void removeBounty(Long id){
    bountyRepository.deleteById(id);
}

}
