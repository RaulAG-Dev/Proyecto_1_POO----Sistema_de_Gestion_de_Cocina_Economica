import java.util.Scanner;
public class Platillo {

    private String nombre;
    private float precio;
    public String descripcion;


    public Platillo(){
    }//defecto

    public Platillo(String nombre, int precio, String descripcion){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }//constructor


    //setters
    public void setNombre(Scanner scan){
        System.out.println("Nombre del platillo: ");
        nombre = scan.nextLine();
    }//fin metodo nombre

    public void setPrecio(Scanner scan){
        boolean validar = false;

        do {
            System.out.println("Precio: ");
            String prEntrada = scan.nextLine();
            try {
                float pr = Float.parseFloat(prEntrada);
                if (pr >= 0) {
                    precio = pr;
                    validar = true;
                } else {
                    System.out.println("El precio debe ser igual o mayor a 0");
                }
            }catch (NumberFormatException e){
                System.out.println("Ingrese solo numeros");
            }
        }while (!validar) ;
    }//Fin precio

    public void setDescrip(Scanner scan){
        System.out.println("Descripción del platillo: ");
        descripcion = scan.nextLine();
    }//fin descripcion



    //getters
    public String getNombre(){
        return nombre;
    }

    public float getPrecio(){
        return precio;
    }

    public String getDescripcion(){
        return descripcion;
    }



    @Override
    public String toString(){
        return "Nombre:" + nombre + "\nPrecio: $" + precio + "\nDescripción del platillo: " + descripcion;
    }


}//fin de clase menu