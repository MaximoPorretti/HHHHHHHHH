package ing.gpps.security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (hasRole(authorities, "ESTUDIANTE")) {
            response.sendRedirect("/indexAlumno");
        } else if (hasRole(authorities, "DOCENTE_SUPERVISOR")) {
            response.sendRedirect("/indexTutor");
        } else if (hasRole(authorities, "TUTOR_EXTERNO")) {
            response.sendRedirect("/indexEntidad");
        } else if (hasRole(authorities, "ADMIN")) {
            response.sendRedirect("/indexAdmin");
        } else {
            response.sendRedirect("/login");
        }
    }

    private boolean hasRole(Collection<? extends GrantedAuthority> authorities, String role) {
        return authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_" + role));
    }
}