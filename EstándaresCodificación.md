# Introducción

Este documento establece los estándares de codificación que deben seguirse durante el desarrollo del proyecto. El propósito es garantizar que el código sea legible, mantenible y consistente, especialmente cuando se trabaja en equipo. Todos los nombres, comentarios y documentación deben escribirse en inglés.

---

## 1. Organización del Proyecto

1. El proyecto debe organizarse siguiendo una arquitectura basada en capas, con paquetes claramente definidos:
   - **controller:** Para las clases que manejan las solicitudes y respuestas de la aplicación (servlets).
   - **service:** Para la lógica de negocio.
   - **dao:** Para la interacción con la base de datos.
   - **model:** Para las clases de datos (entidades).
   - **config:** Para configuraciones específicas de la aplicación (ej. Conexión a la BD).
   - **api:** Para la conexión y uso de la api.

2. Los paquetes deben nombrarse utilizando nombres en minúsculas y descriptivos, separados por puntos (`.`), siguiendo este esquema:

```plaintext
epn.fis.stockmanager.controller
epn.fis.stockmanager.service
```
---

## 2. Nomenclatura

### 2.1. Clases
- Todas las clases deben tener nombres en **PascalCase** (capitalización de cada palabra) y ser sustantivos que describan su propósito.
- **Ejemplos:**
```java
public class StockPurchase { }
public class ProfitCalculator { }
```

---

### 2.2. Métodos
- Los métodos deben tener nombres en **camelCase**, comenzando con un verbo que indique claramente su función.
- **Ejemplos:**
```java
public void calculateProfit() { }
public String getStockDetails() { }
```

---

### 2.3. Variables
- Las variables deben tener nombres en **camelCase**, ser descriptivas y en inglés.
- **Ejemplos:**
```java
int stockQuantity;
double purchaseValue;
LocalDate purchaseDate;
```

---

### 2.4. Constantes
- Las constantes deben definirse en **mayúsculas**, separando palabras con guiones bajos (`_`).
- **Ejemplos:**
```java
public static final double TAX_RATE = 0.15;
public static final String DEFAULT_CURRENCY = "USD";
```

---

## 3. Métodos

### 3.1. Propósito
- Cada método debe realizar una única tarea específica.
- No se debe exceder un tamaño de **40 líneas de código**, salvo casos excepcionales.

---

### 3.2. Parámetros
- Los métodos deben limitarse a un máximo de **cinco parámetros**. Si se requieren más, deben agruparse en un objeto.
- **Ejemplo:**
```java
public void registerStock(String stockName, double value, int quantity) { }	
```

### 3.3. Visibilidad
- Los métodos que no necesiten acceso externo deben declararse como **private**.
- **Ejemplo:**
```java
private double calculatePercentage(double oldValue, double newValue) {
    return ((newValue - oldValue) / oldValue) * 100;
}
```

---

## 4. Comentarios

### 4.1. Comentarios de Clases
- Cada clase debe estar documentada con JavaDoc, describiendo su propósito.
- **Ejemplo:**
```java
/**
 * Represents a stock purchase.
 * Contains information such as purchase date, quantity, and value.
 */
public class StockPurchase { }
```

### 4.2. Comentarios de Métodos
- Cada método debe estar documentado usando JavaDoc, indicando su propósito, parámetros y valor de retorno.
- **Ejemplo:**
```java
/**
 * Calculates the profit or loss percentage based on the purchase value and current value.
 *
 * @param purchaseValue The initial purchase value.
 * @param currentValue The current market value.
 * @return Profit or loss percentage.
 */
public double calculateProfitPercentage(double purchaseValue, double currentValue) {
    return ((currentValue - purchaseValue) / purchaseValue) * 100;
}
```


### 4.3. Comentarios en el Código
- Los comentarios en el código deben utilizarse solo cuando sea necesario explicar una lógica compleja. No deben ser redundantes.
- **Ejemplo:**
```java
// Calculate the percentage of profit or loss
double profitPercentage = calculateProfitPercentage(purchaseValue, currentValue);
```

## 5. Formato y Estilo

### 5.1. Indentación
- El código debe utilizar **4 espacios** para la indentación. No deben usarse tabuladores.

### 5.2. Líneas Máximas
- Como recomendación, no exceder los **80 caracteres por línea**.

### 5.3. Espaciado
- Debe haber una línea en blanco:
  - Entre métodos.
  - Entre bloques de lógica dentro de un método.
- No debe haber líneas en blanco al principio o al final de un archivo.

### 5.4. Llaves
- Las llaves deben colocarse en la misma línea del encabezado.
- **Ejemplo:**
```java
if (condition) {
    // Action
}
```

## 6. Manejo de Excepciones

1. Solo deben capturarse excepciones que puedan manejarse adecuadamente.
2. No deben capturarse excepciones genéricas como `Exception` o `Throwable`.
3. Si es necesario, deben definirse excepciones personalizadas para manejar errores específicos.

---

## 7. Pruebas

1. Los métodos de prueba deben nombrarse de forma descriptiva:
   - `should[ExpectedOutcome]_When[Condition]`
   - **Ejemplo:**
```java
@Test
public void shouldCalculateProfit_whenValuesAreValid {
    // Arrange
    // Act
    // Assert
}
```
2. Cada funcionalidad clave debe tener pruebas unitarias.
