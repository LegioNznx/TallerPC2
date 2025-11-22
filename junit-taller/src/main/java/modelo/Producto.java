package modelo;

import java.util.Objects;

public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;
    private String sku;
    private String categoria;
    private boolean esActivo;
    private boolean descuentoAplicable;


    public Producto(String nombre, double precio, int cantidad,
                    String sku, String categoria,
                    boolean esActivo, boolean descuentoAplicable) {
        this.nombre = nombre;
        setPrecio(precio);       
        setCantidad(cantidad);   
        this.sku = sku;
        this.categoria = categoria;
        this.esActivo = esActivo;
        this.descuentoAplicable = descuentoAplicable;
    }


    public Producto(String nombre, double precio, int cantidad) {
        this(nombre, precio, cantidad, null, null, true, false);
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

   
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

   
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public boolean isDescuentoAplicable() {
        return descuentoAplicable;
    }

    public void setDescuentoAplicable(boolean descuentoAplicable) {
        this.descuentoAplicable = descuentoAplicable;
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(sku, producto.sku); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", sku='" + sku + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", esActivo=" + esActivo +
                ", descuentoAplicable=" + descuentoAplicable +
                '}';
    }
}
