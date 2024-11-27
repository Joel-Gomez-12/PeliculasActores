package es.uah.peliculasactores.dao;

import es.uah.peliculasactores.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IActoresJPA extends JpaRepository<Actor, Integer> {
    List<Actor> findByNombreContainingIgnoreCase(String nombre);
}
