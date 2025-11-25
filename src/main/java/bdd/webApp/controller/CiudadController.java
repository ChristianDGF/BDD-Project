package bdd.webApp.controller;

import bdd.webApp.model.Ciudad;
import bdd.webApp.repository.CiudadRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
@CrossOrigin(origins = "*")
public class CiudadController {

    private final CiudadRepository ciudadRepository;

    public CiudadController(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @GetMapping
    public List<Ciudad> listar() {
        return ciudadRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ciudad obtener(@PathVariable Integer id) {
        return ciudadRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ciudad no encontrada"));
    }

    @PostMapping
    public Ciudad crear(@RequestBody Ciudad ciudad) {
        // ignoramos cualquier codCiudad que venga; JPA/DB generarán uno nuevo
        ciudad.setCodCiudad(null);
        return ciudadRepository.save(ciudad);
    }

    @PutMapping("/{id}")
    public Ciudad actualizar(@PathVariable Integer id, @RequestBody Ciudad ciudad) {
        Ciudad existente = ciudadRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ciudad no encontrada"));

        existente.setNombre(ciudad.getNombre());
        return ciudadRepository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        ciudadRepository.deleteById(id);
    }
}

