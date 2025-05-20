package ing.gpps.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Lógica para cargar datos necesarios en el dashboard
        return "indexAlumno"; // Usa tu template existente
    }

    @GetMapping("/sin-pps")
    public String sinPPS() {
        return "indexAlumnoSinPPS"; // Usa tu template existente
    }
}
