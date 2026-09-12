package service;

import model.PagoMembresia;
import repository.PagoMembresiaRepository;

import java.util.List;

// esto registra pagos de membresias, solo revisa que no venga vacio
public class PagoMembresiaService {

    private final PagoMembresiaRepository repository;

    // constructor
    public PagoMembresiaService(PagoMembresiaRepository repository) {
        this.repository = repository;
    }

    // registra un pago
    public void registrarPago(PagoMembresia pago) {
        validarObligatorios(pago);
        repository.guardar(pago);
    }

    // devuelve todos los pagos
    public List<PagoMembresia> listarPagos() {
        return repository.obtenerTodos();
    }

    // devuelve los pagos de un usuario
    public List<PagoMembresia> listarPorUsuario(String documentoUsuario) {
        return repository.obtenerPorUsuario(documentoUsuario);
    }

    // revisa que nada venga vacio
    private void validarObligatorios(PagoMembresia p) {
        if (p == null) throw new IllegalArgumentException("Pago no puede ser nulo");
        if (vacio(p.getCodigo())) throw new IllegalArgumentException("Codigo obligatorio");
        if (vacio(p.getDocumentoUsuario())) throw new IllegalArgumentException("Documento usuario obligatorio");
        if (p.getFechaPago() == null) throw new IllegalArgumentException("Fecha pago obligatoria");
        if (vacio(p.getMetodoPago())) throw new IllegalArgumentException("Metodo de pago obligatorio");
        if (vacio(p.getMesPagado())) throw new IllegalArgumentException("Mes pagado obligatorio");
        if (p.getMonto() <= 0) throw new IllegalArgumentException("Monto debe ser mayor a 0");
    }

    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
