public class DetallePedido {
    private Platillo platillo;
    private int cantidad;

    public DetallePedido(){
    }

    public DetallePedido(Platillo platillo, int cantidad){
        this.platillo = platillo;
        this.cantidad = cantidad;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public float getSubTotal(){
        return platillo.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return platillo.getNombre() + " x" + cantidad + " $" + getSubTotal();
    }
}
