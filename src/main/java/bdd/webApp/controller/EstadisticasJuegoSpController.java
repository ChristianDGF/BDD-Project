package bdd.webApp.controller;

import bdd.webApp.service.EstadisticasJuegoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/juegos")
@CrossOrigin(origins = "*")
public class EstadisticasJuegoSpController {

    private final EstadisticasJuegoService estadisticasJuegoService;

    public EstadisticasJuegoSpController(EstadisticasJuegoService estadisticasJuegoService) {
        this.estadisticasJuegoService = estadisticasJuegoService;
    }

    @GetMapping("/{codJuego}/estadisticas-sp")
    public Map<String, Object> obtenerEstadisticas(@PathVariable Integer codJuego) {
        return estadisticasJuegoService.obtenerEstadisticasJuego(codJuego);
    }
}