import model.Usuario;
import model.PlanEntrenamiento;
import repository.UsuarioRepository;
import repository.PlanRepository;
import service.UsuarioService;
import service.PlanService;

import java.time.LocalDate;

// Demo HU-01 + HU-02
public class Main {
    public static void main(String[] args) {
        // --- HU-01: Registrar usuarios ---
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);

        System.out.println("--- HU-01: Registrar usuarios del gimnasio ---");

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

        // --- HU-02: Registrar planes ---
        PlanRepository planRepo = new PlanRepository();
        PlanService planService = new PlanService(planRepo);

        System.out.println("\n--- HU-02: Registrar planes de entrenamiento ---");

        PlanEntrenamiento plan1 = new PlanEntrenamiento(
                "101",
                "Plan Musculacion",
                "Rutina de fuerza 5 dias por semana",
                8,
                150000,
                "INTERMEDIO"
        );
        planService.registrarPlan(plan1);
        System.out.println("Plan registrado: " + plan1);

        PlanEntrenamiento plan2 = new PlanEntrenamiento(
                "102",
                "Plan Cardio",
                "Rutina de cardio y resistencia",
                4,
                80000,
                "BASICO"
        );
        planService.registrarPlan(plan2);
        System.out.println("Plan registrado: " + plan2);

        System.out.println("Planes guardados: " + planRepo.obtenerTodos().size());
        for (PlanEntrenamiento p : planService.listarPlanes()) {
            System.out.println(" - " + p);
        }
    }
}
