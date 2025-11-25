package bdd.webApp.controller;

import bdd.webApp.model.EstadisticaJuego;
import bdd.webApp.model.EstadisticaJuegoId;
import bdd.webApp.repository.EstadisticaJuegoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas-juego")
@CrossOrigin(origins = "*")
public class EstadisticaJuegoController {

    private final EstadisticaJuegoRepository estadisticaJuegoRepository;

    public EstadisticaJuegoController(EstadisticaJuegoRepository estadisticaJuegoRepository) {
        this.estadisticaJuegoRepository = estadisticaJuegoRepository;
    }

    @GetMapping
    public List<EstadisticaJuego> listar() {
        return estadisticaJuegoRepository.findAll();
    }

    @GetMapping("/juego/{codJuego}")
    public List<EstadisticaJuego> listarPorJuego(@PathVariable Integer codJuego) {
        // Si quieres filtrar por juego, crea un método custom en el repo.
        return estadisticaJuegoRepository.findAll()
                .stream()
                .filter(e -> e.getId().getCodJuego().equals(codJuego))
                .toList();
    }

    @PostMapping
    public EstadisticaJuego crear(@RequestBody EstadisticaJuego estadisticaJuego) {
        return estadisticaJuegoRepository.save(estadisticaJuego);
    }

    @GetMapping("/detalle")
    public EstadisticaJuego obtener(
            @RequestParam Integer codJuego,
            @RequestParam Integer codEstadistica,
            @RequestParam Integer codJugador
    ) {
        EstadisticaJuegoId id = new EstadisticaJuegoId(codJuego, codEstadistica, codJugador);
        return estadisticaJuegoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estadística de juego no encontrada"));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(
            @RequestParam Integer codJuego,
            @RequestParam Integer codEstadistica,
            @RequestParam Integer codJugador
    ) {
        EstadisticaJuegoId id = new EstadisticaJuegoId(codJuego, codEstadistica, codJugador);
        estadisticaJuegoRepository.deleteById(id);
    }
}
