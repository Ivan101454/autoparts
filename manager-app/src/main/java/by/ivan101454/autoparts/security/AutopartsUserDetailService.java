package by.ivan101454.autoparts.security;

import by.ivan101454.autoparts.repository.AutopartsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AutopartsUserDetailService implements UserDetailsService {

    private final AutopartsUserRepository autopartsUserRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return autopartsUserRepository.findByUsername(username)
                .map(user ->
                        User.builder()
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .authorities(user.getAuthorities().stream().map(authority -> authority.getRole().name())
                                        .map(SimpleGrantedAuthority::new).toList()
                                )
                                .build()).orElseThrow(() -> new UsernameNotFoundException("Нет такого пользователя %".formatted(username)));
    }
}
