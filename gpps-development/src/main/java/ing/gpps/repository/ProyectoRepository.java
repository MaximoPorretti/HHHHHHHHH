package ing.gpps.repository;

import ing.gpps.entity.users.Estudiante;
import ing.gpps.entity.pps.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    List<Proyecto> findByEstudiante(Estudiante estudiante);
    Optional<Proyecto> findByEstudianteAndId(Estudiante estudiante, int id);
}
