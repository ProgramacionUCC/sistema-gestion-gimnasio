package repository;

import model.PlanEntrenamiento;

import java.util.ArrayList;
import java.util.List;

// HU-02: Capa repository - guarda los planes en memoria con ArrayList
public class PlanRepository {
    // Lista en memoria
    private final List<PlanEntrenamiento> planes = new ArrayList<>();

    // Guarda un plan
    public void guardar(PlanEntrenamiento plan) {
        planes.add(plan);
    }

    // Devuelve todos los planes
    public List<PlanEntrenamiento> obtenerTodos() {
        return new ArrayList<>(planes);
    }

    // Devuelve la lista interna
    public List<PlanEntrenamiento> getPlanes() {
        return planes;
    }
}
