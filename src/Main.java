import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ControladorMenu controlador = new ControladorMenu();
        RegistroPedidos registro = new RegistroPedidos(controlador);
        boolean salir = false;

        System.out.println("----------------- Software cocina economica -----------------");
        do{
            int opcion;

            System.out.println("----------- Menú de opciones -----------");
            System.out.println("[1] Añadir un platillo");
            System.out.println("[2] Mostrar menú completo");
            System.out.println("[3] Editar un platillo");
            System.out.println("[4] Eliminar un platillo");
            System.out.println("[5] Registrar pedido (empleado de caja)");
            System.out.println("[6] Salir");
            System.out.println("Opcion: ");
            opcion = scan.nextInt();
            scan.nextLine();
            switch (opcion){
                case 1:
                    controlador.anadirPlato();
                    break;
                case 2:
                    controlador.mostrarMenu();
                    break;
                case 3:
                    controlador.editarPlato();
                    break;
                case 4:
                    controlador.eliminarPlato();
                    break;
                case 5:
                    registro.menuRegistro();
                    break;
                case 6:
                    salir = true;
                default:
            }
        }while(!salir);


    }
}
