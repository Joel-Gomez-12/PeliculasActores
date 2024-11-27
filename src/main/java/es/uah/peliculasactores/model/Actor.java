package es.uah.peliculasactores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "actores", schema = "peliculasactoresdb")
public class Actor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idActor", nullable = false)
    private Integer idActor;

    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Basic
    @Column(name = "fecha_nacimiento", nullable = false, columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    @Basic
    @Column(name = "pais_nacimiento",nullable = false, length = 45)
    private String paisNacimiento;

    @ManyToMany
    @JoinTable(name = "Peliculas_Has_Actores", joinColumns = {
            @JoinColumn(name = "Actores_idActor", referencedColumnName = "idActor")}, inverseJoinColumns = {
            @JoinColumn(name = "Peliculas_idPelicula", referencedColumnName = "idPelicula")})
    @JsonIgnoreProperties("actores")
    private List<Pelicula> peliculas;

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fecha_nacimiento) {
        this.fechaNacimiento = fecha_nacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String pais_nacimiento) {
        this.paisNacimiento = pais_nacimiento;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void addPelicula(Pelicula pelicula) {
        if (pelicula != null) {
            getPeliculas().add(pelicula);
            pelicula.addActor(this);
        }
    }

    public void removePelicula(Pelicula pelicula) {
        if (pelicula != null) {
            pelicula.removeActor(this);
            getPeliculas().remove(pelicula);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(idActor, actor.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActor);
    }


}