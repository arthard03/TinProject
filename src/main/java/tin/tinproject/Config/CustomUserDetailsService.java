package tin.tinproject.Config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tin.tinproject.Model.User;
import tin.tinproject.Repository.UserRepository;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> appUser = userRepository.findByName(username);

        if (appUser.isEmpty()) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        User user = appUser.get();

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .authorities(Collections.emptyList())
                .build();
    }
}