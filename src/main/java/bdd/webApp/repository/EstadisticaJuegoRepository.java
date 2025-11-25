package bdd.webApp.repository;

import bdd.webApp.model.EstadisticaJuego;
import bdd.webApp.model.EstadisticaJuegoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticaJuegoRepository extends JpaRepository<EstadisticaJuego, EstadisticaJuegoId> {
}