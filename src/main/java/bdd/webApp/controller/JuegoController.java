package bdd.webApp.controller;

import bdd.webApp.model.Juego;
import bdd.webApp.repository.JuegoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
@CrossOrigin(origins = "*")
public class JuegoController {

    private final JuegoRepository juegoRepository;

    public JuegoController(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @GetMapping
    public List<Juego> listar() {
        return juegoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Juego obtener(@PathVariable Integer id) {
        return juegoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Juego no encontrado"));
    }

    @PostMapping
    public Juego crear(@RequestBody Juego juego) {
        return juegoRepository.save(juego);
    }

    @PutMapping("/{id}")
    public Juego actualizar(@PathVariable Integer id, @RequestBody Juego juego) {
        Juego existente = juegoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Juego no encontrado"));

        existente.setDescripcion(juego.getDescripcion());
        existente.setEquipoLocal(juego.getEquipoLocal());
        existente.setEquipoVisitante(juego.getEquipoVisitante());
        existente.setFecha(juego.getFecha());
        return juegoRepository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        juegoRepository.deleteById(id);
    }
}
