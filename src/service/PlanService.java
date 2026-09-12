package service;

import model.PlanEntrenamiento;
import repository.PlanRepository;

import java.util.List;

// HU-02: Capa service - logica minima para registrar planes
public class PlanService {

    // Repository donde se guardan los planes
    private final PlanRepository repository;

    // Constructor
    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    // Registra un plan
    public void registrarPlan(PlanEntrenamiento plan) {
        validarObligatorios(plan);
        repository.guardar(plan);
    }

    // Lista todos los planes
    public List<PlanEntrenamiento> listarPlanes() {
        return repository.obtenerTodos();
    }

    // Solo revisa que no vengan vacios
    private void validarObligatorios(PlanEntrenamiento p) {
        if (p == null) throw new IllegalArgumentException("Plan no puede ser nulo");
        if (vacio(p.getCodigo())) throw new IllegalArgumentException("Codigo obligatorio");
        if (vacio(p.getNombre())) throw new IllegalArgumentException("Nombre obligatorio");
        if (vacio(p.getDescripcion())) throw new IllegalArgumentException("Descripcion obligatoria");
        if (vacio(p.getNivel())) throw new IllegalArgumentException("Nivel obligatorio");
    }

    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
