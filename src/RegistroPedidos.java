import java.util.Date;
import java.util.Scanner;

public class RegistroPedidos {
    private Controlador controlador;
    private Pedidos pedidos;
    private Scanner scan;

    public RegistroPedidos(Controlador controlador) {
        this.controlador = controlador;
        this.pedidos = new Pedidos();
        this.scan = new Scanner(System.in);
    }

    public void menuRegistro() {
        int opcion;

        do {
            System.out.println("\n--- REGISTRO DE PEDIDOS ---");
            System.out.println("[1] Mostrar menú");
            System.out.println("[2] Agregar platillo al pedido");
            System.out.println("[3] Modificar cantidad de un platillo");
            System.out.println("[4] Eliminar un platillo del pedido");
            System.out.println("[5] Mostrar pedido actual");
            System.out.println("[6] Confirmar pedido");
            System.out.println("[0] Volver al menú principal");
            System.out.print("Opción: ");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    controlador.mostrarMenu();
                    break;
                case 2:
                    AgregarPlatilloPedido();
                    break;
                case 3:
                    modificarCantidad();
                    break;
                case 4:
                    eliminarPlatillo();
                    break;
                case 5:
                    pedidos.mostrarPedido();
                    break;
                case 6:
                    confirmarPedido();
                    break;
                case 0:
                    System.out.println("Regresando al menú principal");
                    controlador.mostrarMenu();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void AgregarPlatilloPedido() {
        if(controlador.menu.isEmpty()) {
            System.out.println("No hay platillos en el menú");
            return;
        }

        System.out.println("Escriba el nombre del platillo (o 'fin' para terminar): ");
        String nombre = scan.next();
        if(nombre.equalsIgnoreCase("fin")) return;

        Platillo encontrado = null;
        for(Platillo platillo : controlador.menu) {
            if(platillo.getNombre().equals(nombre)) {
                encontrado = platillo;
                break;
            }
        }

        if(encontrado == null){
            System.out.println("Platillo no encontrado");
            return;
        }

        System.out.println("Cantidad: ");
        int cantidad = scan.nextInt();
        scan.nextLine();

        pedidos.agregarItem(new DetallePedido(encontrado,cantidad));
        System.out.println("Platillo agregado al pedido");
    }

    private void modificarCantidad() {
        pedidos.mostrarPedido();
        System.out.println("Selecciona el número del platillo para modificar cantidad: ");
        int index = scan.nextInt() -1;
        scan.nextLine();
        if(index < 0 || index >= pedidos.getItems().size()){
            System.out.println("Número inválido.");
            return;
        }
        System.out.println("Nueva cantidad: ");
        int nuevaCant = scan.nextInt();
        scan.nextLine();
        pedidos.getItems().get(index).setCantidad(nuevaCant);
        System.out.println("Cantidad actualizada.");
    }

    private void eliminarPlatillo() {
        pedidos.mostrarPedido();
        System.out.println("Selecciona el número del platillo a eliminar: ");
        int index = scan.nextInt() -1;
        scan.nextLine();

        if(index < 0 || index >= pedidos.getItems().size()){
            System.out.println("Número inválido.");
            return;
        }
        pedidos.eliminarItem(index);
        System.out.println("Platillo eliminado del pedido.");
    }

    private void confirmarPedido() {
        if(pedidos.getItems().isEmpty()) {
            System.out.println("El pedido está vacío.");
            return;
        }
        pedidos.setFechaHora(new Date());
        System.out.println("Pedido confirmado: ");
        pedidos.mostrarPedido();
        pedidos = new Pedidos();
    }
}