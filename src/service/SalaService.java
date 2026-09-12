package service;

import model.Sala;
import repository.SalaRepository;

import java.util.List;

// esto registra salas o areas disponibles, solo revisa que no venga vacio
public class SalaService {

    private final SalaRepository repository;

    // constructor
    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    // registra una sala
    public void registrarSala(Sala sala) {
        validarObligatorios(sala);
        repository.guardar(sala);
    }

    // devuelve todas las salas
    public List<Sala> listarSalas() {
        return repository.obtenerTodas();
    }

    // devuelve las salas por tipo
    public List<Sala> listarPorTipo(String tipo) {
        return repository.obtenerPorTipo(tipo);
    }

    // revisa que nada venga vacio
    private void validarObligatorios(Sala s) {
        if (s == null) throw new IllegalArgumentException("Sala no puede ser nula");
        if (vacio(s.getCodigo())) throw new IllegalArgumentException("Codigo obligatorio");
        if (vacio(s.getNombre())) throw new IllegalArgumentException("Nombre obligatorio");
        if (vacio(s.getTipo())) throw new IllegalArgumentException("Tipo obligatorio");
        if (vacio(s.getUbicacion())) throw new IllegalArgumentException("Ubicacion obligatoria");
        if (s.getCapacidad() <= 0) throw new IllegalArgumentException("Capacidad debe ser mayor a 0");
    }

    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
