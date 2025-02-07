import model.Bodega;
import view.BodegaView;
import controller.BodegaController;

public class Main {
    public static void main(String[] args) {
        Bodega bodega = new Bodega();
        BodegaView view = new BodegaView();
        BodegaController controller = new BodegaController(bodega, view);
    }
}