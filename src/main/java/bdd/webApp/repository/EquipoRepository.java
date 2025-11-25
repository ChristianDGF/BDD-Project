package bdd.webApp.repository;

import bdd.webApp.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
}
