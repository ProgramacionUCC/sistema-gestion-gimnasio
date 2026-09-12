package service;

import model.Entrenador;
import repository.EntrenadorRepository;

import java.util.List;

// esto registra entrenadores, solo revisa que no venga vacio
public class EntrenadorService {

    private final EntrenadorRepository repository;

    // constructor
    public EntrenadorService(EntrenadorRepository repository) {
        this.repository = repository;
    }

    // registra un entrenador
    public void registrarEntrenador(Entrenador entrenador) {
        validarObligatorios(entrenador);
        repository.guardar(entrenador);
    }

    // devuelve todos
    public List<Entrenador> listarEntrenadores() {
        return repository.obtenerTodos();
    }

    // revisa que nada venga vacio
    private void validarObligatorios(Entrenador e) {
        if (e == null) throw new IllegalArgumentException("Entrenador no puede ser nulo");
        if (vacio(e.getNombre())) throw new IllegalArgumentException("Nombre obligatorio");
        if (vacio(e.getApellido())) throw new IllegalArgumentException("Apellido obligatorio");
        if (vacio(e.getDocumento())) throw new IllegalArgumentException("Documento obligatorio");
        if (vacio(e.getEspecialidad())) throw new IllegalArgumentException("Especialidad obligatoria");
        if (vacio(e.getCelular())) throw new IllegalArgumentException("Celular obligatorio");
        if (vacio(e.getCorreo())) throw new IllegalArgumentException("Correo obligatorio");
    }

    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
