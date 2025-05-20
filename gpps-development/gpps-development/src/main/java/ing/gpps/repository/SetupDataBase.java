package ing.gpps.repository;

import ing.gpps.entity.users.Estudiante;
import ing.gpps.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class SetupDataBase {


    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public SetupDataBase(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
        cargarDatos();
    }

    private void cargarDatos() {


        usuarioService.registrarUsuario(new Estudiante("Lautaro", "Salvo", "salvoschaferlautaro@gmail.com", "1234", 42658278L, 1521L, 2920219900L));
        usuarioService.registrarUsuario(new Estudiante("Maximo", "Porreti", "porretimaxi@gmail.com", "2345", 46456214L, 1841L, 2920223500L));
        usuarioService.registrarUsuario(new Estudiante("Tomas", "Acosta", "acostatomas@gmail.com", "3456", 45234765L, 4526L, 2920652378L));
    }
}
