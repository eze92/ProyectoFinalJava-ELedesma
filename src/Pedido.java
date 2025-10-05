import java.util.ArrayList;

public class Pedido {
  int id;
  ArrayList<Producto> productos;

  public Pedido(int id, ArrayList<Producto> productos) {
    this.id = id;
    this.productos = productos;
  }
  public ArrayList<Producto> getProductos() {
    return productos;
  }
  public double costoTotal(ArrayList<Producto> productos){
    double total = 0;
    for (Producto producto : productos) {
      total += producto.getPrecio();
    }
    return total;
  }
  public int disminutirStock(int idProducto, int cantidad) {
    for (Producto producto : productos) {
      if (producto.getId() == idProducto) {
        int stockActual = producto.getStock();
        if (stockActual >= cantidad) {
          producto.setStock(stockActual - cantidad);
          return 1; // Éxito
        } else {
          return -1; // No hay suficiente stock
        }
      }
    }
    return 0; // Producto no encontrado
  }
}
