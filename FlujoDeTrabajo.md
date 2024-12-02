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