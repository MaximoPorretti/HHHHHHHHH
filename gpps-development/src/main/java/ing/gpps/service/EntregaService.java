package ing.gpps.service;


import ing.gpps.entity.users.Entrega;
import ing.gpps.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    public List<Entrega> obtenerEntregasPorProyectoId(Long proyectoId) {
        return entregaRepository.findByProyectoId(proyectoId);
    }
}