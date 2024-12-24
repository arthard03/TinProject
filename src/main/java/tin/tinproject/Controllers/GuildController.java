package tin.tinproject.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tin.tinproject.DTO.GuildDTO;
import tin.tinproject.DTO.GuildRelationDTO;
import tin.tinproject.Service.GuildService;

import java.util.List;

@Controller
@RequestMapping("/guilds")
public class GuildController {
    private  final GuildService guildService;
@Autowired
    public GuildController(GuildService guildService) {
        this.guildService = guildService;
    };
 @GetMapping("/getAll")
    public ResponseEntity<Page<GuildDTO>> getAllGuilds(
            @RequestParam(defaultValue ="0") int page,
            @RequestParam(defaultValue ="2") int size){
        Page<GuildDTO> guilds =guildService.getAllGuilds(page,size);
        return  new ResponseEntity<>(guilds, HttpStatus.OK);

    };
    @GetMapping("/relations/{id}")
    public ResponseEntity<GuildRelationDTO> getGuildRelationsById(@PathVariable Long id) {
        GuildRelationDTO guildRelationDTO = guildService.getRelations(id);

        if (guildRelationDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(guildRelationDTO, HttpStatus.OK);
    }


    @PostMapping
    public  ResponseEntity<GuildDTO> addGuild(@Valid @RequestBody GuildDTO guildDTO){
    GuildDTO saveGuild = guildService.addGuild(guildDTO);
    return  new ResponseEntity<>(saveGuild,HttpStatus.OK);
    };
    @PutMapping("/{id}")
    public  ResponseEntity<GuildDTO> editGuild(@PathVariable Long id,@Valid @RequestBody GuildDTO guildDTO){
GuildDTO updateGuild=guildService.editGuild(id,guildDTO);
return new  ResponseEntity<>(updateGuild,HttpStatus.OK);
    };
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> removeGuild(@PathVariable Long id){
        guildService.removeGuild(id);
        return  ResponseEntity.noContent().build();
    };
}
