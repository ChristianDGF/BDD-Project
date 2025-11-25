package bdd.webApp.repository;

import bdd.webApp.model.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticaRepository extends JpaRepository<Estadistica, Integer> {
}
