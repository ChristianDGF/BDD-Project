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
public class EstadisticaController {

    private final EstadisticaRepository estadisticaRepository;

    public EstadisticaController(EstadisticaRepository estadisticaRepository) {
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

    @PostMapping
    public Estadistica crear(@RequestBody Estadistica estadistica) {
        return estadisticaRepository.save(estadistica);
    }

    @PutMapping("/{id}")
    public Estadistica actualizar(@PathVariable Integer id, @RequestBody Estadistica estadistica) {
        Estadistica existente = estadisticaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estadística no encontrada"));

        existente.setDescripcion(estadistica.getDescripcion());
        existente.setValor(estadistica.getValor());
        return estadisticaRepository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        estadisticaRepository.deleteById(id);
    }
}
