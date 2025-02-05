## Arquitectura General: Modelo-Vista-Controlador (MVC)

### Modelo (Model):
- Contiene las definiciones de las entidades y su representación en la base de datos (e.g., clase `Stock`).
- Interactúa con la base de datos mediante DAOs.

### Vista (View):
- Representa las interfaces de usuario o los datos que serán devueltos al cliente.

### Controlador (Controller):
- Maneja las solicitudes entrantes desde la vista, interactúa con la lógica de negocio (servicios) y devuelve una respuesta.

---

## Capas del Sistema

### Configuración:
- Clase para configurar las herramientas utilizadas, como `HibernateConfig` para la persistencia de datos.

### DAO (Data Access Object):
- Gestiona las operaciones de base de datos (CRUD) con clases como `BaseDAO` y `StockDAO`.

### Modelo (Model):
- Clase `Stock`, que representa la entidad principal del sistema y los datos manejados.

### Servicios (Service):
- Contienen la lógica de negocio, como la validación de datos y la integración con APIs externas. Ejemplo: `StockService`.

### API:
- Componentes que se encargan de comunicarse con servicios externos, como `StockPriceFetcher`.

### Controladores (Controller):
- Exponen los puntos de acceso HTTP para manejar las solicitudes del cliente. Ejemplo: `StockController` y `ExportCSVController`.



##  Arquitectura
![architecture](https://github.com/user-attachments/assets/4f5d7295-99b3-4265-b260-7396469869e4)

