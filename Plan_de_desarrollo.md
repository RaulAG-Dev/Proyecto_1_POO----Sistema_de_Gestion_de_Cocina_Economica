# PLAN DE DESARROLLO POR MÓDULOS – SISTEMA COCINA ECONÓMICA

## MÓDULO 1 – LOGIN 
**Objetivo:** Autenticar usuario y abrir la ventana principal.

### 🔹 Orden de implementación:
1. **Modelo**
    * **Usuario**
        * Atributos: `id`, `nombre`, `contraseña`, `rol`
        * Métodos: `validarContraseña(pass: String): boolean` → retorno simple `return this.contraseña.equals(pass);`
    * Hereda de `ModelManagement`.
2. **Persistencia**
    * `RepositorioJSON<Usuario>`
        * Métodos vacíos o simulados.
        * Simular carga de 1 o 2 usuarios por defecto (por ejemplo, “admin” y “empleado”).
3. **Servicio**
    * `ServicioUsuarios`
        * Método `autenticar(nombre, pass)` → busca el usuario en el repositorio y valida contraseña.
        * Método `getUsuarioActual()`.
4. **Controlador**
    * `ControladorLogin`
        * Contiene instancia de `ServicioUsuarios`.
        * Método `autenticar(nombre, pass)` → retorna true/false según resultado.
5. **Vista**
    * `VistaLogin.fxml` (Scene Builder)
        * Campos: `usuario (TextField)`, `contraseña (PasswordField)`, botón “Ingresar”.
    * `VistaLogin.java`
        * Maneja el evento del botón.
        * Si es exitoso, abre `VistaPrincipal.fxml`.
6. **Main**
    * Inicia `VistaLogin`.
      **Resultado:** Se puede iniciar sesión con un usuario simulado y abrir la ventana principal.

---

## MÓDULO 2 – PEDIDOS 
**Objetivo:** Crear pedidos, agregar platillos, calcular total y registrar venta.

### 🔹 Orden de implementación:
1. **Modelo**
    * `Platillo`, `ItemPedido`, `Pedido`
        * Método `calcularSubtotal()` en `ItemPedido`.
        * Método `calcularTotal()` en `Pedido`.
    * Deja `Cliente` vacío por ahora o simulado.
2. **Persistencia**
    * `RepositorioJSON<Pedido>` → simulado, sin escritura real aún.
3. **Servicio**
    * `ServicioVentas`
        * Métodos base: `crearPedido()`, `guardarPedido(pedido)`, `obtenerVentasPorFecha(fecha)`
        * Lógica inicial: almacenar pedidos en una lista temporal (sin JSON aún).
4. **Controlador**
    * `ControladorPrincipal`
        * Métodos: `iniciarNuevoPedido()`, `agregarPlatilloAlPedido(idPlatillo, cantidad)`, `finalizarPedido()`
5. **Vista**
    * `VistaPedidos.fxml`
        * Tabla de items del pedido.
        * Botones: “Agregar platillo”, “Eliminar platillo”, “Finalizar pedido”.
    * `VistaPedidos.java`
        * Llama a los métodos del `ControladorPrincipal`.
          **Resultado:** Se puede crear un pedido, agregar platillos simulados y calcular total (sin guardar aún).

---

## MÓDULO 3 – MENÚ 
**Objetivo:** Gestionar platillos disponibles.

### 🔹 Orden de implementación:
1. **Modelo**
    * `Platillo` (ya hecho).
2. **Persistencia**
    * `RepositorioJSON<Platillo>` → lectura/escritura real en JSON.
3. **Servicio**
    * `ServicioMenu`
        * Métodos: `obtenerPlatillosDisponibles()`, `agregarPlatillo()`, `actualizarPlatillo()`
4. **Controlador**
    * `ControladorMenu`
        * Métodos que llamen a los del servicio.
5. **Vista**
    * `VistaMenu.fxml`
        * Tabla de platillos, campos de edición (`nombre`, `descripción`, `precio`).
        * Botones: “Agregar”, “Actualizar”.
    * `VistaMenu.java`
        * Eventos que usan `ControladorMenu`.
          **Resultado:** Se puede agregar/editar platillos con persistencia JSON.

---

## MÓDULO 4 – INVENTARIO 
**Objetivo:** Mostrar ingredientes y alertas de stock bajo.

### 🔹 Orden de implementación:
1. **Modelo**
    * `Ingrediente`
        * Método `actualizarStock(cantidad)`
2. **Persistencia**
    * `RepositorioJSON<Ingrediente>`
3. **Servicio**
    * `ServicioInventario`
        * Métodos: `obtenerInventario()`, `obtenerAlertasStock()`, `actualizarIngrediente()`
4. **Controlador**
    * `ControladorInventario`
        * Método `mostrarAlertas()` → obtiene del servicio.
5. **Vista**
    * `VistaInventario.fxml`
        * Tabla de ingredientes, campo de cantidad, botón “Actualizar stock”.
          **Resultado:** Se visualizan ingredientes y alertas de stock mínimo.

---

## MÓDULO 5 – REPORTES 
**Objetivo:** Generar reportes de ventas y platillos populares.

### 🔹 Orden de implementación:
1. **Servicio**
    * `ServicioReportes`
        * Métodos: `generarReporteVentas(fechaInicio, fechaFin)`, `generarPlatosPopulares(fechaInicio, fechaFin)`
2. **Controlador**
    * `ControladorReportes`
        * Llama a los métodos del servicio.
3. **Vista**
    * `VistaReportes.fxml`
        * Fecha inicio/fin, botón “Generar”, tabla de resultados.
        * Botón “Exportar” (puede quedar sin implementar por ahora).
          **Resultado:** Se muestran reportes básicos generados desde pedidos.

---

## MÓDULO 6 – CORTE DE CAJA 
**Objetivo:** Calcular diferencia entre monto inicial y final del día.

### 🔹 Orden de implementación:
1. **Modelo**
    * `CorteCaja`
        * Método `calcularDiferencia()`
    * `totalVentas` se obtiene desde `ServicioVentas`.
2. **Servicio**
    * `ServicioCorteCaja`
        * Método `generarCorte(fecha, montoInicial, usuario)`
        * Suma los totales de los pedidos del día.
3. **Controlador**
    * `ControladorCorteCaja`
        * Llama a `generarCorte()` y muestra resultado.
4. **Vista**
    * `VistaCorteCaja.fxml`
        * Campo monto inicial, botón “Generar corte”, etiqueta con diferencia.
          **Resultado:** Se genera el corte de caja diario, calculando ventas totales.

---

## FASE FINAL – INTEGRACIÓN 
1. Conectar todas las vistas con `VistaPrincipal` (botones para cambiar de módulo).
2. Implementar persistencia real en todos los repositorios.
3. Revisar la navegación entre vistas.
4. Agregar detalles visuales y validaciones.