package model;

import java.time.LocalDate;
import java.time.LocalTime;

// esto es la sesion de entrenamiento dirigida por un entrenador
public class SesionEntrenamiento {
    private String codigo; // codigo de la sesion
    private String documentoEntrenador; // documento del entrenador que dirige
    private LocalDate fecha; // fecha de la sesion
    private LocalTime horaInicio; // hora de inicio
    private int duracionMinutos; // duracion en minutos
    private String tipoSesion; // tipo: pesas, crossfit, yoga, etc

    // constructor con todo
    public SesionEntrenamiento(String codigo, String documentoEntrenador, LocalDate fecha, LocalTime horaInicio, int duracionMinutos, String tipoSesion) {
        this.codigo = codigo;
        this.documentoEntrenador = documentoEntrenador;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracionMinutos = duracionMinutos;
        this.tipoSesion = tipoSesion;
    }

    // getters
    public String getCodigo() {
        return codigo;
    }

    public String getDocumentoEntrenador() {
        return documentoEntrenador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getTipoSesion() {
        return tipoSesion;
    }

    @Override
    public String toString() {
        return "SesionEntrenamiento{codigo='" + codigo + "', entrenador='" + documentoEntrenador + "', fecha=" + fecha + ", hora=" + horaInicio + ", duracion=" + duracionMinutos + "min, tipo='" + tipoSesion + "'}";
    }
}
