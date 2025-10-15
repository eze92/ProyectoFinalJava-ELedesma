package com.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorDeProductos {

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
      for (Producto producto : productos) {
        System.out.printf(" %2d. %s%n", producto.getId(), producto.getNombre());
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
  /*utilidades*/
  public static void pausa() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Pulse ENTER para continuar...");
    entrada.nextLine();
    for (int i = 0; i < 20; ++i) {
      System.out.println();
    }
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
