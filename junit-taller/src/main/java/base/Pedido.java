package base;

import modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Producto> detallesPedido = new ArrayList<>();

    public List<Producto> getDetallesPedido() {
        return detallesPedido;
    }

    public boolean agregarProducto(Producto producto, int cantidad) {

        if (producto == null || cantidad <= 0) {
            System.err.println("Error: La cantidad a agregar debe ser positiva y el producto no puede ser nulo.");
            return false;
        }

        if (!producto.isEsActivo()) {
            System.err.println("Error: El producto está inactivo.");
            return false;
        }

        boolean yaExiste = detallesPedido.stream()
                .anyMatch(p -> p.getSku() != null && p.getSku().equals(producto.getSku()));

        if (yaExiste) {
            return false;
        }

        Producto nuevo = new Producto(
                producto.getNombre(),
                producto.getPrecio(),
                cantidad,
                producto.getSku(),
                producto.getCategoria(),
                producto.isEsActivo(),
                producto.isDescuentoAplicable()
        );

        detallesPedido.add(nuevo);
        return true;
    }

    public boolean validarStock() {

        if (detallesPedido == null || detallesPedido.isEmpty()) {
            return true;
        }

        for (Producto p : detallesPedido) {
            if (p.getCantidad() <= 0) {
                return false;
            }
        }

        return true;
    }

    public static double calcularTotalPedido(List<Producto> productos, double descuento) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("Error: no hay productos en el pedido");
        }

        double subtotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();

        if (subtotal <= 0) {
            throw new IllegalArgumentException("Error: monto inválido");
        }

        return subtotal - (subtotal * (descuento / 100));
    }
}
