import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    ArrayList<Producto> productosDB = obtenerProductosTecnologicos();
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
          """);
      opcionUsuario = entrada.nextInt();

      /*switch (opcionUsuario) {
        case 1 -> crearProducto(productosDB); // - >
        case 2 -> listarProductos(productosDB);
        case 3 -> buscarProductoPorNombre(productosDB);
        case 0 -> {
          System.out.println("Gracias por usar la app!");
          break label; // corta el bucle donde se ejecuta
        }
        default -> System.out.println("Opción incorrecta, intente de nuevo");
      }*/
    }
  }
  public static void crearProducto(ArrayList<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Creando Nuevo Producto");
    System.out.print("Nombre: ");
    String nombre = entrada.nextLine();
    System.out.print("Precio: ");
    double precio = entrada.nextDouble();
    System.out.print("Stock: ");
    int stock = entrada.nextInt();
    int nuevoId = productos.size() + 1;

    productos.add(new Producto(nombre, nuevoId, precio, stock));
    System.out.println("✅ Producto creado exitosamente.");
    pausa();

  }

  public static void listarProductos(ArrayList<Producto> productos) {
    System.out.println("=======================================");
    System.out.println("        LISTA DE PRODUCTOS");
    System.out.println("=======================================");

    if (productos == null || productos.isEmpty()) {
      System.out.println("⚠️  No hay productos para mostrar.");
    } else {
      for (Producto producto : productos) {
        System.out.println(producto.getId() + " - " + producto.getNombre());
      }
    }
    System.out.println("=======================================");
    pausa();
  }
  public static void buscarProductoPorNombre(ArrayList<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese un nombre de un producto: ");
    String busqueda = entrada.nextLine();
    boolean encontrado = false;
    ArrayList<Producto> productoEncontrados = new ArrayList<>();

    for (Producto producto : productos) {
      if (estaIncluido(producto.getNombre(), busqueda)) {
        productoEncontrados.add(producto);
        encontrado = true;
      }else
        System.out.println("❌ No se encontraron productos con ese nombre.");
      }
    }
    listarProductos(productoEncontrados);
  }

  public static void borrarProducto(List<String> productos) {
    Scanner entrada = new Scanner(System.in);
    int indiceProducto = obtenerIdProducto(productos);
    // TODO: validar que encontramos el indice
    String nombreOriginal = productos.get(indiceProducto);
    System.out.println("Producto a eliminar:");
    System.out.println(nombreOriginal);
    // TODO: validar que el usuario quiere borrar el producto que se encontro

    productos.remove(indiceProducto);

    System.out.printf("El producto %s se borro", nombreOriginal);
  }
  public static ArrayList<Producto> obtenerProductosTecnologicos() {
    ArrayList<Producto> productos = new ArrayList<>();

    productos.add("Laptop Lenovo ThinkPad X1 Carbon");
    productos.add("Mouse inalámbrico Logitech MX Master 3");
    productos.add("Teclado mecánico Razer BlackWidow V4");
    productos.add("Monitor LG UltraWide 34 pulgadas");
    productos.add("Smartphone Samsung Galaxy S23 Ultra");
    productos.add("Tablet Apple iPad Pro 12.9\"");
    productos.add("Disco duro externo Seagate 2TB");
    productos.add("Memoria RAM Corsair Vengeance 16GB");
    productos.add("Cargador inalámbrico Belkin Boost Up");
    productos.add("Auriculares Bluetooth Sony WH-1000XM5");

    return productos;
  }

  /* UTILIDADES */
  public static void pausa() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Pulse ENTER para continuar...");
    entrada.nextLine();
    //la manda 20 saltos de lineas para "limpiar la pantalla"
    for (int i = 0; i < 20; ++i) {
      System.out.println();
    }
    // TODO: limpiar la pantalla de la consola
  }
  public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
    String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);

    return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
  }
  public static String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
  }
  public static int obtenerIdProducto(List<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    int idProducto = -1; // el -1 representa que no encontramos el producto
    String busqueda = entrada.nextLine();

    for (Producto producto : productos) {
      if (estaIncluido(producto, busqueda)) {
        return productos.indexOf(producto);
      }
    }

    return idProducto;
  }


}
