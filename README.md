# Sistema de Gestión de Acciones "Stock Manager"

El **Sistema de Gestión de Acciones "Stock Manager"** es una aplicación web basada en Java diseñada para ayudar a los inversores a gestionar sus portafolios de acciones de manera efectiva. Proporciona herramientas para registrar compras, rastrear el desempeño y calcular ganancias o pérdidas.

## **Características**
- **Gestión de Compras de Acciones**: Registra las compras de acciones con detalles como fecha, cantidad y precio de compra.
- **Seguimiento de Desempeño**: Visualiza una lista de compras realizadas y calcula el porcentaje de ganancias o pérdidas.
- **Actualización de Precios**: Obtén precios actualizados de acciones en tiempo real desde una API externa.
- **Cálculo de Ganancias/Pérdidas**: Calcula tanto el porcentaje como el valor absoluto de las ganancias o pérdidas.

---

## **Requisitos Previos**
- **Java**: Versión 17 o superior.
- **PostgreSQL**: Base de datos para almacenar información sobre acciones.
- **Maven**: Para la gestión de dependencias.
- **Tomcat**: Versión 9 como servidor web.
- **IntelliJ IDEA**: IDE recomendado para el desarrollo.

---

## **Instalación desde IntelliJ IDEA**

1. Crear una base de datos en PostgreSQL llamada `stocks_db`:
2. Actualizar las propiedades del proyecto como el usuario y clave para PostgreSQL.
3. Configurar la ejecución con el Servidor Tomcat:
   - Abrir el menú de configuraciones en IntelliJ.
   - Seleccionar Tomcat como servidor de aplicación.
   - Agregar el artefacto `StockManager:war exploded`.

4. Ejecutar la configuración para desplegar el proyecto.

---

## **Autores**

Este proyecto fue desarrollado por:

- **FastBite Solutions**
    - Equipo de desarrollo especializado de la EPN.
