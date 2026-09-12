package repository;

import model.Inscripcion;

import java.util.ArrayList;
import java.util.List;

// aca se guardan todas las inscripciones
public class InscripcionRepository {
    // lista donde van todas
    private final List<Inscripcion> inscripciones = new ArrayList<>();

    // guarda una inscripcion
    public void guardar(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    // devuelve todo lo que hay
    public List<Inscripcion> obtenerTodas() {
        return new ArrayList<>(inscripciones);
    }

    // devuelve la lista tal cual
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    // busca por documento del usuario
    public List<Inscripcion> obtenerPorUsuario(String documento) {
        List<Inscripcion> resultado = new ArrayList<>();
        for (Inscripcion i : inscripciones) {
            if (i.getDocumentoUsuario().equals(documento)) {
                resultado.add(i);
            }
        }
        return resultado;
    }
}
