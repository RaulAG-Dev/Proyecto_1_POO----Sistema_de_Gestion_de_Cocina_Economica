# Historias de Usuario
### Gestión de menú
#### HU-01:
Como administrador o encargado de cocina, quiero poder registrar, editar y eliminar platos del menú con su descripción y precio, para mantener actualizada la oferta de comidas disponibles para los clientes.
#### Criterios de aceptación:
- El sistema permite agregar un nuevo plato con nombre, descripción y precio.
- Se puede modificar o eliminar un plato existente.
- El sistema valida que los precios sean numéricos positivos.

### Registro de pedidos
#### HU-02:
Como empleado de caja, quiero registrar los pedidos de los clientes seleccionando los platos y cantidades, para generar automáticamente el total a pagar.
#### Criterios de aceptación:
- El sistema calcula el total del pedido con base en los precios del menú.
- Se pueden agregar o eliminar platos antes de confirmar el pedido.
- El pedido queda registrado con fecha y hora.

### Gestión de ingredientes y stock
#### HU-03:
Como encargado de cocina, quiero registrar los ingredientes disponibles y su cantidad en inventario, para llevar control de los insumos necesarios para preparar los platos.
#### Criterios de aceptación:
- Se puede agregar, editar y eliminar ingredientes.
- El sistema muestra la cantidad actual disponible de cada ingrediente.

#### HU-04:
Como encargado de cocina, quiero recibir alertas cuando el stock de un ingrediente sea bajo, para reabastecer a tiempo y evitar faltantes durante la preparación.
#### Criterios de aceptación:
- El sistema muestra una notificación o alerta visual cuando el stock ≤ nivel mínimo.
- La alerta desaparece cuando se actualiza el inventario.

### Registro de ventas
#### HU-05:
Como empleado de caja, quiero que el sistema registre automáticamente las ventas realizadas, para mantener un historial que pueda ser consultado posteriormente.
#### Criterios de aceptación:
- Cada venta incluye fecha, hora, platos vendidos y total.
- Se puede consultar el historial de ventas por fecha o cliente.

### Gestión de clientes
#### HU-06:
Como empleado o administrador, quiero registrar información de clientes habituales, para ofrecer un servicio más personalizado y guardar su historial de pedidos.
#### Criterios de aceptación:
- Se puede registrar nombre, contacto y preferencias del cliente.
- El sistema permite buscar clientes registrados.

### Gestión de pagos
#### HU-07:
Como empleado de caja, quiero generar recibos de pago después de registrar un pedido, para entregárselos al cliente como comprobante de su compra.
#### Criterios de aceptación:
- El recibo contiene el nombre de la cocina, fecha, platos, precios y total.
- El recibo puede imprimirse o guardarse en formato digital.

### Generación de reportes
#### HU-08:
Como administrador, quiero generar reportes diarios, semanales y mensuales de ventas y ganancias, para analizar el rendimiento económico de la cocina.
#### Criterios de aceptación:
- Los reportes incluyen fecha, cantidad de ventas y ganancia total.
- Se pueden exportar en formato PDF o Excel.

#### HU-09:
Como administrador, quiero obtener un informe de los platos más vendidos, para identificar cuáles son los más populares y ajustar el menú en consecuencia.
#### Criterios de aceptación:
- El sistema ordena los platos por frecuencia de venta.
- El reporte muestra la cantidad vendida y porcentaje de participación.