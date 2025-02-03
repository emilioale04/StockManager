## Historias de Usuario

### Nro: HU-001  
**Título:** Registrar una compra de acciones  
**Prioridad:** Alta  
**Estimación:** 10 horas  

**Historia de usuario:**  
Como inversor quiero registrar la compra de acciones ingresando la fecha, cantidad y valor de compra para llevar un control organizado de mis inversiones.  

**Criterios de aceptación:**  
- Dado que se ingresan datos válidos de la compra, cuando el usuario guarde la compra, entonces esta debe registrarse correctamente en el sistema.  
- Dado que se ingresan datos incompletos o inválidos, cuando el usuario intente guardar la compra, entonces se debe mostrar un mensaje de error.  

**Tareas de implementación:**  
- Diseñar la interfaz de registro de compras (1 hora).  
- Implementar validaciones en la entrada de datos (2 horas).  
- Codificar el método para guardar datos en la base de datos (3 horas).  
- Crear pruebas unitarias para el registro de compras (2 horas).  
- Probar con datos reales y validar escenarios excepcionales (2 horas).  

---

### Nro: HU-002  
**Título:** Consultar lista de compras de acciones  
**Prioridad:** Media  
**Estimación:** 8 horas  

**Historia de usuario:**  
Como inversor quiero visualizar una lista de mis compras de acciones realizadas con detalles como símbolo, companía, fecha de compra, cantidad y valor, para revisar mi historial de inversiones.  

**Criterios de aceptación:**  
- Dado que el usuario accede al sistema, cuando desee ver la lista de acciones compradas, entonces se debe mostrar la lista de compras registradas.  
- Dado que no existan compras registradas, cuando el usuario consulte la lista, entonces el sistema no debe mostrar ninguna compra.  

**Tareas de implementación:**  
- Diseñar la interfaz para listar compras (1 hora).  
- Implementar un servicio para obtener datos desde la base de datos (3 horas).  
- Codificar el método de filtrado y ordenación de datos en la lista (2 horas).  
- Probar la funcionalidad con diferentes escenarios de datos (2 horas).  

---

### Nro: HU-003  
**Título:** Calcular porcentaje de ganancia/pérdida  
**Prioridad:** Alta  
**Estimación:** 10 horas  

**Historia de usuario:**  
Como inversor quiero calcular el porcentaje de ganancia o pérdida de mis acciones en base al valor de compra y el valor actual, para evaluar el rendimiento de mi inversión.  

**Criterios de aceptación:**  
- Dado que se cuente con un valor actual válido para la acción, cuando el usuario solicite el cálculo de ganancia/pérdida, entonces el sistema debe mostrar el porcentaje correspondiente.
- Dado que no se disponga de un valor actual válido, cuando el usuario solicite el cálculo, entonces el sistema debe mostrar el mensaje "N/A".  

**Tareas de implementación:**  
- Diseñar la interfaz para ver cálculos de ganancia/pérdida (2 horas).  
- Implementar un método para calcular el porcentaje de ganancia/pérdida en base al valor de compra y el valor actual (3 horas).  
- Conectar la funcionalidad de cálculo con un servicio que obtenga el valor actual automáticamente desde una API (3 horas). 
- Probar la funcionalidad con escenarios reales y datos inválidos (2 horas).  

---

### Nro: HU-004  
**Título:** Actualizar el valor actual de las acciones  
**Prioridad:** Alta  
**Estimación:** 14 horas  

**Historia de usuario:**  
Como inversor quiero que el sistema actualice automáticamente el valor actual de cada acción, para que los cálculos reflejen siempre datos precisos y actualizados.  

**Criterios de aceptación:**  
- Dado que el sistema disponga de acceso a datos actualizados, cuando el usuario acceda al sistema y actualice los precios, entonces el valor actual de cada acción debe sincronizarse.  
- Dado que el sistema no pueda obtener los precios actualizados, cuando el usuario intente actualizar los precios, entonces el sistema debe mostrar un mensaje indicando que los valores no pudieron ser actualizados.  

**Tareas de implementación:**  
- Investigar y seleccionar un proveedor confiable de datos de acciones, como una API de precios (2 horas).  
- Diseñar un servicio que realice solicitudes automáticas para obtener los valores actuales de las acciones (4 horas).  
- Implementar la lógica para almacenar los valores actualizados en la base de datos (3 horas).  
- Manejar errores comunes como fallas de conexión, datos incompletos o problemas de límite de solicitudes (3 horas).  
- Probar la funcionalidad automática en diferentes escenarios (2 horas).  

---

### Nro: HU-005  
**Título:** Ver ganancia/pérdida en dólares  
**Prioridad:** Media  
**Estimación:** 8 horas  

**Historia de usuario:**  
Como inversor quiero ver mi ganancia/pérdida en dólares para tener una representación clara del rendimiento de mi inversión.  

**Criterios de aceptación:**  
- Dado que el sistema calcula correctamente el porcentaje de ganancia/pérdida, cuando el usuario solicite ver el valor en dólares, entonces el sistema debe mostrar la ganancia/pérdida en dólares según el valor actual y la cantidad de acciones.  
- Dado que no haya un valor actual válido, cuando el usuario intente ver el valor en dólares, entonces el sistema debe mostrar un mensaje de error.  

**Tareas de implementación:**  
- Implementar lógica para calcular y mostrar la ganancia/pérdida en dólares (3 horas).  
- Modificar la interfaz de usuario para mostrar el valor en dólares (2 horas).  
- Probar la funcionalidad con escenarios reales y datos inválidos (2 horas).  

---
### Nro: HU-006
**Título:** Ordenar acciones por letra y porcentaje de ganancia  
**Prioridad:** Media  
**Estimación:** 5 horas  

**Historia de usuario:**  
Como inversor, quiero poder ordenar mis acciones por letra (nombre) y porcentaje de ganancia, para visualizar de manera organizada mi cartera de inversiones.  

**Criterios de aceptación:**  
- Dado que el usuario tiene una lista de acciones registradas, cuando seleccione la opción de ordenar por letra, entonces el sistema debe mostrar las acciones ordenadas alfabéticamente.  
- Dado que el usuario tenga una lista de acciones registradas, cuando seleccione la opción de ordenar por porcentaje de ganancia, entonces el sistema debe mostrar las acciones ordenadas de mayor a menor ganancia (o pérdida).  
- Dado que no haya acciones registradas, cuando el usuario intente ordenar, entonces el sistema debe mostrar el mensaje "No hay acciones disponibles".  

**Tareas de implementación:**  
- Diseñar la interfaz para seleccionar el tipo de ordenamiento (1 hora).  
- Implementar la lógica para ordenar acciones por letra (2 horas).  
- Implementar la lógica para ordenar acciones por porcentaje de ganancia (2 horas).  

---
### Nro: HU-007
**Título:** Ver consolidado de inversiones  
**Prioridad:** Alta  
**Estimación:** 8 horas  

**Historia de usuario:**  
Como inversor, quiero ver un consolidado de mis inversiones que muestre el valor total de mi cartera, la ganancia/pérdida total y el rendimiento promedio, para tener una visión general de mi desempeño financiero.  

**Criterios de aceptación:**  
- Dado que el usuario tenga acciones registradas, cuando solicite ver el consolidado, entonces el sistema debe mostrar el valor total de la cartera, la ganancia/pérdida total y el rendimiento promedio.  
- Dado que no haya acciones registradas, cuando el usuario solicite ver el consolidado, entonces el sistema debe mostrar el mensaje "No hay acciones registradas".  

**Tareas de implementación:**  
- Diseñar la interfaz para mostrar el consolidado (2 horas).  
- Implementar la lógica para calcular el valor total de la cartera (2 horas).  
- Implementar la lógica para calcular la ganancia/pérdida total y el rendimiento promedio (3 horas).  
- Probar la funcionalidad con diferentes escenarios (1 hora).  

---
### Nro: HU-008 
**Título:** Exportar cartera de acciones a CSV  
**Prioridad:** Media  
**Estimación:** 6 horas  

**Historia de usuario:**  
Como inversor quiero exportar mi cartera de acciones a un archivo CSV, para poder analizar mis inversiones en herramientas externas como Excel o Google Sheets.  

**Criterios de aceptación:**  
- Dado que el usuario tenga acciones registradas, cuando seleccione la opción de exportar a CSV, entonces el sistema debe generar un archivo CSV con los datos de la cartera. 

**Tareas de implementación:**  
- Diseñar la interfaz para la opción de exportar a CSV (1 hora).  
- Implementar la lógica para generar el archivo CSV con los datos de la cartera (3 horas).  
- Probar la funcionalidad con diferentes escenarios (2 horas).  

---
### Nro: HU-009 
**Título:** Archivar acciones  
**Prioridad:** Baja  
**Estimación:** 4 horas  

**Historia de usuario:**  
Como inversor quiero poder archivar acciones que ya no estoy siguiendo activamente, para mantener mi cartera organizada y enfocada en las inversiones actuales.  

**Criterios de aceptación:**  
- Dado que el usuario seleccione una acción, cuando elija la opción de archivar, entonces la acción debe moverse a una sección de "Archivados" y no aparecer en la cartera activa.  
- Dado que el usuario quiera ver acciones archivadas, cuando seleccione la opción de "Ver archivados", entonces el sistema debe mostrar la lista de acciones archivadas.  

**Tareas de implementación:**  
- Diseñar la interfaz para archivar y ver acciones archivadas (1 hora).  
- Implementar la lógica para mover acciones a la sección de archivados (2 horas).  
- Probar la funcionalidad con diferentes escenarios (1 hora).  