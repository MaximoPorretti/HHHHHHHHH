package ing.gpps.controller;

import ing.gpps.entity.users.AlumnoConPPS;
import ing.gpps.entity.users.Entrega;
import ing.gpps.entity.users.Proyecto;
import ing.gpps.service.AlumnoService;
import ing.gpps.service.EntregaService;
import ing.gpps.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <-- IMPORT CORRECTO
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private EntregaService entregaService;

    @GetMapping("/indexAlumno")
    public String mostrarIndexAlumno(Model model, Principal principal) {
        String legajo = principal.getName();
        AlumnoConPPS alumno = alumnoService.obtenerAlumnoPorLegajo(legajo);

        if (alumno == null) {
            model.addAttribute("error", "Alumno no encontrado.");
            return "error"; // O la vista que uses para errores
        }

        model.addAttribute("alumno", alumno);

        Proyecto proyecto = alumno.getProyecto();

        if (proyecto != null) {
            List<Entrega> entregas = entregaService.obtenerEntregasPorProyectoId(proyecto.getId());
            model.addAttribute("proyecto", proyecto);
            model.addAttribute("entregas", entregas);
        } else {
            model.addAttribute("mensaje", "No tiene proyecto asignado aún.");
        }

        return "indexAlumno";
    }

}
