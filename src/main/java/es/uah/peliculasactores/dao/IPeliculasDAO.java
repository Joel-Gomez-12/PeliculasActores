package es.uah.peliculasactores.dao;

import es.uah.peliculasactores.model.Pelicula;

import java.util.List;

public interface IPeliculasDAO {

    List<Pelicula> buscarTodas();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculasPorTitulo(String titulo);

    List<Pelicula> buscarPeliculasPorGenero(String genero);

    void guardarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer idPelicula);

    void actualizarPelicula(Pelicula pelicula);

}
