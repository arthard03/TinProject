package tin.tinproject.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    //    http://localhost:8080/Tavern/players/getAll?page=2&size=2
    @GetMapping("/getAll")
    public ResponseEntity<Page<PlayerDTO>> getAllPlayers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        Page<PlayerDTO> players = playerService.getAllPlayers(page, size);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/relations/{id}")
    public ResponseEntity<PlayerWithBountyClaimsDTO> getPlayersWithBountyClaims(@PathVariable Long id) {
        PlayerWithBountyClaimsDTO players = playerService.getPlayersWithBountyClaims(id);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> addPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        PlayerDTO createdPlayer = playerService.addPlayer(playerDTO);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> editPlayer(@PathVariable Long id,@Valid @RequestBody PlayerDTO playerDTO) {
        PlayerDTO updatedPlayer = playerService.editPlayer(id, playerDTO);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePlayer(@PathVariable Long id) {
        playerService.removePlayer(id);
        return ResponseEntity.noContent().build();
    }
}