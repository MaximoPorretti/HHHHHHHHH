package ing.gpps.repository;

import ing.gpps.entity.users.Entrega;
import ing.gpps.entity.users.Estudiante;
import ing.gpps.entity.users.Proyecto;
import ing.gpps.service.UsuarioService;

import java.time.LocalDate;

public class SetupDataBase {

    private final UsuarioService usuarioService;
    private final ProyectoRepository proyectoRepository;
    private final EntregaRepository entregaRepository;


    public SetupDataBase(UsuarioRepository usuarioRepository, UsuarioService usuarioService, EntregaRepository entregaRepository, ProyectoRepository proyectoRepository) {
        this.usuarioService = usuarioService;
        this.proyectoRepository = proyectoRepository;
        this.entregaRepository = entregaRepository;


        cargarDatos();
    }

    private void cargarDatos() {


        // Crear estudiantes
        Estudiante est1 = new Estudiante("Lautaro", "Salvo", "salvoschaferlautaro@gmail.com", "1234", 42658278L, 1521L, 2920219900L);
        Estudiante est2 = new Estudiante("Maximo", "Porreti", "porretimaxi@gmail.com", "2345", 46456214L, 1841L, 2920223500L);
        Estudiante est3 = new Estudiante("Tomas", "Acosta", "acostatomas@gmail.com", "3456", 45234765L, 4526L, 2920652378L);

        usuarioService.registrarUsuario(est1);
        usuarioService.registrarUsuario(est2);
        usuarioService.registrarUsuario(est3);

        // Crear proyectos y asociarlos a estudiantes
        Proyecto proyecto1 = new Proyecto();
        proyecto1.setNombre("Desarrollo de aplicación de ventas");
        proyecto1.setEntidad("Empresa Altec");
        proyecto1.setDescripcion("Aplicación web para gestión de inventario y ventas.");
        proyecto1.setTutorUnrn("Dra. María González");
        proyecto1.setTutorExterno("Ing. Juan Pérez");
        proyecto1.setFechaInicio(LocalDate.of(2025, 3, 15));
        proyecto1.setFechaFinEstimada(LocalDate.of(2025, 6, 15));
        proyecto1.setEstudiante(est1);
        proyectoRepository.save(proyecto1);

        est1.setProyecto(proyecto1);
        usuarioService.actualizarUsuario(est1);

        // Crear entregas y asociarlas a estudiantes
        Entrega entrega1 = new Entrega();
        entrega1.setTitulo("Entrega 1: Análisis de Requerimientos");
        entrega1.setFechaLimite(LocalDate.of(2025, 4, 30));
        entrega1.setEstado("Pendiente");
        entrega1.setEstudiante(est1);
        entregaRepository.save(entrega1);

        Entrega entrega2 = new Entrega();
        entrega2.setTitulo("Entrega 2: Diseño de Arquitectura");
        entrega2.setFechaLimite(LocalDate.of(2025, 5, 15));
        entrega2.setEstado("Pendiente");
        entrega2.setEstudiante(est1);
        entregaRepository.save(entrega2);

        Entrega entrega3 = new Entrega();
        entrega3.setTitulo("Entrega 3: Implementación del Módulo de Ventas");
        entrega3.setFechaLimite(LocalDate.of(2025, 6, 1));
        entrega3.setEstado("Pendiente");
        entrega3.setEstudiante(est1);
        entregaRepository.save(entrega3);
    }
}
