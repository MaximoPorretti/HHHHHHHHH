package ing.gpps.entity.users;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TUTOR_EXTERNO")
public class TutorExterno extends Usuario implements Notificar{

    public TutorExterno(String nombre, String apellido, String email, String password, Long numTelefono) {
        super(nombre, apellido, email, password, numTelefono);
    }

    @Override
    public String getRol() {
        return "TUTOR_EXTERNO";
    }


    @Override
    public void notificar(String mensaje) {
        //TODO: Implementar la lógica de notificación para el Tutor Externo
    }
}

