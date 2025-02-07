## Casos de Prueba - Stock Manager

**Equipo:** FastBite Solutions  
**Fecha:** 06-02-2025  

---

## ID: CP01 - Registro de Compra

**Descripción:**
Verificar que un usuario pueda registrar una compra en el sistema.

### Procedimiento de prueba:
1. Acceder a la pantalla de registro de compra.
2. Ingresar los datos obligatorios (producto, cantidad, precio, fecha).
3. Guardar la compra.

### Resultados esperados:
El sistema registra la compra correctamente y muestra un mensaje de confirmación.

### EJECUCIONES DEL CASO DE PRUEBA

![Prueba 1](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen1.png)
![Prueba 2](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen2.png)
![Prueba 3](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen3.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** El sistema registró la compra correctamente.  
- [ ] Reprobado
- [x] Aprobado  

---

## ID: CP02 - Búsqueda de Compra

**Descripción:**
Verificar que un usuario pueda buscar compras registradas en el sistema.

### Procedimiento de prueba:
1. Acceder a la pantalla de Consolidado.
2. Ingresar un criterio de búsqueda válido.
3. Ejecutar la búsqueda.

### Resultados esperados:
El sistema muestra la lista de compras que coinciden con el criterio de búsqueda.

### EJECUCIONES DEL CASO DE PRUEBA

![Prueba 4](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen4.png)
![Prueba 5](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen5.png)
![Prueba 6](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen6.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** El sistema mostró correctamente las compras.  
- [ ] Reprobado
- [x] Aprobado  

---

## ID: CP03 - Calcular ganancia/pérdida (Valor actual válido)

**Descripción:**
Verificar cálculo correcto de porcentaje.

### Procedimiento de prueba:
1. Acceder a "Detalle de Acción".
2. Solicitar cálculo de ganancia/pérdida.

### Resultados esperados:
Porcentaje calculado (ej: +6.66%).

### EJECUCIONES DEL CASO DE PRUEBA

![Prueba 7](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen7.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** El porcentaje se calculó correctamente.  
- [ ] Reprobado
- [x] Aprobado  

---

## ID: CP04 - Actualizar valor actual (Éxito)

**Descripción:**
Verificar que los precios se actualizan desde la API.

### Procedimiento de prueba:
1. Hacer clic en "Actualizar Precios".
2. Visualizar la actualización.

### Resultados esperados:
Valores actualizados (ej: AAPL = 160).

### EJECUCIONES DEL CASO DE PRUEBA

![Prueba 8](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen8.png)
![Prueba 9](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen9.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** Los precios se actualizaron correctamente.  
- [ ] Reprobado
- [x] Aprobado  

---

## ID: CP05 - Ver ganancia en dólares (Válido)

**Descripción:**
Verificar cálculo correcto en USD.

### Procedimiento de prueba:
1. Acceder a "Detalle de Acción".
2. Solicitar ver ganancia en dólares.

### Resultados esperados:
Acción con valor actual válido (ej: ganancia = +$100). "$100 de ganancia".

### EJECUCIONES DEL CASO DE PRUEBA

![Prueba 10](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen10.png)
![Prueba 11](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen11.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** La ganancia en dólares se mostró correctamente.  
- [ ] Reprobado
- [x] Aprobado  

---

## ID: CP06 - Exportación de Reporte

**Descripción:**
Verificar orden alfabético (A-Z).

### Procedimiento de prueba:
1. Seleccionar "Ordenar por Letra" o por Ganancia ($) en pérdida o ganancia que se representa con una flecha arriba para ganancia y abajo para pérdida.
2. Visualizar el orden.

### Resultados esperados:
Lista ordenada: AAPL → GOOGL → TSLA.

### EJECUCIONES DEL CASO DE PRUEBA
![Prueba 12](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen12.png)
![Prueba 13](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen13.png)
![Prueba 14](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen14.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** Las acciones se ordenaron alfabéticamente correctamente.  
- [ ] Reprobado
- [x] Aprobado  

---

## ID: CP07 - Ver consolidado (Con datos)

**Descripción:**
Verificar cálculos de totales.

### Procedimiento de prueba:
1. Acceder a "Consolidado".

### Resultados esperados:
Valor total = $3500.

### EJECUCIONES DEL CASO DE PRUEBA

![Prueba 15](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen15.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** El consolidado mostró el valor total correcto.  
- [ ] Reprobado
- [x] Aprobado  

---

## ID: CP08 - Exportar a CSV

**Descripción:**
Verificar generación de archivo CSV.

### Procedimiento de prueba:
1. Hacer clic en "Exportar a CSV".

### Resultados esperados:
Archivo "cartera.csv" descargado con datos correctos.

### EJECUCIONES DEL CASO DE PRUEBA

![Prueba 16](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen16.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** El archivo CSV se generó y descargó correctamente.  
- [ ] Reprobado
- [x] Aprobado  

---

## ID: CP09 - Archivar acción

**Descripción:**
Verificar que una acción se mueve a "Archivados".

### Procedimiento de prueba:
1. Seleccionar una acción comprada, por ejemplo: AAPL → "Archivar".
2. Acceder a "Archivo".
3. Se visualizarán las compras archivadas.
4. Desarchivar desde la pestaña “Archivo”.
5. Seleccionar “Desarchivar”.
6. Volver a “Inicio” y se verán las acciones de nuevo.

### Resultados esperados:
La acción se archivó correctamente y no aparece en la cartera activa, pero sí en la archivada. De misma forma para desarchivar de una pestaña a otra.

### EJECUCIONES DEL CASO DE PRUEBA

![Prueba 17](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen17.png)
![Prueba 18](https://github.com/WdeGuily526/PROYECTO_RegistroCompraAcciones_CodeForge/blob/main/Imagen18.png)

**Fecha:** 04-02-2025  
**Responsable:** William Enriquez  
**Resultados obtenidos:** La acción se archivó correctamente y no aparece en la cartera activa.  
- [ ] Reprobado
- [x] Aprobado  

---

