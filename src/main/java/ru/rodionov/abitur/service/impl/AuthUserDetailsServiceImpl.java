package ru.rodionov.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rodionov.abitur.config.AuthUserDetails;
import ru.rodionov.abitur.repository.AuthUserRepository;

@Service
@AllArgsConstructor
@Slf4j
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        log.info("Попытка загрузки пользователя с логином: {}", login);
        return authUserRepository.findByUsername(login)
                .map(AuthUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Авторизированный пользователь с таким %s не найден", login)));
    }
}
