package service;

import model.Inscripcion;
import repository.InscripcionRepository;

import java.util.List;

// esto es lo que hace la inscripcion, solo revisa que no venga vacio y guarda
public class InscripcionService {

    private final InscripcionRepository repository;

    // constructor
    public InscripcionService(InscripcionRepository repository) {
        this.repository = repository;
    }

    // inscribe a un usuario en un plan
    public void inscribirUsuarioEnPlan(String documentoUsuario, String codigoPlan) {
        // reviso que no vengan vacios
        if (vacio(documentoUsuario)) throw new IllegalArgumentException("Documento usuario obligatorio");
        if (vacio(codigoPlan)) throw new IllegalArgumentException("Codigo plan obligatorio");

        // creo la inscripcion y la guardo
        Inscripcion inscripcion = new Inscripcion(documentoUsuario, codigoPlan);
        repository.guardar(inscripcion);
    }

    // devuelve todas las inscripciones
    public List<Inscripcion> listarInscripciones() {
        return repository.obtenerTodas();
    }

    // devuelve las de un usuario
    public List<Inscripcion> listarPorUsuario(String documento) {
        return repository.obtenerPorUsuario(documento);
    }

    // revisa si esta vacio
    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
