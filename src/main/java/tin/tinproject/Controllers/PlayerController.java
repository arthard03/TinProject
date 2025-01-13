package tin.tinproject.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tin.tinproject.DTO.PlayerDTO;
import tin.tinproject.DTO.PlayerWithBountyClaimsDTO;
import tin.tinproject.Model.User;
import tin.tinproject.Repository.UserRepository;
import tin.tinproject.Service.PlayerService;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;
private  final UserRepository userRepository;
    @Autowired
    public PlayerController(PlayerService playerService, UserRepository userRepository) {
        this.playerService = playerService;
        this.userRepository = userRepository;
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
    public ResponseEntity<PlayerDTO> editPlayer(@PathVariable Long id, @Valid @RequestBody PlayerDTO playerDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByName(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        PlayerDTO updatedPlayer = playerService.editPlayer(id, playerDTO, user.getId_user(), user.getRole());
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePlayer(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByName(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        playerService.removePlayer(id,user.getId_user(), user.getRole());
        return ResponseEntity.noContent().build();
    }
}