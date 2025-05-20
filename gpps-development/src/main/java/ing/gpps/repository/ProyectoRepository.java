package ing.gpps.repository;

import ing.gpps.entity.users.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    Optional<Proyecto> findByNombre(String nombre);
}


