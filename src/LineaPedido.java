public class LineaPedido {

  private Producto producto;
  private int cantidad;

  public LineaPedido(Producto producto, int cantidad) {
    this.producto = producto;
    this.cantidad = cantidad;
  }

  public int getCantidad() {
    return this.cantidad;
  }
}
