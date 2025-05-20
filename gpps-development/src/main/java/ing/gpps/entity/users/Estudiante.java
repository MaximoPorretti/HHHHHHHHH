package ing.gpps.entity.users;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("ESTUDIANTE")
public class Estudiante extends Usuario {

    @Column(name = "dni", unique = true)
    Long dni;
    @Column(name = "legajo", unique = true)
    Long legajo;

    public Estudiante(String nombre, String apellido, String email, String password, Long dni, Long legajo, Long numTelefono) {
        super(nombre, apellido, email, password, numTelefono);
        this.dni = dni;
        this.legajo = legajo;
    }

    @Override
    public String getRol() {
        return "ESTUDIANTE";
    }
}
