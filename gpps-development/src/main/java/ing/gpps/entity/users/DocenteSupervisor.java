package ing.gpps.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ESTUDIANTE")
public class DocenteSupervisor extends Usuario implements Notificar {

    public DocenteSupervisor(String nombre, String apellido, String email, String password, Long num_telefono) {
        super(nombre, apellido, email, password, num_telefono);
    }

    @Override
    public String getRol() {
        return "DOCENTE_SUPERVISOR";
    }

    @Override
    public void notificar(String mensaje) {
        //TODO: Implementar la lógica de notificación para el Docente Supervisor
    }
}
