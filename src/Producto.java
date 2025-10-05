public class Producto {

  String nombre;
  int id;
  double precio;
  int stock;

  public Producto ( String nombre , int id , double precio , int stock ) {
    this.nombre = nombre;
    this.id = id;
    this.precio = precio;
    this.stock = stock;
  }
/*getters*/
  public String getNombre() {
    return this.nombre;
  }
  public int getId(){
    return this.id;
  }
  public double getPrecio(){
    return this.precio;
  }
  public  int getStock(){
    return this.stock;
  }
  /*setters*/
  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public void setId(int id) {
    this.id = id;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
}
