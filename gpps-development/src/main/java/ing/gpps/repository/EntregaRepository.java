package ing.gpps.repository;

import ing.gpps.entity.users.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    List<Entrega> findByProyectoId(Long proyectoId);
}