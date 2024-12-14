package tin.tinproject.Service;

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
    public List<PlayerWithBountyClaimsDTO> getPlayersWithBountyClaims() {
        return StreamSupport.stream(playerRepository.findAll().spliterator(), false)
                .map(player -> {
                    PlayerWithBountyClaimsDTO playerDTO = new PlayerWithBountyClaimsDTO();
                    playerDTO.setId(player.getId());
                    playerDTO.setName(player.getName());
                    playerDTO.setClazz(player.getClazz());
                    playerDTO.setSpeciality(player.getSpeciality());
                    playerDTO.setPersuasionLevel(player.getPersuasionLevel());

                    List<BountyClaimDTO> bountyClaimDTOs = player.getBountyClaims().stream()
                            .map(bountyClaim -> {
                                BountyClaimDTO bountyClaimDTO = new BountyClaimDTO();
                                bountyClaimDTO.setClaimID(bountyClaim.getClaimID());
                                bountyClaimDTO.setClaimDate(bountyClaim.getClaimDate());
                                bountyClaimDTO.setFinishDate(bountyClaim.getFinishDate());
                                return bountyClaimDTO;
                            })
                            .collect(Collectors.toList());

                    playerDTO.setBountyClaims(bountyClaimDTOs);
                    return playerDTO;
                })
                .collect(Collectors.toList());
    }
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