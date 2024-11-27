package es.uah.peliculasactores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "peliculas" , schema = "peliculasactoresdb")
public class Pelicula {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPelicula", nullable = false)
    private Integer idPelicula;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "pais", length = 100)
    private String pais;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "genero", length = 100)
    private String genero;

    @Lob
    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "imagen_portada")
    private String imagenPortada;

    @ManyToMany(mappedBy = "peliculas")
    @JsonIgnoreProperties("peliculas")
    private List<Actor> actores;

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(String imagen_portada) {
        this.imagenPortada = imagen_portada;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public void addActor(Actor actor) {
        if (actor == null) {
            getActores().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActores().remove(actor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(idPelicula, pelicula.idPelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula);
    }

}