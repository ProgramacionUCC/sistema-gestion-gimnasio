package repository;

import model.SesionEntrenamiento;

import java.util.ArrayList;
import java.util.List;

// aca se guardan las sesiones de entrenamiento
public class SesionRepository {
    // lista donde van todas las sesiones
    private final List<SesionEntrenamiento> sesiones = new ArrayList<>();

    // guarda una sesion
    public void guardar(SesionEntrenamiento sesion) {
        sesiones.add(sesion);
    }

    // devuelve todo lo que hay
    public List<SesionEntrenamiento> obtenerTodas() {
        return new ArrayList<>(sesiones);
    }

    // devuelve la lista tal cual
    public List<SesionEntrenamiento> getSesiones() {
        return sesiones;
    }

    // busca por documento del entrenador
    public List<SesionEntrenamiento> obtenerPorEntrenador(String documentoEntrenador) {
        List<SesionEntrenamiento> resultado = new ArrayList<>();
        for (SesionEntrenamiento s : sesiones) {
            if (s.getDocumentoEntrenador().equals(documentoEntrenador)) {
                resultado.add(s);
            }
        }
        return resultado;
    }
}
