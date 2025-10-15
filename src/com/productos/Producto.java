package com.productos;

public class Producto {

  private String nombre;
  private final int id;
  private double precio;
  private int stock;
  private static int contador = 0;


  public Producto ( String nombre  , double precio , int stock ) {
    this.nombre = nombre;
    this.id = ++contador;
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

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
}
