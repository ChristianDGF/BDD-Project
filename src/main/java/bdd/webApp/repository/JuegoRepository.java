package bdd.webApp.repository;

import bdd.webApp.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Integer> {
}