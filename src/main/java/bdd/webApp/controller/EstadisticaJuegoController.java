package bdd.webApp.controller;

import bdd.webApp.model.EstadisticaJuego;
import bdd.webApp.model.EstadisticaJuegoId;
import bdd.webApp.repository.EstadisticaJuegoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estadisticas-juego")
@CrossOrigin(origins = "*")
public class EstadisticaJuegoController {

    private final EstadisticaJuegoRepository estadisticaJuegoRepository;

    public EstadisticaJuegoController(EstadisticaJuegoRepository estadisticaJuegoRepository) {
        this.estadisticaJuegoRepository = estadisticaJuegoRepository;
    }

    // Listar estadísticas de un juego específico
    @GetMapping
    public List<EstadisticaJuego> listarPorJuego(@RequestParam("codJuego") Integer codJuego) {
        return estadisticaJuegoRepository.findByIdCodJuego(codJuego);
    }

    // Crear / actualizar una estadística para (juego, jugador, tipo)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadisticaJuego crearOActualizar(@RequestBody EstadisticaJuego payload) {
        if (payload.getId() == null) {
            throw new IllegalArgumentException("Se requiere el ID completo (codJuego, codEstadistica, codJugador)");
        }

        EstadisticaJuegoId id = payload.getId();
        Optional<EstadisticaJuego> existenteOpt = estadisticaJuegoRepository.findById(id);

        if (existenteOpt.isPresent()) {
            EstadisticaJuego existente = existenteOpt.get();
            existente.setCantidad(payload.getCantidad());
            return estadisticaJuegoRepository.save(existente);
        } else {
            return estadisticaJuegoRepository.save(payload);
        }
    }

    // Eliminar una estadística puntual
    @DeleteMapping("/{codJuego}/{codEstadistica}/{codJugador}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer codJuego,
                         @PathVariable Integer codEstadistica,
                         @PathVariable Integer codJugador) {
        EstadisticaJuegoId id = new EstadisticaJuegoId(codJuego, codEstadistica, codJugador);
        estadisticaJuegoRepository.deleteById(id);
    }
}
