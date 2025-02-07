# Reglas para Realizar Commits

Un mensaje de commit debe incluir los siguientes elementos:

1. **Tipo del cambio:** Indica qué tipo de modificación se realizó.
2. **Descripción corta:** Resumen claro y breve de lo que se cambió (máximo 50 caracteres).
3. **Descripción larga (opcional):** Explica en más detalle qué y por qué se realizó el cambio.
4. **Referencia (opcional):** Relación con una tarea o historia de usuario específica, como un ID de ticket.

---

## Formato del Mensaje

```plaintext
<Tipo>: <Descripción corta>
<Descripción larga opcional>
Refs: <Referencia opcional>
```

## Tipos de Commit (Tipo)

Usa un tipo para clasificar el propósito del commit:

| **TIPO**   | **DESCRIPCIÓN**                                                                 |
|------------|---------------------------------------------------------------------------------|
| `feat`     | Se agregó una nueva funcionalidad.                                             |
| `fix`      | Se solucionó un bug o error.                                                  |
| `refactor` | Cambios en el código que no afectan su funcionalidad (mejoras estructurales). |
| `test`     | Se agregaron o modificaron pruebas.                                           |
| `docs`     | Cambios en documentación (README, comentarios).                               |
| `style`    | Cambios de estilo (formato, espacios, etc.) sin afectar la funcionalidad.     |
| `perf`     | Mejoras en el rendimiento del sistema.                                        |
| `build`    | Cambios relacionados con el sistema de compilación o dependencias.           |
| `ci`       | Configuración o cambios en la integración continua (CI/CD).                  |
| `chore`    | Tareas menores o mantenimiento (no relacionadas con código o funcionalidades).|

---

## Ejemplos de Mensajes de Commit

### Agregar una nueva funcionalidad:
```plaintext
feat: add functionality to register stock purchases
- Implemented the interface for stock purchase registration
- Added input validations for required fields
Refs: HU-001
```

### Corregir un error

```plaintext
fix: correct calculation of profit percentage
- Resolved division by zero error when purchase price is zero
Refs: HU-003
```


### Refactorizar Código

```plaintext
refactor: optimize DAO methods for stock retrieval
- Updated StockDAOImpl to use prepared statements
- Removed redundant code for database connection handling
```

## Consideraciones para Realizar Commits

1. **Claridad:**
   - Cada mensaje debe responder: ¿Qué cambió? ¿Por qué cambió?
   - Evitar mensajes genéricos como: `Updated code`, `Fix issue`.

2. **Un commit por cambio lógico:**
   - Divide los cambios en commits pequeños y significativos.
   - No combinar múltiples cambios no relacionados en un solo commit.

3. **Presente en lugar de pasado:**
   - Escribir el mensaje del commit en tiempo presente.
   - **Ejemplo:** `fix: update error handling` en lugar de `fixed error handling`.
