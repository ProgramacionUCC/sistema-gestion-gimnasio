# Sistema de Gestión de Gimnasio

**Proyecto 1 - Programación UCC**
**Integrantes:** Mateo y Manuel

Aplicación Java para administrar la información de un gimnasio. Implementación por capas `model` / `repository` / `service` con almacenamiento temporal en memoria (`ArrayList`).

## Requisitos Funcionales

El sistema debe permitir:

1. Registrar usuarios del gimnasio.
2. Registrar planes de entrenamiento.
3. Inscribir usuarios en uno o varios planes.
4. Registrar entrenadores y sus especialidades.
5. Registrar sesiones de entrenamiento dirigidas por entrenadores.
6. Registrar pagos de membresías.
7. Registrar las salas o áreas disponibles en el gimnasio.

## Requisitos Técnicos

- Entidades mediante clases en la capa `model` (`src/model`).
- Constructores para inicializar los objetos.
- Encapsulamiento en todos los atributos (`private` + getters/setters).
- Almacenamiento temporal usando `ArrayList`.
- Capa `repository` para gestionar los datos en memoria (`src/repository`).
- Capa `service` para la lógica de negocio (`src/service`).
- Gestión con Git: `main`, `develop`, una rama por funcionalidad (`feature/HU-0X-*`), commits con mensajes descriptivos.

## Estructura del Proyecto

```
src/
├── model/
│   ├── Usuario.java
│   ├── PlanEntrenamiento.java
│   ├── Inscripcion.java
│   ├── Entrenador.java
│   ├── SesionEntrenamiento.java
│   ├── PagoMembresia.java
│   └── Sala.java
├── repository/
│   ├── UsuarioRepository.java
│   ├── PlanRepository.java
│   ├── InscripcionRepository.java
│   ├── EntrenadorRepository.java
│   ├── SesionRepository.java
│   ├── PagoMembresiaRepository.java
│   └── SalaRepository.java
├── service/
│   ├── UsuarioService.java
│   ├── PlanService.java
│   ├── InscripcionService.java
│   ├── EntrenadorService.java
│   ├── SesionService.java
│   ├── PagoMembresiaService.java
│   └── SalaService.java
└── Main.java
```

### Capas

- **model:** POJOs con atributos `private`, constructor con campos obligatorios, `getters` y `toString`. Sin validación (la hace el service).
- **repository:** `private final List<T> = new ArrayList<>()`. Métodos `guardar(T)`, `obtenerTodos()` (copia), `getX()` (referencia interna) y consultas específicas (`obtenerPorUsuario`, `obtenerPorEntrenador`, `obtenerPorTipo`).
- **service:** Inyección del repository por constructor. Método `registrarX(T)` valida obligatorios con helper `vacio(String)` y lanza `IllegalArgumentException`, luego `repository.guardar()`. Métodos `listarX()` delegan al repository.

## Historias de Usuario

### HU-01 - Registrar usuarios del gimnasio
- **Model:** `Usuario` (`nombre`, `apellido`, `documentoDeIdentidad` String, `celular` String, `fechaNacimiento` LocalDate, `correo`, `clave`)
- **Repository:** `UsuarioRepository` - `guardarUsuario`, `getUsuarios`, `obtenerTodos`
- **Service:** `UsuarioService.registrarUsuario` valida 7 obligatorios no vacíos

### HU-02 - Registrar planes de entrenamiento
- **Model:** `PlanEntrenamiento` (`codigo`, `nombre`, `descripcion`, `duracionSemanas` int, `precio` int, `nivel`)
- **Repository:** `PlanRepository` - `guardar`, `obtenerTodos`, `getPlanes`
- **Service:** `PlanService.registrarPlan` valida `codigo/nombre/descripcion/nivel`

### HU-03 - Inscribir usuarios en uno o varios planes
- **Model:** `Inscripcion` (`documentoUsuario`, `codigoPlan`, `fechaInscripcion` LocalDate.now() automática)
- **Repository:** `InscripcionRepository` - `guardar`, `obtenerTodas`, `getInscripciones`, `obtenerPorUsuario`
- **Service:** `InscripcionService.inscribirUsuarioEnPlan(documento, codigo)` valida no vacío, crea `Inscripcion`

### HU-04 - Registrar entrenadores y sus especialidades
- **Model:** `Entrenador` (`nombre`, `apellido`, `documento`, `especialidad`, `celular`, `correo`)
- **Repository:** `EntrenadorRepository` - `guardar`, `obtenerTodos`, `getEntrenadores`
- **Service:** `EntrenadorService.registrarEntrenador` valida 6 obligatorios

### HU-05 - Registrar sesiones de entrenamiento dirigidas por entrenadores
- **Model:** `SesionEntrenamiento` (`codigo`, `documentoEntrenador` FK a Entrenador, `fecha` LocalDate, `horaInicio` LocalTime, `duracionMinutos` int, `tipoSesion`)
- **Repository:** `SesionRepository` - `guardar`, `obtenerTodas`, `getSesiones`, `obtenerPorEntrenador`
- **Service:** `SesionService.registrarSesion` valida `codigo/documentoEntrenador/fecha/hora/tipoSesion`

### HU-06 - Registrar pagos de membresías
- **Model:** `PagoMembresia` (`codigo`, `documentoUsuario` FK a Usuario, `monto` double, `fechaPago` LocalDate, `metodoPago`, `mesPagado` String ej. "2026-09")
- **Repository:** `PagoMembresiaRepository` - `guardar`, `obtenerTodos`, `getPagos`, `obtenerPorUsuario`
- **Service:** `PagoMembresiaService.registrarPago` valida obligatorios y `monto > 0`

### HU-07 - Registrar las salas o áreas disponibles en el gimnasio
- **Model:** `Sala` (`codigo`, `nombre`, `capacidad` int, `tipo`, `ubicacion`)
- **Repository:** `SalaRepository` - `guardar`, `obtenerTodas`, `getSalas`, `obtenerPorTipo` (equalsIgnoreCase)
- **Service:** `SalaService.registrarSala` valida obligatorios y `capacidad > 0`

## Ejecución

### IntelliJ IDEA
Abrir el proyecto y ejecutar `src/Main.java` (demo acumulativa HU-01..HU-07).

### CLI (JDK 25)
```bash
javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out Main
```

Salida esperada incluye bloques:
```
--- HU-01: Registrar usuarios ---
--- HU-02: Registrar planes ---
--- HU-03: Inscribir usuarios en planes ---
--- HU-04: Registrar entrenadores ---
--- HU-05: Registrar sesiones de entrenamiento ---
--- HU-06: Registrar pagos de membresias ---
--- HU-07: Registrar salas o areas disponibles ---
```

`Main.java` instancia cada `Repository` + `Service`, registra 2 objetos por HU y lista el contenido.

## Git Workflow

- **main:** rama principal estable.
- **develop:** integración de funcionalidades.
- **feature/HU-0X-*:** una rama por HU desde `develop` (`HU-01-registrar-usuarios`, `HU-02-registrar-planes-entrenamiento`, `HU-03-inscribir-usuarios-planes`, `HU-04-registrar-entrenadores`, `HU-05-registrar-sesiones`, `HU-06-registrar-pagos`, `HU-07-registrar-salas`).
- **hotfix/HU-01-ajuste-literal:** ajuste a lo literal.
- **docs:** documentación (esta rama).
- Commits con formato `feat: [HU-0X] descripción - model/repository/service literal` y `fix:` para correcciones.

Flujo por HU:
```bash
git checkout develop
git fetch --all --prune; git pull origin develop
git checkout -b feature/HU-0X-nombre
# cambios model/repository/service + Main
git commit -m "feat: [HU-0X] ..."
git push -u origin feature/HU-0X-nombre
# PR -> develop
```

## Estado Actual

- `develop` en `bc6104d` (merge HU-07). Todas las HUs 01-07 implementadas y verificadas con `javac`/`java`.
- Ramas remotas: `feature/HU-01` a `feature/HU-07` + `docs` (esta).
