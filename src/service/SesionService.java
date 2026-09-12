package service;

import model.SesionEntrenamiento;
import repository.SesionRepository;

import java.util.List;

// esto registra sesiones de entrenamiento dirigidas por entrenadores, solo revisa que no venga vacio
public class SesionService {

    private final SesionRepository repository;

    // constructor
    public SesionService(SesionRepository repository) {
        this.repository = repository;
    }

    // registra una sesion
    public void registrarSesion(SesionEntrenamiento sesion) {
        validarObligatorios(sesion);
        repository.guardar(sesion);
    }

    // devuelve todas las sesiones
    public List<SesionEntrenamiento> listarSesiones() {
        return repository.obtenerTodas();
    }

    // devuelve las sesiones de un entrenador
    public List<SesionEntrenamiento> listarPorEntrenador(String documentoEntrenador) {
        return repository.obtenerPorEntrenador(documentoEntrenador);
    }

    // revisa que nada venga vacio
    private void validarObligatorios(SesionEntrenamiento s) {
        if (s == null) throw new IllegalArgumentException("Sesion no puede ser nula");
        if (vacio(s.getCodigo())) throw new IllegalArgumentException("Codigo obligatorio");
        if (vacio(s.getDocumentoEntrenador())) throw new IllegalArgumentException("Documento entrenador obligatorio");
        if (s.getFecha() == null) throw new IllegalArgumentException("Fecha obligatoria");
        if (s.getHoraInicio() == null) throw new IllegalArgumentException("Hora obligatoria");
        if (vacio(s.getTipoSesion())) throw new IllegalArgumentException("Tipo de sesion obligatorio");
    }

    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
