package bdd.webApp.service;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstadisticaService {

    private final DataSource dataSource;

    public EstadisticaService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Ejecuta el procedimiento almacenado ObtenerEstadisticasJuego
     * y devuelve todas las salidas como una lista de líneas de texto,
     * similar a lo que se ve en SSMS.
     */
    public List<String> obtenerEstadisticasJuego(int codJuego) {
        List<String> lineas = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             CallableStatement cs = conn.prepareCall("{ call ObtenerEstadisticasJuego(?) }")) {

            cs.setInt(1, codJuego);

            boolean hasResults = cs.execute();

            while (hasResults) {
                try (ResultSet rs = cs.getResultSet()) {
                    if (rs != null) {
                        ResultSetMetaData metaData = rs.getMetaData();
                        int colCount = metaData.getColumnCount();

                        while (rs.next()) {
                            if (colCount == 1) {
                                Object val = rs.getObject(1);
                                lineas.add(val != null ? val.toString() : "");
                            } else {
                                StringBuilder sb = new StringBuilder();
                                for (int i = 1; i <= colCount; i++) {
                                    if (i > 1) sb.append(" | ");
                                    Object val = rs.getObject(i);
                                    sb.append(val != null ? val.toString() : "");
                                }
                                lineas.add(sb.toString());
                            }
                        }
                    }
                }
                // Pasar al siguiente result set, si lo hay
                hasResults = cs.getMoreResults();
            }

        } catch (SQLException e) {
            lineas.add("ERROR ejecutando el procedimiento almacenado:");
            lineas.add(e.getMessage());
            e.printStackTrace();
        }

        return lineas;
    }
}
