package ing.gpps.service;

import ing.gpps.entity.users.Entrega;
import ing.gpps.entity.users.Proyecto;
import ing.gpps.repository.EntregaRepository;
import ing.gpps.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    public Proyecto obtenerProyectoPorNombre(String nombre) {
        return proyectoRepository.findByNombre(nombre).orElse(null);
    }
}

