package service;

import model.Usuario;
import repository.UsuarioRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

// HU-01: Capa service - se encarga de toda la logica de negocio para registrar usuarios.
// Valida datos obligatorios, formato y duplicados antes de guardar en el repository.
public class UsuarioService {

    // Regex para validar que el correo tenga forma de correo (ej: a@mail.com debe tener @ y punto)
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    // Regex para celular: solo numeros, puede empezar con + (ej: +573005698325)
    private static final String CELULAR_REGEX = "^\\+?[0-9]+$";
    // Regex para documento: solo numeros (no letras ni guiones)
    private static final String DOCUMENTO_REGEX = "^[0-9]+$";
    // Celular no puede tener mas de 13 caracteres en total
    private static final int CELULAR_MAX = 13;
    // Edad minima para registrarse en el gimnasio
    private static final int EDAD_MINIMA = 16;

    // Repository donde se guardan los usuarios (inyeccion por constructor)
    private final UsuarioRepository repository;

    // Constructor: recibe el repository para poder guardar y consultar
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Metodo principal: registra un usuario paso a paso
    public void registrarUsuario(Usuario usuario) {
        validarObligatorios(usuario);           // 1. revisa que ningun campo venga vacio
        validarFormato(usuario);                // 2. revisa que email, celular, documento y edad esten bien
        validarUnicos(usuario);                 // 3. valida que correo y documento no esten repetidos (UNIQUE)
        repository.guardarUsuario(usuario);     // 4. si todo esta bien, lo guarda en la lista
    }

    // Valida que correo y documento no se repitan en la lista existente
    private void validarUnicos(Usuario usuario) {
        // Correo no puede repetirse (case-insensitive)
        if (repository.getUsuarios().stream().anyMatch(u -> u.getCorreo().equalsIgnoreCase(usuario.getCorreo()))) {
            throw new IllegalArgumentException("Correo ya registrado (UNIQUE)");
        }
        // Documento no puede repetirse
        if (repository.getUsuarios().stream().anyMatch(u -> u.getDocumentoDeIdentidad().equals(usuario.getDocumentoDeIdentidad()))) {
            throw new IllegalArgumentException("Documento ya registrado (UNIQUE)");
        }
    }

    // Devuelve todos los usuarios guardados (para listar)
    public List<Usuario> listarUsuarios() {
        return repository.getUsuarios();
    }

    // Revisa que los 7 campos obligatorios no esten vacios o nulos
    private void validarObligatorios(Usuario u) {
        if (vacio(u.getNombre())) throw new IllegalArgumentException("Nombre obligatorio");
        if (vacio(u.getApellido())) throw new IllegalArgumentException("Apellido obligatorio");
        if (vacio(u.getDocumentoDeIdentidad())) throw new IllegalArgumentException("Documento obligatorio");
        if (vacio(u.getCelular())) throw new IllegalArgumentException("Celular obligatorio");
        if (u.getFechaNacimiento() == null) throw new IllegalArgumentException("Fecha nacimiento obligatoria");
        if (vacio(u.getCorreo())) throw new IllegalArgumentException("Correo obligatorio");
        if (vacio(u.getClave())) throw new IllegalArgumentException("Clave obligatoria");
    }

    // Revisa los formatos uno por uno delegando a cada validador
    private void validarFormato(Usuario u) {
        validarEmail(u.getCorreo());
        validarCelular(u.getCelular());
        validarDocumento(u.getDocumentoDeIdentidad());
        validarEdad(u.getFechaNacimiento());
    }

    // El correo debe tener @ y punto, ej: a@mail.com
    private void validarEmail(String correo) {
        if (!correo.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Correo no valido");
        }
    }

    // El celular max 13 caracteres y solo numeros con + opcional al inicio
    private void validarCelular(String celular) {
        if (celular.length() > CELULAR_MAX || !celular.matches(CELULAR_REGEX)) {
            throw new IllegalArgumentException("Celular no valido, max 13 y solo numeros y +");
        }
    }

    // El documento solo puede tener numeros
    private void validarDocumento(String documento) {
        if (!documento.matches(DOCUMENTO_REGEX)) {
            throw new IllegalArgumentException("Documento solo numerico");
        }
    }

    // Debe ser mayor de edad minima (16 años)
    private void validarEdad(LocalDate nacimiento) {
        if (!esMayorDeEdad(nacimiento)) {
            throw new IllegalArgumentException("Debe ser mayor de " + EDAD_MINIMA + " años");
        }
    }

    // Helper: dice si un texto esta vacio o es null
    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    // Calcula si tiene EDAD_MINIMA o mas comparando fecha de nacimiento con hoy
    private boolean esMayorDeEdad(LocalDate nacimiento) {
        if (nacimiento == null) return false;
        int edad = Period.between(nacimiento, LocalDate.now()).getYears();
        return edad >= EDAD_MINIMA;
    }
}
