package model;

import java.time.LocalDate;

// esto es para guardar a que plan se inscribio cada persona
public class Inscripcion {
    private String documentoUsuario; // el documento del que se inscribe
    private String codigoPlan; // el codigo del plan
    private LocalDate fechaInscripcion; // cuando se inscribio

    // constructor normal
    public Inscripcion(String documentoUsuario, String codigoPlan) {
        this.documentoUsuario = documentoUsuario;
        this.codigoPlan = codigoPlan;
        this.fechaInscripcion = LocalDate.now(); // se pone la fecha de hoy automatico
    }

    // getters
    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion{usuario='" + documentoUsuario + "', plan='" + codigoPlan + "', fecha=" + fechaInscripcion + "}";
    }
}
