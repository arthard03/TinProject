package tin.tinproject.Controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import tin.tinproject.DTO.UserDTO;
import tin.tinproject.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<UserDTO>>getAllUsers(
            @RequestParam(defaultValue ="0") int page,
            @RequestParam(defaultValue = "2")int size) {
        Page<UserDTO> userDTOS=userService.getAllUsers(page,size);
return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }
}
