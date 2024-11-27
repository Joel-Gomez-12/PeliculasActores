package es.uah.peliculasactores.service;

import es.uah.peliculasactores.model.Pelicula;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodas();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculasPorTitulo(String titulo);

    List<Pelicula> buscarPeliculasPorGenero(String genero);

    void guardarPelicula(Pelicula pelicula);

    void actualizarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer idPelicula);
}
