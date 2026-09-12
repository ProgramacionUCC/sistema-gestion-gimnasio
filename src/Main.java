import model.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

import java.time.LocalDate;

// HU-01: Demo para probar el registro de usuarios del gimnasio.
// Crea un usuario valido y luego prueba 4 errores esperados.
public class Main {
    public static void main(String[] args) {
        // Se crean los cajones y el servicio (repository + service)
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);

        System.out.println("--- HU-01: Registrar usuarios del gimnasio ---");

        // Caso valido: usuario con datos correctos
        Usuario u1 = new Usuario(
                "Mateo",
                "Bustamante",
                "12345678",              // documento solo numeros
                "+573005698325",         // celular con + y max 13
                LocalDate.of(2000, 5, 10), // mayor de 16
                "mateo@mail.com",        // correo con @ y punto
                "clave123"
        );

        try {
            usuarioService.registrarUsuario(u1);
            System.out.println("Usuario registrado: " + u1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Pruebas de validacion ---");

        // Error 1: correo duplicado (UNIQUE) - ya existe mateo@mail.com
        Usuario correoDuplicado = new Usuario(
                "Ana",
                "Lopez",
                "87654321",
                "+573001112233",
                LocalDate.of(1998, 6, 15),
                "mateo@mail.com", // mismo correo que u1
                "clave456"
        );
        try {
            usuarioService.registrarUsuario(correoDuplicado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado (correo duplicado): " + e.getMessage());
        }

        // Error 2: menor de edad - nacio en 2015, tiene 11 años
        Usuario menorEdad = new Usuario(
                "Juan",
                "Perez",
                "11223344",
                "+573002223344",
                LocalDate.of(2015, 1, 1), // menor de 16
                "juan@mail.com",
                "clave789"
        );
        try {
            usuarioService.registrarUsuario(menorEdad);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado (menor edad): " + e.getMessage());
        }

        // Error 3: documento duplicado (UNIQUE) - mismo documento que u1
        Usuario documentoDuplicado = new Usuario(
                "Carlos",
                "Gomez",
                "12345678", // mismo documento que u1
                "+573003334455",
                LocalDate.of(1995, 3, 20),
                "carlos@mail.com",
                "clave000"
        );
        try {
            usuarioService.registrarUsuario(documentoDuplicado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado (documento duplicado): " + e.getMessage());
        }

        // Error 4: correo con formato invalido (sin @)
        Usuario correoInvalido = new Usuario(
                "Laura",
                "Diaz",
                "99887766",
                "+573004445566",
                LocalDate.of(1999, 8, 21),
                "laura-mail.com", // sin @ ni punto
                "clave111"
        );
        try {
            usuarioService.registrarUsuario(correoInvalido);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado (correo invalido): " + e.getMessage());
        }

        // Resumen final: cuantos usuarios quedaron guardados
        System.out.println("\nUsuarios guardados: " + usuarioRepo.obtenerTodos().size());
        for (Usuario u : usuarioService.listarUsuarios()) {
            System.out.println(" - " + u);
        }
    }
}
