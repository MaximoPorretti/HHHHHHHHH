package ing.gpps.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String entidad;
    private String tutorUnrn;
    private String tutorExterno;
    private LocalDate fechaInicio;
    private LocalDate fechaFinEstimada;

    @Column(length = 1000)
    private String descripcion;

    @ElementCollection
    private List<String> objetivos;
    // Getters y Setters
    public Long getId() {
        return this.id;
    }

    public void setNombre(String desarrolloDeAplicaciónDeVentas) {
        
    }


    public void setEstudiante(Estudiante est1) {
    }

    public void setFechaFinEstimada(LocalDate of) {
    }

    public void setFechaInicio(LocalDate of) {
    }

    public void setTutorExterno(String s) {
    }

    public void setTutorUnrn(String s) {
    }

    public void setDescripcion(String s) {
    }

    public void setEntidad(String empresaAltec) {
    }
}


