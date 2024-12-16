package tin.tinproject.Service;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import tin.tinproject.DTO.BountyClaimDTO;
import tin.tinproject.DTO.PlayerDTO;
import tin.tinproject.DTO.PlayerWithBountyClaimsDTO;
import tin.tinproject.Model.Player;
import tin.tinproject.Repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerDTO> getAllPlayers() {
        return StreamSupport.stream(playerRepository.findAll().spliterator(), false)
                .map(player -> {
                    PlayerDTO playerDTO = new PlayerDTO();
                    playerDTO.setId(player.getId());
                    playerDTO.setName(player.getName());
                    playerDTO.setClazz(player.getClazz());
                    playerDTO.setSpeciality(player.getSpeciality());
                    playerDTO.setPersuasionLevel(player.getPersuasionLevel());
                    return playerDTO;
                })
                .collect(Collectors.toList());
    }
    public PlayerWithBountyClaimsDTO getPlayersWithBountyClaims(Long id) {
        Player player = playerRepository.findById(id).orElse(null);
        PlayerWithBountyClaimsDTO playerWithBountyClaimsDTO = new PlayerWithBountyClaimsDTO();
        playerWithBountyClaimsDTO.setClazz(player.getClazz());
        playerWithBountyClaimsDTO.setName(player.getName());
        playerWithBountyClaimsDTO.setSpeciality(player.getSpeciality());
        playerWithBountyClaimsDTO.setPersuasionLevel(player.getPersuasionLevel());
        playerWithBountyClaimsDTO.setId(player.getId());

        List<BountyClaimDTO> bountyClaimDTOS = player.getBountyClaims().stream()
                .map(bountyClaim -> {
                    BountyClaimDTO bountyClaimDTO = new BountyClaimDTO();
                    bountyClaimDTO.setBountyID(bountyClaim.getClaimID());
                    bountyClaimDTO.setPlayerID(bountyClaim.getPlayer().getId());
                    bountyClaimDTO.setClaimDate(bountyClaim.getClaimDate());
                    bountyClaimDTO.setFinishDate(bountyClaim.getFinishDate());
                    bountyClaimDTO.setClaimID(bountyClaim.getClaimID());
                    return bountyClaimDTO;
                }).collect(Collectors.toList());
        playerWithBountyClaimsDTO.setBountyClaims(bountyClaimDTOS);
        return playerWithBountyClaimsDTO;

    };
    public PlayerDTO addPlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setClazz(playerDTO.getClazz());
        player.setSpeciality(playerDTO.getSpeciality());
        player.setPersuasionLevel(playerDTO.getPersuasionLevel());
        Player savedPlayer = playerRepository.save(player);
        playerDTO.setId(savedPlayer.getId());
        return playerDTO;
    }

    public PlayerDTO editPlayer(Long id, PlayerDTO playerDTO) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setName(playerDTO.getName());
            player.setClazz(playerDTO.getClazz());
            player.setSpeciality(playerDTO.getSpeciality());
            player.setPersuasionLevel(playerDTO.getPersuasionLevel());
            playerRepository.save(player);
        }
        return playerDTO;
    }

    public void removePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}