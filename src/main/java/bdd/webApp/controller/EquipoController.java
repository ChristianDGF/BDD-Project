package bdd.webApp.controller;

import bdd.webApp.model.Equipo;
import bdd.webApp.repository.EquipoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*")
public class EquipoController {

    private final EquipoRepository equipoRepository;

    public EquipoController(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @GetMapping
    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Equipo obtener(@PathVariable Integer id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipo no encontrado"));
    }

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Integer id, @RequestBody Equipo equipo) {
        Equipo existente = equipoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipo no encontrado"));

        existente.setNombre(equipo.getNombre());
        existente.setCodCiudad(equipo.getCodCiudad());
        return equipoRepository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        equipoRepository.deleteById(id);
    }
}
