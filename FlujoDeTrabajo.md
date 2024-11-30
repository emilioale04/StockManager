# Introducción
Este documento describe el flujo de trabajo a utilizar en el proyecto para la gestión de versiones y colaboración en equipo, basado en la metodología **GitFlow**. GitFlow es un modelo de ramificación que organiza el desarrollo en diferentes fases, asegurando calidad y estabilidad en el código.

**Nota:** se utilizará el **inglés** como estándar.

---

## 1. Descripción del Flujo GitFlow

### 1.1. Ramas Principales

1. **Main (main):**
   - Representa la versión estable del código.
   - Contiene únicamente las versiones listas para producción.
   - **Regla:** No se realiza desarrollo directo en esta rama.

2. **Develop (develop):**
   - Contiene el código en desarrollo.
   - Aquí se integran las funcionalidades completadas antes de prepararlas para producción.
   - **Regla:** Todas las nuevas características deben fusionarse aquí después de ser revisadas.

---

### 1.2. Ramas Secundarias

1. **Feature (feature/nombre-de-la-funcionalidad):**
   - Usada para desarrollar nuevas funcionalidades o historias de usuario.
   - Creadas a partir de `develop`.
   - Al finalizar, se fusionan de nuevo a `develop` mediante un Pull Request.

   **Reglas:**
   - Cada funcionalidad debe desarrollarse en su propia rama `feature/`.
   - Nombrar la rama con un prefijo `feature/` y un nombre descriptivo.
   - **Ejemplo:** `feature/register-stock`.

2. **Release (release/nombre-de-la-version):**
   - Usada para preparar una nueva versión para producción.
   - Creadas a partir de `develop`.
   - Permiten realizar pruebas finales y ajustes menores.

   **Reglas:**
   - Nombrar las ramas con un prefijo `release/` seguido del número de versión.
   - **Ejemplo:** `release/v1.0`.

3. **Hotfix (hotfix/nombre-del-fix):**
   - Usada para corregir errores críticos en producción.
   - Creadas a partir de `main` y fusionadas tanto a `main` como a `develop`.

   **Reglas:**
   - Nombrar las ramas con un prefijo `hotfix/` seguido de una descripción del problema.
   - **Ejemplo:** `hotfix/fix-profit-calculation`.

# 2. Flujo de Trabajo

## 2.1. Creación de Ramas

1. **Nueva funcionalidad (feature):**
   - Crea una rama desde `develop`.

2. **Preparación para producción (release):**
   - Crea una rama desde `develop` para la versión.

3. **Corrección de errores críticos (hotfix):**
   - Crea una rama desde `main`.


---

## 2.2. Fusión de Ramas

1. **Ramas feature a develop:**
   - Al terminar el desarrollo, se debe fusionar de la rama `feature` a `develop` mediante un Pull Request.

2. **Ramas release a main y develop:**
   - Una vez probada la versión, se debe fusionar la rama `release` a `main` y `develop`, mediante un Pull Request.

3. **Ramas hotfix a main y develop:**
   - Una vez corregido el error crítico, se debe fusionar la rama a `develop` y `main`, mediante un Pull Request.

---

# 3. Reglas de Colaboración

1. **Uso de Pull Requests:**
   - Toda rama debe ser revisada antes de fusionarse.
   - Crear un Pull Request en GitHub.
   - Al menos un revisor debe aprobar el PR antes de la fusión.

2. **Resolución de Conflictos:**
   - Si hay conflictos, deben resolverse localmente antes de fusionar.

3. **Sin commits directos en main o develop:**
   - Todo cambio debe pasar por ramas `feature`, `release` o `hotfix`.

# 4. Flujo Resumido

1. **Nueva funcionalidad:**
   - Crea `feature/` → Desarrolla → PR → Fusiona en `develop`.

2. **Nueva versión:**
   - Crea `release/` → Ajustes finales → Fusiona en `main` y `develop`.

3. **Corrección crítica:**
   - Crea `hotfix/` → Corrige → Fusiona en `main` y `develop`.

# 5. Reglas para Realizar Commits

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


