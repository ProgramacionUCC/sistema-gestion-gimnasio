package model;

import java.time.LocalDate;

// HU-01: Entidad que guarda los datos del usuario del gimnasio.
// Solo guarda datos, no valida (eso lo hace el service).
// Se usa encapsulamiento: todo es private y se accede con getters/setters.
public class Usuario {
    // Nombre del usuario
    private String nombre;
    // Apellido del usuario
    private String apellido;
    // Documento de identidad - es String para no perder ceros como 00123
    private String documentoDeIdentidad;
    // Celular - String porque puede tener + al inicio y ceros
    private String celular;
    // Fecha de nacimiento real (LocalDate) para calcular edad facil
    private LocalDate fechaNacimiento;
    // Correo electronico del usuario
    private String correo;
    // Clave del usuario (se guarda en texto plano, sin BCrypt en esta HU)
    private String clave;

    // Constructor principal: crea un usuario con sus 7 datos obligatorios
    public Usuario(String nombre, String apellido, String documentoDeIdentidad, String celular, LocalDate fechaNacimiento, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoDeIdentidad = documentoDeIdentidad;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.clave = clave;
    }

    // Getter: devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    // Getter: devuelve el apellido
    public String getApellido() {
        return apellido;
    }

    // Getter: devuelve el documento
    public String getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }

    // Getter: devuelve el celular
    public String getCelular() {
        return celular;
    }

    // Getter: devuelve la fecha de nacimiento
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Getter: devuelve el correo
    public String getCorreo() {
        return correo;
    }

    // Getter: devuelve la clave
    public String getClave() {
        return clave;
    }

    // Setter: solo se usa si se quiere cambiar la clave despues
    public void setClave(String clave) {
        this.clave = clave;
    }

    // toString: muestra info basica del usuario para debug/logs
    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', apellido='" + apellido + "', documento='" + documentoDeIdentidad + "', correo='" + correo + "'}";
    }
}
