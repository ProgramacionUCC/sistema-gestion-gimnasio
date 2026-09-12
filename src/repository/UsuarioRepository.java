package repository;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

// HU-01: Capa repository - es el cajon donde se guardan los usuarios en memoria.
// No valida nada, solo guarda y devuelve. Usa ArrayList como pide el requisito tecnico.
public class UsuarioRepository {
    // Lista en memoria donde se van agregando los usuarios
    private List<Usuario> usuarios = new ArrayList<>();

    // Agrega un usuario a la lista
    public void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Devuelve la lista interna (referencia directa, usada por el service para validar)
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Devuelve una copia de la lista para mostrar sin exponer la interna
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }
}
