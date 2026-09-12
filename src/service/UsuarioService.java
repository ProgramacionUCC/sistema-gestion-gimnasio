package service;

import model.Usuario;
import repository.UsuarioRepository;

import java.util.List;

// HU-01: Capa service - logica de negocio para registrar usuarios.
// Literal lo pedido: solo guarda, con revision minima de obligatorios.
public class UsuarioService {

    // Repository donde se guardan los usuarios
    private final UsuarioRepository repository;

    // Constructor: recibe el repository para poder guardar
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Metodo principal: registra un usuario
    public void registrarUsuario(Usuario usuario) {
        // Revision minima: que los campos no vengan vacios
        validarObligatorios(usuario);
        // Si pasa, lo guarda en la lista
        repository.guardarUsuario(usuario);
    }

    // Devuelve todos los usuarios guardados
    public List<Usuario> listarUsuarios() {
        return repository.getUsuarios();
    }

    // Revisa que los 7 campos obligatorios no esten vacios
    private void validarObligatorios(Usuario u) {
        if (u == null) throw new IllegalArgumentException("Usuario no puede ser nulo");
        if (vacio(u.getNombre())) throw new IllegalArgumentException("Nombre obligatorio");
        if (vacio(u.getApellido())) throw new IllegalArgumentException("Apellido obligatorio");
        if (vacio(u.getDocumentoDeIdentidad())) throw new IllegalArgumentException("Documento obligatorio");
        if (vacio(u.getCelular())) throw new IllegalArgumentException("Celular obligatorio");
        if (u.getFechaNacimiento() == null) throw new IllegalArgumentException("Fecha nacimiento obligatoria");
        if (vacio(u.getCorreo())) throw new IllegalArgumentException("Correo obligatorio");
        if (vacio(u.getClave())) throw new IllegalArgumentException("Clave obligatoria");
    }

    // Helper: dice si un texto esta vacio o es null
    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
