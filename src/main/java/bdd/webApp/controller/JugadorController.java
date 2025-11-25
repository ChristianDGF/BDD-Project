package bdd.webApp.controller;

import bdd.webApp.model.Jugador;
import bdd.webApp.repository.JugadorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "*")
public class JugadorController {

    private final JugadorRepository jugadorRepository;

    public JugadorController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping
    public List<Jugador> listar() {
        return jugadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Jugador obtener(@PathVariable Integer id) {
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado"));
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        jugador.setCodJugador(null); // ID lo genera la BD
        return jugadorRepository.save(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable Integer id, @RequestBody Jugador jugador) {
        Jugador existente = jugadorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado"));

        existente.setNombre1(jugador.getNombre1());
        existente.setNombre2(jugador.getNombre2());
        existente.setApellido1(jugador.getApellido1());
        existente.setApellido2(jugador.getApellido2());
        existente.setCodCiudadNacimiento(jugador.getCodCiudadNacimiento());
        existente.setFechaNacimiento(jugador.getFechaNacimiento());
        existente.setNumero(jugador.getNumero());
        existente.setCodEquipo(jugador.getCodEquipo());

        return jugadorRepository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        jugadorRepository.deleteById(id);
    }
}
