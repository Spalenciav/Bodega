package model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class Firebase {
    private DatabaseReference databaseReference;

    public FirebaseService() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("productos");
    }

    public void guardarProducto(Producto producto) {
        databaseReference.child(producto.getId()).setValue(producto);
    }

    public void cargarProductos(Bodega bodega) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Producto producto = snapshot.getValue(Producto.class);
                    if (producto != null) {
                        bodega.agregarProducto(producto);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Error al cargar productos: " + databaseError.getMessage());
            }
        });
    }

    public void eliminarProducto(String id) {
        databaseReference.child(id).removeValue();
    }
}