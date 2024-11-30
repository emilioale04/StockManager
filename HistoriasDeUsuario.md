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
