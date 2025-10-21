package root.org.java_system.controller;

import java.util.List;

public class Platillo extends ModelManagement {
    private String descripcion;
    private float precio;
    private boolean disponible;
    private List<Ingrediente> ingredientes;

    public Platillo(){}

    public Platillo(int id, String nombre, String descripcion, float precio, boolean disponible, List<Ingrediente> ingredientes){
        this.id = id;
        this. nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
        this.ingredientes = ingredientes;
    }

    //getters y setters

    public int getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(){
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
