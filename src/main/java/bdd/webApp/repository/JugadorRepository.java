package bdd.webApp.repository;

import bdd.webApp.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
}
