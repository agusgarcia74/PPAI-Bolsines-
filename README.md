# PPAI Bolsines · CU 28 Registrar recepción de bolsín

DSI 2026 · Grupo 4 · Entrega 2 (Diseño). Implementación del CU 28 con el **patrón State** sobre `Documentacion`.

Tablero: https://aznarvicente8.atlassian.net/browse/BOLS-1

## Cómo correr

Requisitos: Java 21 y Maven.

```bash
mvn spring-boot:run      # levanta en http://localhost:8080
mvn test                 # corre los tests
```

- Consola de la base: http://localhost:8080/h2-console
  JDBC URL `jdbc:h2:file:./data/bolsines`, usuario `sa`, sin contraseña.
- **Volver los datos al estado inicial:** parar la aplicación y borrar la carpeta `data/`.

## Stack

Java 21 · Spring Boot 3.5 · Spring Data JPA (Hibernate) · H2 en archivo · Thymeleaf · Maven. Aplicación web.

## Estructura (sigue los estereotipos del diagrama)

```
src/main/java/ar/edu/utn/frc/dsi/bolsines/
├── boundary/        PantallaRecepcionDeBolsines          <<boundary>>   Aznar (T7, T8)
├── control/         GestorRecepcionDeBolsines            <<control>>    Agustín (T5, T6)
│   └── dto/         objetos que viajan entre gestor y pantalla
├── entity/          entidades del dominio                <<entity>>
│   └── estado/      PATRÓN STATE: EstadoDocumentacion + 9 estados     Trini (T3)
├── repository/      repositorios de Spring Data                       Vale (T1)
└── servicio/        sesión y notificación CU 29 (simulada)            Vale (T2)
```

### Quién es dueño de qué

Nadie toca archivos de otro: si necesitás un cambio, se lo pedís al dueño.

| Archivo(s) | Dueño | Tarjeta |
|---|---|---|
| `ComisionMedica`, `Empleado`, `Usuario`, `Sesion`, `TipoDocumentacion`, `repository/*`, `application.properties`, carga de datos | Vale | T1 |
| `servicio/*` | Vale | T2 |
| `entity/estado/*` | Trini | T3 |
| `Documentacion`, `CambioEstadoDocumentacion`, tests de la máquina de estados | Trini | T4 |
| `control/*`, `Bolsin`, `Remito`, `DetalleRemito`, `CambioEstadoBolsin`, `Estado` | Agustín | T5, T6 |
| `boundary/*`, `templates/*`, `static/*` | Aznar | T7, T8 |

Cada método pendiente lanza `UnsupportedOperationException("TODO Tn")` con el número de tarjeta que lo completa. Para ver lo tuyo: buscá `TODO T3` (o el que corresponda).

## Contrato gestor ↔ pantalla

La pantalla solo usa estos cinco métodos de `GestorRecepcionDeBolsines`. **No se cambian sin avisar.**

| Método | Pasos del CU | Devuelve |
|---|---|---|
| `opcionRegistrarRecepcionDeBolsin()` | 1 a 4 | `InicioRecepcion`: CM del usuario y bolsines enviados hacia ella |
| `tomarSeleccionBolsin(Long idBolsin)` | 5 y 6 | `DetalleBolsin`: remitos y documentación (asunto y tipo) |
| `tomarSeleccionRecepcionBolsin(Map<Long, SituacionRecepcion>)` | 7 a 9 | `ResumenRecepcion`: cómo va a quedar todo |
| `tomarConfirmacionRegistro()` | 10 a 12 | `ResultadoRecepcion`: lo registrado y los avisos del CU 29 |
| `cancelar()` | Obs. 1 / A6 | nada |

`SituacionRecepcion` es cómo llegó cada documentación: `RECIBIDA` (principal), `FALTANTE` (A3), `NO_CORRESPONDE` (A4), `REDIRIGIR` (A5, solo CMC).

Mientras el gestor real no esté, esos métodos devuelven **datos de mentira** (`GestorDatosDeMentira`), así la pantalla avanza sin esperar. Se borra en la T9.

## Patrón State en una línea

`Documentacion` (contexto) no pregunta en qué estado está: le delega cada operación a su `EstadoDocumentacion` actual. Lo que un estado no redefine queda prohibido (`TransicionInvalidaException`). El estado se guarda en la base por su nombre (`EstadoDocumentacionConverter`).

Nombres: se usa **`Registrada`** (como en la máquina de estados). En el diagrama de clases figura como "Registrado": hay que corregir el diagrama.

## Ramas

Una rama por tarjeta, desde `main`:

```
feature/t1-persistencia    feature/t2-sesion-notificacion
feature/t3-state           feature/t4-documentacion
feature/t5-gestor          feature/t6-alternativos
feature/t7-pantalla-bandeja feature/t8-pantalla-control
```

Commits con el prefijo de la tarjeta: `BOLS-5 feat(state): transiciones de EnBolsinEnviado`.
