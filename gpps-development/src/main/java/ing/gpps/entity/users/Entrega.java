package ing.gpps.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private LocalDate fechaLimite;
    private String estado;
    private String archivoEjemplo;

    @ManyToOne
    private Proyecto proyecto;

    public void setTitulo(String s) {
    }

    public void setFechaLimite(LocalDate of) {
    }

    public void setEstado(String pendiente) {
    }

    public void setEstudiante(Estudiante est1) {
    }

    // Getters y Setters
}
