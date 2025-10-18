import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        Controlador controlador = new Controlador();

        System.out.println("----------------- Software cocina econimica -----------------");
        do{
            int opcion;

            System.out.println("----------- Menú de opciones -----------");
            System.out.println("[1] Añadir un platillo");
            System.out.println("[2] Mostrar menú completo");
            System.out.println("[3] Editar un platillo");
            System.out.println("[4] Eliminar un platillo");
            System.out.println("[5] Salir");
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
                    salir = true;
                default:
            }


        }while(!salir);


    }
}
