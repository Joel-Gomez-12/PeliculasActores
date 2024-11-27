package es.uah.peliculasactores.dao;

import es.uah.peliculasactores.model.Actor;
import es.uah.peliculasactores.model.Pelicula;

import java.util.List;

public interface IActoresDAO {
    List<Actor> buscarTodos();

    Actor buscarActorPorId(Integer idActor);

    List <Actor> buscarActorPorNombre(String nombre);


    void guardarActor(Actor actor);

    void eliminarActor(Integer idActor);

    void actualizarActor(Actor actor);

    void actuarPelicula(Integer idActor, Integer idPelicula);
}
