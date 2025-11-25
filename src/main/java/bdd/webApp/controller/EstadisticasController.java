package bdd.webApp.controller;

import bdd.webApp.model.Estadistica;
import bdd.webApp.repository.EstadisticaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@CrossOrigin(origins = "*")
public class EstadisticasController {

    private final EstadisticaRepository estadisticaRepository;

    public EstadisticasController(EstadisticaRepository estadisticaRepository) {
        this.estadisticaRepository = estadisticaRepository;
    }

    @GetMapping
    public List<Estadistica> listar() {
        return estadisticaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Estadistica obtener(@PathVariable Integer id) {
        return estadisticaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estadística no encontrada"));
    }
}
