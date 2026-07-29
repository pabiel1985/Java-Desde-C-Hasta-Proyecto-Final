package ar.com.spiderdesktop.home;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

        vista.setFitWidth(140);
        vista.setPreserveRatio(true);

        vista.setLayoutX(x);
        vista.setLayoutY(y);

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