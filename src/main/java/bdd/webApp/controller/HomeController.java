package bdd.webApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html
    }

    @GetMapping("/ciudades")
    public String ciudades() {
        return "ciudades"; // templates/ciudades.html
    }

    @GetMapping("/equipos")
    public String equipos() {
        return "equipos"; // templates/equipos.html
    }

    @GetMapping("/juegos")
    public String juegos() {
        return "juegos"; // templates/juegos.html
    }

    @GetMapping("/jugadores")
    public String jugadores() {
        return "jugadores"; // templates/jugadores.html
    }

    @GetMapping("/captura-estadisticas")
    public String capturaEstadisticas() {
        return "captura-estadisticas"; // templates/captura-estadisticas.html
    }


}
