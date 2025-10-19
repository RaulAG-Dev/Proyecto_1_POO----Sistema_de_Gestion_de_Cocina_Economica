import java.util.ArrayList;
import java.util.Scanner;

public class ControladorMenu {

    ArrayList<Platillo> menu = new ArrayList<>();
    Scanner scan = new Scanner(System.in);


    public void anadirPlato(){
            Platillo plato = new Platillo();
            plato.setNombre(scan);
            plato.setPrecio(scan);
            plato.setDescrip(scan);
            menu.add(plato);
    }//Fin añadir plato


    public void editarPlato(){
        System.out.println("Buscar por nombre: ");
        String nombreBuscado = scan.nextLine();
        boolean encontrado = false;

        for(Platillo plato : menu){
            if(plato.getNombre().equalsIgnoreCase(nombreBuscado)){
                encontrado = true;
                System.out.println("Elija una opción");
                System.out.println("[1] Editar nombre");
                System.out.println("[2] Editar precio");
                System.out.println("[3] Editar descripción");
                System.out.println("[4] Eliminar platillo");
                int opcion = scan.nextInt();
                scan.nextLine();
                switch (opcion){
                    case 1:
                        plato.setNombre(scan);
                        break;
                    case 2:
                        plato.setPrecio(scan);
                        break;
                    case 3:
                        plato.setDescrip(scan);
                        break;
                    case 4:
                        menu.remove(plato);
                    default:
                }
            }
        }

        if(!encontrado){
            System.out.println("Platillo \"" + nombreBuscado +  "\"no  encontrado");
        }

    }//fin editar plato


    public void eliminarPlato(){
        System.out.println("Buscar por nombre: ");
        String nombreBuscado = scan.nextLine();
        boolean encontrado = false;

        for(int i = 0; i < menu.size(); i++){
            Platillo plato = menu.get(i);
            if(plato.getNombre().equalsIgnoreCase(nombreBuscado)){
                menu.remove(i);
                i--;
            }
        }
    }//fin eliminar

    public void mostrarMenu(){
        for(Platillo plato : menu){
            System.out.println(plato + "\n");
        }
    }

}//Fin controlador

