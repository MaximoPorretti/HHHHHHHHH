package ing.gpps.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AlumnoConPPS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Usuario usuario;
    @ManyToOne
    private Proyecto proyecto;

    public Proyecto getProyecto() {
        return this.proyecto;
    }

    // Getters y Setters

}
