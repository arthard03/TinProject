package tin.tinproject.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import tin.tinproject.DTO.BountyDTO;
import tin.tinproject.DTO.GuildDTO;
import tin.tinproject.DTO.GuildRelationDTO;
import tin.tinproject.Model.Guild;
import tin.tinproject.Repository.GuildRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GuildService {
    private  final GuildRepository guildRepository;

    public GuildService(GuildRepository guildRepository) {
        this.guildRepository = guildRepository;
    }
    public Page<GuildDTO> getAllGuilds(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<Guild> guildPage =(Page<Guild>) guildRepository.findAll(pageable);
        return guildPage.map(guild -> {
            GuildDTO guildDTO =new GuildDTO();
            guildDTO.setGuildID(guild.getGuildID());
            guildDTO.setName(guild.getName());
            guildDTO.setDescription(guild.getDescription());
            guildDTO.setMembers(guild.getMembers());
            return guildDTO;
        });
    }
    public GuildRelationDTO getRelations(Long id) {
        Guild guild =guildRepository.findById(id).orElse(null);

        GuildRelationDTO guildRelationDTO = new GuildRelationDTO();
        guildRelationDTO.setGuildID(guild.getGuildID());
        guildRelationDTO.setName(guild.getName());
        guildRelationDTO.setDescription(guild.getDescription());
        guildRelationDTO.setMembers(guild.getMembers());

        List<BountyDTO> bountyDTOs = guild.getBounties().stream()
                .map(bounty -> {
                    BountyDTO bountyDTO = new BountyDTO();
                    bountyDTO.setBountyID(bounty.getBountyID());
                    bountyDTO.setDescription(bounty.getDescription());
                    bountyDTO.setDifficulty(bounty.getDifficulty());
                    bountyDTO.setReward(bounty.getReward());
                    bountyDTO.setStatus(bounty.getStatus());
                    bountyDTO.setGuildID(bounty.getGuild().getGuildID());
                    return bountyDTO;
                })
                .collect(Collectors.toList());

        guildRelationDTO.setBounty(bountyDTOs);

        return guildRelationDTO;
    }
    public GuildDTO addGuild(GuildDTO guildDTO){
        Guild guild=new Guild();
        guild.setName(guildDTO.getName());
        guild.setDescription(guildDTO.getName());
        guild.setMembers(guildDTO.getMembers());
        Guild saveGuild=guildRepository.save(guild);
        guildDTO.setGuildID(saveGuild.getGuildID());
        return  guildDTO;
    };
    public  GuildDTO editGuild(Long id,GuildDTO guildDTO){
        Guild guild =guildRepository.findById(id).orElse(null);
        if(guild!=null){
            guild.setName(guildDTO.getName());
            guild.setDescription(guildDTO.getDescription());
            guild.setMembers(guildDTO.getMembers());
            guildRepository.save(guild);

        }
        return guildDTO;
    };

    public  void removeGuild(Long id){
        guildRepository.deleteById(id);
    }
}
