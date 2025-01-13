package tin.tinproject.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import tin.tinproject.DTO.BountyClaimDTO;
import tin.tinproject.DTO.PlayerDTO;
import tin.tinproject.DTO.PlayerWithBountyClaimsDTO;
import tin.tinproject.Model.Player;
import tin.tinproject.Model.Role;
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
    public Page<PlayerDTO> getAllPlayers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Player> playerPage = (Page<Player>) playerRepository.findAll(pageable);

        return playerPage.map(player -> {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setName(player.getName());
            playerDTO.setClazz(player.getClazz());
            playerDTO.setSpeciality(player.getSpeciality());
            playerDTO.setPersuasionLevel(player.getPersuasionLevel());
            return playerDTO;
        });
    }
    public Page<PlayerDTO> getAllUserPlayers(int page, int size,String username) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Player> playerPage = playerRepository.findAllByUserName(username,pageable);


        return playerPage.map(player -> {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setName(player.getName());
            playerDTO.setClazz(player.getClazz());
            playerDTO.setSpeciality(player.getSpeciality());
            playerDTO.setPersuasionLevel(player.getPersuasionLevel());
            return playerDTO;
        });
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

    public PlayerDTO editPlayer(Long id, PlayerDTO playerDTO, Long userId, Role userRole) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player == null) {
            throw new IllegalArgumentException("Player not found");
        }
        if (!player.getUser().getId_user().equals(userId) && userRole != Role.ADMIN) {
            throw new SecurityException("You do not have permission to edit this player");
        }
        player.setName(playerDTO.getName());
        player.setClazz(playerDTO.getClazz());
        player.setSpeciality(playerDTO.getSpeciality());
        player.setPersuasionLevel(playerDTO.getPersuasionLevel());
        playerRepository.save(player);

        return playerDTO;
    }

    public void removePlayer(Long id,Long userId, Role userRole) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player == null) {
            throw new IllegalArgumentException("Player not found");
        }
        if (!player.getUser().getId_user().equals(userId) && userRole != Role.ADMIN) {
            throw new SecurityException("You do not have permission to edit this player");
        }
        playerRepository.deleteById(id);
    }
}