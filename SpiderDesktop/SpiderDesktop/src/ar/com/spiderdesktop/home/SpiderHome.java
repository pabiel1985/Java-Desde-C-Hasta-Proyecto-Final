package ar.com.spiderdesktop.home;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class SpiderHome {

    private double x;
    private double y;

    private Image imagen;
    private ImageView vista;

    public SpiderHome(double x, double y) {

        this.x = x;
        this.y = y;

        imagen = new Image(getClass().getResourceAsStream("/images/web.png"));

        vista = new ImageView(imagen);

        // Escalar la imagen para cubrir la pantalla
        double screenW = Screen.getPrimary().getBounds().getWidth();
        double screenH = Screen.getPrimary().getBounds().getHeight();

        vista.setFitWidth(screenW);
        vista.setFitHeight(screenH);
        vista.setPreserveRatio(false); // cambiar a true si preferís mantener la proporción

        vista.setLayoutX(0);
        vista.setLayoutY(0);

        vista.setOpacity(0.15);

    }

    public ImageView getVista() {
        return vista;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void vibrar() {

        vista.setRotate(vista.getRotate() + 2);

    }
}
