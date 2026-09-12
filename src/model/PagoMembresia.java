package model;

import java.time.LocalDate;

// esto es el pago de membresia de un usuario
public class PagoMembresia {
    private String codigo; // codigo del pago
    private String documentoUsuario; // documento del usuario que paga
    private double monto; // monto pagado
    private LocalDate fechaPago; // fecha en que se hizo el pago
    private String metodoPago; // metodo: Efectivo, Tarjeta, Transferencia
    private String mesPagado; // mes que se esta pagando ej: 2026-09

    // constructor con todo
    public PagoMembresia(String codigo, String documentoUsuario, double monto, LocalDate fechaPago, String metodoPago, String mesPagado) {
        this.codigo = codigo;
        this.documentoUsuario = documentoUsuario;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.mesPagado = mesPagado;
    }

    // getters
    public String getCodigo() {
        return codigo;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getMesPagado() {
        return mesPagado;
    }

    @Override
    public String toString() {
        return "PagoMembresia{codigo='" + codigo + "', usuario='" + documentoUsuario + "', monto=" + monto + ", fecha=" + fechaPago + ", metodo='" + metodoPago + "', mes='" + mesPagado + "'}";
    }
}
