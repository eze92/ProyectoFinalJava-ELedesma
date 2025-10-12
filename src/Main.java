import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    ArrayList<Producto> productosDB = obtenerProductosTecnologicos();
    GestorDeProductos gestor = new GestorDeProductos();

    int opcionUsuario;

    System.out.println("Te damos la bienvenida a la app de compras 🛒");
    label:
    while (true) {
      System.out.println("""
          Ingrese el número equivalente a la opción:
          0 - Finaliza el programa
          1 - Crea un Producto
          2 - Listar Productos
          3 - Búsqueda por nombre
          4 - Editar nombre producto
          5 - Borrar producto
          6 - Crear pedido (en progreso)
          7 - Listar pedidos (en progreso)
          """);
      opcionUsuario = entrada.nextInt();

      switch (opcionUsuario) {
        case 1 -> gestor.crearProducto(productosDB); // - >
        case 2 -> gestor.listarProductos(productosDB);
        case 3 -> gestor.buscarProductoPorNombre(productosDB);
        case 4 -> gestor.editarProducto(productosDB);
        case 5 -> gestor.borrarProducto(productosDB);
        /*case 6 -> System.out.println("Funcionalida en progreso...");*/
        case 0 -> {
          System.out.println("Gracias por usar la app!");
          break label; // corta el bucle donde se ejecuta
        }
        default -> System.out.println("Opción incorrecta, intente de nuevo");
      }
    }
  }
    public static ArrayList<Producto> obtenerProductosTecnologicos() {
    ArrayList<Producto> productos = new ArrayList<>();

    productos.add(new Producto("Laptop Lenovo ThinkPad X1 Carbon", 1000.0, 10));
    productos.add(new Producto("Mouse inalámbrico Logitech MX Master 3", 500.0, 15));
    productos.add(new Producto("Teclado mecánico Razer BlackWidow V4", 300.0, 20));
    productos.add(new Producto("Monitor LG UltraWide 34 pulgadas", 800.0, 8));
    productos.add(new Producto("Smartphone Samsung Galaxy S23 Ultra", 1200.0, 12));
    productos.add(new Producto("Tablet Apple iPad Pro 12.9\"", 1100.0, 7));
    productos.add(new Producto("Disco duro externo Seagate 2TB", 150.0, 25));
    productos.add(new Producto("Memoria RAM Corsair Vengeance 16GB", 90.0, 30));
    productos.add(new Producto("Cargador inalámbrico Belkin Boost Up", 60.0, 18));
    productos.add(new Producto("Auriculares Bluetooth Sony WH-1000XM5", 350.0, 10));
    return productos;
  }


}
