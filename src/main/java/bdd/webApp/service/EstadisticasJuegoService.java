package bdd.webApp.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.util.Collections;
import java.util.Map;

@Service
public class EstadisticasJuegoService {

    private final JdbcTemplate jdbcTemplate;

    public EstadisticasJuegoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> obtenerEstadisticasJuego(Integer codJuego) {
        return jdbcTemplate.call(con -> {
            CallableStatement cs = con.prepareCall("{call ObtenerEstadisticasJuego(?)}");
            cs.setInt(1, codJuego);
            return cs;
        }, Collections.emptyList());
    }
}
