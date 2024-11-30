## 1. Introducción del Proyecto

El Sistema de Gestión de Acciones “**Stock Manager**” es una aplicación web basada en Java diseñada para proporcionar a los usuarios herramientas para gestionar eficazmente sus inversiones en acciones. El objetivo principal del sistema es permitir a los inversores registrar y evaluar sus compras de acciones de forma organizada y fácil de usar.

---

## 2. Entregables

### a. Documento de Flujo de Trabajo
El documento incluirá:
1. **Explicación GitFlow:** Explica cómo gestionar las ramas.
2. **Pasos para contribuir al repositorio:**
   - Cómo crear una rama.
   - Cómo realizar un commit.
   - Proceso de fusión de ramas.

### b. Estándares de Codificación
Incluye:
1. Uso de estándares de codificación.
2. Nombres descriptivos para clases, métodos y variables.
3. Comentarios claros.
4. Organización de paquetes por capas (controladores, servicios, repositorios, entidades).

### c. Documentos del Proyecto
1. **Historias de Usuario (para los requisitos):**
   - Cada historia debe incluir un título, descripción, criterios de aceptación y tareas relacionadas.
2. **Diseño:**
   - Modelo ER de la base de datos.

### d. Código Final
Estructura completa del proyecto Java-Web, con persistencia en PostgreSQL, siguiendo los estándares.

---

## 3. Desarrollo

1. **Configuración Inicial:**
   - **IDE:** IntelliJ IDEA.
   - Crear un proyecto Java Web.
   - Configurar PostgreSQL y dependencias (JPA/Hibernate).
   - Configurar Maven para gestionar dependencias.
   
2. **Backend:**
   - Implementar controladores, servicios y repositorios.

3. **Frontend:**
   - Usar tecnologías como HTML5, CSS3 y JavaScript.
   - Crear formularios para registrar compras.
   - Crear vistas para mostrar el cálculo de ganancias/pérdidas.

4. **Pruebas:**
   - **Unitarias:** Pruebas para métodos en servicios y repositorios.
   - **Manuales:** Asegúrate de que la interfaz de usuario funcione como se espera.

### Despliegue
1. **Servidor:**
   - Configurar un servidor local (Tomcat).

---

## 4. Herramientas y Tecnologías por utilizar

1. **Backend:**
   - Java 17
   - Hibernate

2. **Base de Datos:**
   - PostgreSQL

3. **Frontend:**
   - JSP, HTML, CSS, JavaScript

4. **Control de Versiones:**
   - Git + GitHub

5. **IDE:**
   - IntelliJ IDEA

6. **Servidor:**
   - Tomcat 9.0.97

7. **Posibles APIs a utilizar:**
   - AlphaVantage
   - Finnhub
   - Polygon.io
