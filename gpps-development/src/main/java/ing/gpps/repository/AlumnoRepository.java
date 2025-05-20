package ing.gpps.repository;

import ing.gpps.entity.users.AlumnoConPPS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AlumnoRepository extends JpaRepository<AlumnoConPPS, Long> {
    Optional<AlumnoConPPS> findByLegajo(String legajo);
}
