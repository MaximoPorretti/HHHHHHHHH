package ing.gpps.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Usuario{

    public Admin(String nombre, String apellido, String email, String password, Long num_telefono) {
        super(nombre, apellido, email, password, num_telefono);
    }

    @Override
    public String getRol() {
        return "ADMIN";
    }
}
