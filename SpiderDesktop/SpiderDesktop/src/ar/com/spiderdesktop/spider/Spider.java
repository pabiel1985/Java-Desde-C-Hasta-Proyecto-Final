package ar.com.spiderdesktop.spider;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spider {

	private Image imagen;
	private ImageView vista;

	private double x;
	private double y;
	private double velocidadX = 5;
	private double objetivoX;
	private double objetivoY;

	public Spider(double x, double y) {

		imagen = new Image(getClass().getResourceAsStream("/images/spider.png"));
		vista = new ImageView(imagen);

		vista.setFitWidth(100);
		vista.setPreserveRatio(true);

		moverA(x, y);

		objetivoX = x;
		objetivoY = y;
	}

	public ImageView getVista() {
		return vista;
	}

	public double getVelocidadX() {
		return velocidadX;
	}

	public void setVelocidadX(double velocidadX) {
		this.velocidadX = velocidadX;
	}

	public void moverA(double x, double y) {

		this.x = x;
		this.y = y;

		vista.setLayoutX(this.x);
		vista.setLayoutY(this.y);
	}

	public void actualizar() {

		if (x < objetivoX) {
			x += 5;
		}

		if (x > objetivoX) {
			x -= 5;
		}

		if (y < objetivoY) {
			y += 5;
		}

		if (y > objetivoY) {
			y -= 5;
		}

		moverA(x, y);
	}

	public void moverHacia(double x, double y) {

		objetivoX = x;
		objetivoY = y;

	}

}