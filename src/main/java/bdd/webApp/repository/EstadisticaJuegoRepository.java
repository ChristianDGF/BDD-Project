package bdd.webApp.repository;

import bdd.webApp.model.EstadisticaJuego;
import bdd.webApp.model.EstadisticaJuegoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadisticaJuegoRepository extends JpaRepository<EstadisticaJuego, EstadisticaJuegoId> {

    List<EstadisticaJuego> findByIdCodJuego(Integer codJuego);
}