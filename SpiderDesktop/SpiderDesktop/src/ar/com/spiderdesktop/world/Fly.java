package ar.com.spiderdesktop.world;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fly {

    private boolean viva = true;

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

        vista.setFitWidth(30);
        vista.setPreserveRatio(true);

        velocidadX = 1;
        velocidadY = 1;

        actualizarVista();
    }

    public void actualizar() {

        // Si está muerta, no hace nada
        if (!viva) {
            return;
        }

        x += velocidadX;
        y += velocidadY;

        // Mirar hacia donde vuela
        if (velocidadX > 0) {
            vista.setScaleX(-1);
        } else {
            vista.setScaleX(1);
        }

        if (x <= 0 || x >= ANCHO - 40) {
            velocidadX *= -1;
        }

        if (y <= 0 || y >= ALTO - 40) {
            velocidadY *= -1;
        }

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

    public boolean estaViva() {
        return viva;
    }

    public void morir() {

        viva = false;

        vista.setVisible(false);

    }
    
    
    public void revivir(double x, double y) {

        viva = true;

        this.x = x;
        this.y = y;

        vista.setVisible(true);

        actualizarVista();

    }

}