package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
    Optional<AuthUser> findByUsername(String login);
}
