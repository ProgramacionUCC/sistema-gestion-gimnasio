package repository;

import model.PagoMembresia;

import java.util.ArrayList;
import java.util.List;

// aca se guardan los pagos de membresias
public class PagoMembresiaRepository {
    // lista donde van todos los pagos
    private final List<PagoMembresia> pagos = new ArrayList<>();

    // guarda un pago
    public void guardar(PagoMembresia pago) {
        pagos.add(pago);
    }

    // devuelve todo lo que hay
    public List<PagoMembresia> obtenerTodos() {
        return new ArrayList<>(pagos);
    }

    // devuelve la lista tal cual
    public List<PagoMembresia> getPagos() {
        return pagos;
    }

    // busca por documento del usuario
    public List<PagoMembresia> obtenerPorUsuario(String documentoUsuario) {
        List<PagoMembresia> resultado = new ArrayList<>();
        for (PagoMembresia p : pagos) {
            if (p.getDocumentoUsuario().equals(documentoUsuario)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
