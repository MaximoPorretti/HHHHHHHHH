package ing.gpps.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        // Si el usuario ya está autenticado, redirigir según su rol
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !auth.getName().equals("anonymousUser")) {
            if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ESTUDIANTE"))) {
                return "redirect:/indexAlumno";
            } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_TUTOR"))) {
                return "redirect:/indexTutor";
            } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ENTIDAD"))) {
                return "redirect:/indexEntidad";
            } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                return "redirect:/indexAdmin";
            }
        }
        return "login";
    }

    @GetMapping("/indexAlumno")
    public String showIndexAlumno() {
        return "indexAlumno";
    }

    @GetMapping("/indexAlumnoSinPPS")
    public String showIndexAlumnoSinPPS() {
        return "indexAlumnoSinPPS";
    }

    @GetMapping("/indexAdmin")
    public String showIndexAdminPage() {
        return "indexAdmin";
    }

    @GetMapping("/indexTutor")
    public String showIndexTutor() {
        return "indexTutor";
    }

    @GetMapping("/indexEntidad")
    public String showIndexEntidad() {
        return "indexEntidad";
    }

    @GetMapping("/")
    public String home(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ESTUDIANTE"))) {
                return "redirect:/indexAlumno";
            } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_TUTOR"))) {
                return "redirect:/indexTutor";
            } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ENTIDAD"))) {
                return "redirect:/indexEntidad";
            } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                return "redirect:/indexAdmin";
            }
        }
        return "redirect:/login";
    }
}