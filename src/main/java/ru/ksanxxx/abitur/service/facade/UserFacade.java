package ru.ksanxxx.abitur.service.facade;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;
import ru.ksanxxx.abitur.service.AbiturientService;
import ru.ksanxxx.abitur.service.AuthService;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserFacade {

    private final AuthService authService;
    private final AbiturientService abiturientService;

    @Transactional(readOnly = true)
    public List<Abiturient> getAbiturients() {
        return abiturientService.getAllAbiturients();
    }

    @Transactional
    public void saveUser(CreateClientRequest createClientRequest) {
        authService.save(createClientRequest);
    }

    @Transactional(readOnly = true)
    public Abiturient getAbiturient(Integer id) {
        return abiturientService.getAbiturientById(id);
    }

    @Transactional
    public void saveAbiturient(Abiturient abiturient) {
        abiturientService.save(abiturient);
    }

    @Transactional
    public void deleteAbiturient(Integer id) {
        Abiturient abiturient = abiturientService.getAbiturientById(id);
        abiturientService.delete(abiturient);
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
               && !(authentication.getPrincipal() instanceof String);
    }

    public boolean isAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_ADMIN"));
    }

    public boolean isOperator() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_OPERATOR"));
    }

    public boolean isEditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_EDITOR"));
    }
}
