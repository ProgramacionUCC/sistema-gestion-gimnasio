import model.Usuario;
import model.PlanEntrenamiento;
import model.Inscripcion;
import model.Entrenador;
import repository.UsuarioRepository;
import repository.PlanRepository;
import repository.InscripcionRepository;
import repository.EntrenadorRepository;
import service.UsuarioService;
import service.PlanService;
import service.InscripcionService;
import service.EntrenadorService;

import java.time.LocalDate;

// demo de todo hasta HU-04
public class Main {
    public static void main(String[] args) {
        // --- HU-01: usuarios ---
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);

        System.out.println("--- HU-01: Registrar usuarios ---");

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

        // --- HU-02: planes ---
        PlanRepository planRepo = new PlanRepository();
        PlanService planService = new PlanService(planRepo);

        System.out.println("\n--- HU-02: Registrar planes ---");

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

        // --- HU-03: inscribir ---
        InscripcionRepository inscripcionRepo = new InscripcionRepository();
        InscripcionService inscripcionService = new InscripcionService(inscripcionRepo);

        System.out.println("\n--- HU-03: Inscribir usuarios en planes ---");

        inscripcionService.inscribirUsuarioEnPlan("12345678", "101");
        System.out.println("Inscrito 12345678 en 101");

        inscripcionService.inscribirUsuarioEnPlan("12345678", "102");
        System.out.println("Inscrito 12345678 en 102");

        inscripcionService.inscribirUsuarioEnPlan("87654321", "101");
        System.out.println("Inscrito 87654321 en 101");

        System.out.println("Inscripciones: " + inscripcionRepo.obtenerTodas().size());

        // --- HU-04: entrenadores ---
        EntrenadorRepository entrenadorRepo = new EntrenadorRepository();
        EntrenadorService entrenadorService = new EntrenadorService(entrenadorRepo);

        System.out.println("\n--- HU-04: Registrar entrenadores ---");

        // entrenador 1
        Entrenador e1 = new Entrenador(
                "Carlos",
                "Ramirez",
                "11223344",
                "Pesas", // especialidad
                "+573002223344",
                "carlos@gimnasio.com"
        );
        entrenadorService.registrarEntrenador(e1);
        System.out.println("Entrenador registrado: " + e1);

        // entrenador 2
        Entrenador e2 = new Entrenador(
                "Luisa",
                "Martinez",
                "55667788",
                "Yoga",
                "+573003334455",
                "luisa@gimnasio.com"
        );
        entrenadorService.registrarEntrenador(e2);
        System.out.println("Entrenador registrado: " + e2);

        System.out.println("Entrenadores guardados: " + entrenadorRepo.obtenerTodos().size());
        for (Entrenador e : entrenadorService.listarEntrenadores()) {
            System.out.println(" - " + e);
        }
    }
}
