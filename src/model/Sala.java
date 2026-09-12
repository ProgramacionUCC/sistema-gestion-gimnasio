package model;

// esto es la sala o area disponible del gimnasio
public class Sala {
    private String codigo; // codigo de la sala
    private String nombre; // nombre de la sala
    private int capacidad; // capacidad de personas
    private String tipo; // tipo: musculacion, cardio, yoga, etc
    private String ubicacion; // ubicacion dentro del gimnasio

    // constructor con todo
    public Sala(String codigo, String nombre, int capacidad, String tipo, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    // getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "Sala{codigo='" + codigo + "', nombre='" + nombre + "', capacidad=" + capacidad + ", tipo='" + tipo + "', ubicacion='" + ubicacion + "'}";
    }
}
