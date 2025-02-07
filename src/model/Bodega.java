package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Bodega {
    private HashMap<String, Producto> productos;

    public Bodega() {
        productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public void modificarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public void eliminarProducto(String id) {
        productos.remove(id);
    }

    public List<Producto> listarProductosOrdenadosPorNombre() {
        List<Producto> lista = new ArrayList<>(productos.values());
        Collections.sort(lista, Comparator.comparing(Producto::getNombre));
        return lista;
    }

    public List<Producto> listarProductosOrdenadosPorPrecio() {
        List<Producto> lista = new ArrayList<>(productos.values());
        Collections.sort(lista, Comparator.comparingDouble(Producto::getPrecio));
        return lista;
    }
}