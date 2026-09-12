package model;

// HU-02: Entidad que guarda los datos del plan de entrenamiento.
// Solo guarda datos, no valida.
public class PlanEntrenamiento {
    // Codigo del plan
    private String codigo;
    // Nombre del plan
    private String nombre;
    // Descripcion del plan
    private String descripcion;
    // Duracion en semanas
    private int duracionSemanas;
    // Precio del plan
    private int precio;
    // Nivel del plan
    private String nivel;

    // Constructor: crea un plan con sus 6 datos
    public PlanEntrenamiento(String codigo, String nombre, String descripcion, int duracionSemanas, int precio, String nivel) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionSemanas = duracionSemanas;
        this.precio = precio;
        this.nivel = nivel;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionSemanas() {
        return duracionSemanas;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "PlanEntrenamiento{codigo='" + codigo + "', nombre='" + nombre + "', nivel='" + nivel + "', duracion=" + duracionSemanas + " semanas, precio=" + precio + "}";
    }
}
