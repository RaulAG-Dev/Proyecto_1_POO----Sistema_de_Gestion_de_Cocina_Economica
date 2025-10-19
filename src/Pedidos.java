import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pedidos{
    private ArrayList<DetallePedido> items = new ArrayList<>();
    private Date fechaHora;

    public void agregarItem(DetallePedido item) {
        items.add(item);
    }

    public void eliminarItem(int index) {
        if(index >= 0 && index < items.size()) items.remove(index);
    }

    public ArrayList<DetallePedido> getItems() { return items; }

    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }

    public void mostrarPedido() {
        if(items.isEmpty()) {
            System.out.println("El pedido está vacío.");
            return;
        }

        float total = 0;
        System.out.println("\n---- Pedido actual ----");
        for(int i = 0; i < items.size(); i++) {
            DetallePedido item = items.get(i);
            System.out.println("[" + (i+1) + "] " + item);
            total += item.getSubTotal();
        }
        System.out.println("------------------------");
        System.out.println("TOTAL: $" + total);
        if(fechaHora != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Fecha y hora: " + sdf.format(fechaHora));
        }
        System.out.println("------------------------");
    }
}
