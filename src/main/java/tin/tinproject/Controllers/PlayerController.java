package tin.tinproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tin.tinproject.DTO.PlayerDTO;
import tin.tinproject.DTO.PlayerWithBountyClaimsDTO;
import tin.tinproject.Service.PlayerService;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/relations/{id}")
    public ResponseEntity<PlayerWithBountyClaimsDTO> getPlayersWithBountyClaims(@PathVariable Long id) {
        PlayerWithBountyClaimsDTO players = playerService.getPlayersWithBountyClaims(id);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO createdPlayer = playerService.addPlayer(playerDTO);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> editPlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        PlayerDTO updatedPlayer = playerService.editPlayer(id, playerDTO);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePlayer(@PathVariable Long id) {
        playerService.removePlayer(id);
        return ResponseEntity.noContent().build();
    }
}