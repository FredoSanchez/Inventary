/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private String tipo;
    private int cantidad;
    private float precio;
    private boolean disponibilidad;
    
    public Producto(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Producto(int id, String codigo, String nombre, String tipo, int cantidad, float precio, boolean disponibilidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }
    
    
    
    public Producto(int id, String codigo, String nombre, int cantidad, float precio, boolean disponibilidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }
    
    
    public Producto(int id, String codigo, String marca, int stock, boolean disponibilidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = marca;
        this.cantidad = stock;
        this.disponibilidad = disponibilidad;
    }

    
    

    public Producto(String codigo, String marca, int stock, boolean disponibilidad) {
        this.codigo = codigo;
        this.nombre = marca;
        this.cantidad = stock;
        this.disponibilidad = disponibilidad;
    }

    public Producto(String marca, int stock, boolean disponibilidad) {
        this.nombre = marca;
        this.cantidad = stock;
        this.disponibilidad = disponibilidad;
    }
    
    
}
