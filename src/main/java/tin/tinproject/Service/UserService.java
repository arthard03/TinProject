package tin.tinproject.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tin.tinproject.DTO.UserDTO;
import tin.tinproject.Model.User;
import tin.tinproject.Repository.UserRepository;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserDTO> getAllUsers(int page,int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<User> userPage = (Page<User>) userRepository.findAll(pageable);
       return  userPage.map(user -> {
           UserDTO userDTO =new UserDTO();
           userDTO.setId(user.getId_user());
           userDTO.setName(user.getName());
           userDTO.setRole(String.valueOf(user.getRole()));
           return  userDTO;
       });
    }
}
