package repository;

import model.Sala;

import java.util.ArrayList;
import java.util.List;

// aca se guardan las salas o areas del gimnasio
public class SalaRepository {
    // lista donde van todas las salas
    private final List<Sala> salas = new ArrayList<>();

    // guarda una sala
    public void guardar(Sala sala) {
        salas.add(sala);
    }

    // devuelve todo lo que hay
    public List<Sala> obtenerTodas() {
        return new ArrayList<>(salas);
    }

    // devuelve la lista tal cual
    public List<Sala> getSalas() {
        return salas;
    }

    // busca por tipo de sala
    public List<Sala> obtenerPorTipo(String tipo) {
        List<Sala> resultado = new ArrayList<>();
        for (Sala s : salas) {
            if (s.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(s);
            }
        }
        return resultado;
    }
}
