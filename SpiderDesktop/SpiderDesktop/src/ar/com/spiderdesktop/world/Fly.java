package ar.com.spiderdesktop.world;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fly {

    // Imagen
    private Image imagen;
    private ImageView vista;

    // Posición
    private double x;
    private double y;

    // Velocidad
    private double velocidadX;
    private double velocidadY;

    // Mundo
    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    private Random random = new Random();

    public Fly(double x, double y) {

        this.x = x;
        this.y = y;

        imagen = new Image(getClass().getResourceAsStream("/images/fly.png"));

        vista = new ImageView(imagen);

        vista.setFitWidth(40);
        vista.setPreserveRatio(true);

        velocidadX = 2;
        velocidadY = 2;

        actualizarVista();

    }

    public void actualizar() {

        x += velocidadX;
        y += velocidadY;

        if (x <= 0 || x >= ANCHO - 40) {

            velocidadX *= -1;

        }

        if (y <= 0 || y >= ALTO - 40) {

            velocidadY *= -1;

        }

        // 2% de probabilidad de cambiar la dirección
        if (random.nextInt(100) < 2) {

            velocidadX += random.nextDouble() * 2 - 1;
            velocidadY += random.nextDouble() * 2 - 1;

            limitarVelocidad();

        }

        actualizarVista();

    }

    private void limitarVelocidad() {

        if (velocidadX > 3)
            velocidadX = 3;

        if (velocidadX < -3)
            velocidadX = -3;

        if (velocidadY > 3)
            velocidadY = 3;

        if (velocidadY < -3)
            velocidadY = -3;

    }

    private void actualizarVista() {

        vista.setLayoutX(x);
        vista.setLayoutY(y);

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

}