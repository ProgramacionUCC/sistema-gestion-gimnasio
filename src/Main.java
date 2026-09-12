import model.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

import java.time.LocalDate;

// Demo HU-01: literal lo pedido - solo registrar y mostrar
public class Main {
    public static void main(String[] args) {
        // Se crean los cajones y el servicio (repository + service)
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);

        System.out.println("--- HU-01: Registrar usuarios del gimnasio ---");

        // Usuario 1
        Usuario u1 = new Usuario(
                "Mateo",
                "Bustamante",
                "12345678",
                "+573005698325",
                LocalDate.of(2000, 5, 10),
                "mateo@mail.com",
                "clave123"
        );
        usuarioService.registrarUsuario(u1);
        System.out.println("Usuario registrado: " + u1);

        // Usuario 2
        Usuario u2 = new Usuario(
                "Ana",
                "Lopez",
                "87654321",
                "+573001112233",
                LocalDate.of(1998, 6, 15),
                "ana@mail.com",
                "clave456"
        );
        usuarioService.registrarUsuario(u2);
        System.out.println("Usuario registrado: " + u2);

        System.out.println("Usuarios guardados: " + usuarioRepo.obtenerTodos().size());
        for (Usuario u : usuarioService.listarUsuarios()) {
            System.out.println(" - " + u);
        }
    }
}
