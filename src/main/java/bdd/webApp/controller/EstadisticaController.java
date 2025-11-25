package bdd.webApp.controller;

import bdd.webApp.model.Juego;
import bdd.webApp.repository.JuegoRepository;
import bdd.webApp.service.EstadisticaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EstadisticaController {

    private final JuegoRepository juegoRepository;
    private final EstadisticaService estadisticaService;

    public EstadisticaController(JuegoRepository juegoRepository,
                                  EstadisticaService estadisticaService) {
        this.juegoRepository = juegoRepository;
        this.estadisticaService = estadisticaService;
    }

    @GetMapping("/estadisticas")
    public String verEstadisticas(@RequestParam(name = "codJuego", required = false) Integer codJuego,
                                  Model model) {

        // Lista de juegos para el combo
        List<Juego> juegos = juegoRepository.findAll();
        model.addAttribute("juegos", juegos);

        if (codJuego != null) {
            List<String> lineas = estadisticaService.obtenerEstadisticasJuego(codJuego);
            model.addAttribute("lineas", lineas);
            model.addAttribute("juegoSeleccionado", codJuego);
        }

        return "estadisticas"; // templates/estadisticas.html
    }
}
