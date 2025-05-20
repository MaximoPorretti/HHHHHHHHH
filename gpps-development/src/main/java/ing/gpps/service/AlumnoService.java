package ing.gpps.service;

import ing.gpps.entity.users.AlumnoConPPS;
import ing.gpps.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public AlumnoConPPS obtenerAlumnoPorLegajo(String legajo) {
        return alumnoRepository.findByLegajo(legajo).orElse(null);
    }
}
