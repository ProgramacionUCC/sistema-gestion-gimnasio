package repository;

import model.Entrenador;

import java.util.ArrayList;
import java.util.List;

// aca van los entrenadores guardados
public class EntrenadorRepository {
    // lista de entrenadores
    private final List<Entrenador> entrenadores = new ArrayList<>();

    // guarda uno
    public void guardar(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }

    // devuelve todos
    public List<Entrenador> obtenerTodos() {
        return new ArrayList<>(entrenadores);
    }

    // devuelve la lista tal cual
    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }
}
