package model;

// esto es el entrenador y su especialidad
public class Entrenador {
    private String nombre; // nombre
    private String apellido; // apellido
    private String documento; // documento
    private String especialidad; // ej: pesas, crossfit, yoga
    private String celular; // celular
    private String correo; // correo

    // constructor con todo
    public Entrenador(String nombre, String apellido, String documento, String especialidad, String celular, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.especialidad = especialidad;
        this.celular = celular;
        this.correo = correo;
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Entrenador{nombre='" + nombre + "', apellido='" + apellido + "', documento='" + documento + "', especialidad='" + especialidad + "'}";
    }
}
