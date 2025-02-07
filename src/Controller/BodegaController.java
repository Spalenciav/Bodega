package controller;

import model.Bodega;
import model.FirebaseService;
import model.Producto;
import view.BodegaView;

import java.util.List;

public class BodegaController {
    private Bodega bodega;
    private BodegaView view;
    private FirebaseService firebaseService;

    public BodegaController(Bodega bodega, BodegaView view) {
        this.bodega = bodega;
        this.view = view;
        this.firebaseService = new FirebaseService();
        cargarProductos();
    }

    private void cargarProductos() {
        firebaseService.cargarProductos(bodega);
        actualizarVista();
    }

    public void agregarProducto(Producto producto) {
        bodega.agregarProducto(producto);
        firebaseService.guardarProducto(producto);
        actualizarVista();
    }

    public void eliminarProducto(String id) {
        bodega.eliminarProducto(id);
        firebaseService.eliminarProducto(id);
        actualizarVista();
    }

    public void actualizarVista() {
        List<Producto> productos = bodega.listarProductosOrdenadosPorNombre();
        view.mostrarProductos(productos);
    }
}