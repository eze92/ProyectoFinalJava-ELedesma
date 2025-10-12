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
          6 - nueva funcion
          """);
      opcionUsuario = entrada.nextInt();

      switch (opcionUsuario) {
        case 1 -> crearProducto(productosDB); // - >
        case 2 -> listarProductos(productosDB);
        case 3 -> buscarProductoPorNombre(productosDB);
        case 4 -> editarProducto(productosDB);
        case 5 -> borrarProducto(productosDB);
        /*case 6 -> System.out.println("Funcionalida en progreso...");*/
        case 0 -> {
          System.out.println("Gracias por usar la app!");
          break label; // corta el bucle donde se ejecuta
        }
        default -> System.out.println("Opción incorrecta, intente de nuevo");
      }
    }
  }

  public static void crearProducto(ArrayList<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Creando Nuevo Producto");
    System.out.print("Ingrese el nombre del nuevo producto: ");
    String nombre = entrada.nextLine();

    System.out.print("Ingrese el precio del producto: ");
    double precio = entrada.nextDouble();

    System.out.print("Ingrese la cantidad de stock del producto: ");
    int stock = entrada.nextInt();

    Producto nuevoProducto = new Producto(nombre,precio,stock );
    productos.add(nuevoProducto);

    System.out.println("✅ Producto creado correctamente.");

    pausa();
  }

  public static void listarProductos(ArrayList<Producto> productos) {
    System.out.println("=======================================");
    System.out.println("        LISTA DE PRODUCTOS");
    System.out.println("=======================================");

    if (productos == null || productos.isEmpty()) {
      System.out.println("⚠️  No hay productos para mostrar.");
    } else {
      int contador = 1;
      for (Producto producto : productos) {
        System.out.printf(" %2d. %s%n", contador++, producto.getNombre());
      }
    }
    System.out.println("=======================================");
    pausa();
  }

  public static void buscarProductoPorNombre(ArrayList<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese un nombre de un producto: ");
    String busqueda = entrada.nextLine();
    ArrayList<Producto> productoEncontrados = new ArrayList<>();

    for (Producto producto : productos) {
      if (estaIncluido(producto, busqueda)) {
        productoEncontrados.add(producto);
      }
    }
    listarProductos(productoEncontrados);
  }

  public static void editarProducto(ArrayList<Producto> productos) {
      Scanner entrada = new Scanner(System.in);
      System.out.print("Ingrese el nombre o parte del nombre del producto a editar: ");
      int idProducto = obtenerIdProducto(productos);

      Producto productoAEditar = null;
      for (Producto producto : productos) {
        if (producto.getId() == idProducto) {
          productoAEditar = producto;
          break;
        }
      }

      if (productoAEditar == null) {
        System.out.println("❌ Producto no encontrado.");
        return;
      }

      System.out.println("Producto a editar: " + productoAEditar.getNombre());
      System.out.print("Ingrese el nuevo nombre: ");
      String nuevoNombre = entrada.nextLine();

      productoAEditar.setNombre(nuevoNombre);

      System.out.printf("El nombre del producto cambió de %s a %s%n", productoAEditar.getNombre(), nuevoNombre);
    }

  public static void borrarProducto(ArrayList<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.print("Ingrese el nombre o parte del nombre del producto a eliminar: ");
    int idProducto = obtenerIdProducto(productos);

    Producto productoAEliminar = null;
    for (Producto producto : productos) {
      if (producto.getId() == idProducto) {
        productoAEliminar = producto;
        break;
      }
    }
    if (productoAEliminar == null) {
      System.out.println("❌ Producto no encontrado.");
      return;
    }

    System.out.println("Producto a eliminar: " + productoAEliminar.getNombre());
    productos.remove(productoAEliminar);

    System.out.printf("El producto %s se borro", productoAEliminar.getNombre());
    System.out.println();
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

  public static void pausa() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Pulse ENTER para continuar...");
    entrada.nextLine();
    for (int i = 0; i < 20; ++i) {
      System.out.println();
    }
    // TODO: limpiar la pantalla de la consola
  }

  public static boolean estaIncluido(Producto producto, String nombreParcial) {
    String nombreCompletoFormateado = formatoBusqueda(producto.getNombre());
    return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
  }
  public static String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
  }

  /* Busqueda por id */
  public static int obtenerIdProducto(List<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    int idProducto = -1; // el -1 representa que no encontramos el producto
    String busqueda = entrada.nextLine();

    for (Producto producto : productos) {
      if (estaIncluido(producto, busqueda)) {
        return producto.getId();
      }
    }

    return idProducto;
  }
}
