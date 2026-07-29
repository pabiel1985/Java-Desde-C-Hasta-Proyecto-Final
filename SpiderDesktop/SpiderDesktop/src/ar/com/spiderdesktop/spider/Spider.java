package ar.com.spiderdesktop.spider;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spider {

	private Image imagen;
	private ImageView vista;

	private double x;
	private double y;

	private double objetivoX;
	private double objetivoY;

	// Movimiento
	private double velocidadActual = 0;
	private double velocidadMaxima = 5;
	private double aceleracion = 0.20;
	private EstadoSpider estado = EstadoSpider.DESCANSANDO;
	private double oscilacion = 0;

	public Spider(double x, double y) {

		imagen = new Image(getClass().getResourceAsStream("/images/spider.png"));
		vista = new ImageView(imagen);

		vista.setFitWidth(200);
		vista.setPreserveRatio(true);

		moverA(x, y);

		objetivoX = x;
		objetivoY = y;
	}

	public ImageView getVista() {
		return vista;
	}

	public void moverA(double x, double y) {

		this.x = x;
		this.y = y;

		vista.setLayoutX(this.x);
		vista.setLayoutY(this.y);
	}

	public void moverHacia(double x, double y) {

		objetivoX = x;
		objetivoY = y;

		estado = EstadoSpider.CAMINANDO;

	}

	public void actualizar() {

		switch (estado) {

		case DESCANSANDO:
			break;

		case CAMINANDO:
			caminar();
			break;
		}

	}

	private void caminar() {

		double dx = objetivoX - x;
		double dy = objetivoY - y;

		double distancia = Math.sqrt(dx * dx + dy * dy);

		if (distancia <= velocidadActual) {

		    moverA(objetivoX, objetivoY);

		    velocidadActual = 0;

		    oscilacion = 0;

		    return;
		}

		if (velocidadActual < velocidadMaxima) {

			velocidadActual += aceleracion;

			if (velocidadActual > velocidadMaxima) {
				velocidadActual = velocidadMaxima;
			}
		}

		double direccionX = dx / distancia;
		double direccionY = dy / distancia;

		x += direccionX * velocidadActual;
		y += direccionY * velocidadActual;

		double angulo = Math.toDegrees(Math.atan2(dy, dx));

		oscilacion += 0.30;

		double balanceo = Math.sin(oscilacion) * 4;

		vista.setRotate(angulo - 90 + balanceo);
		moverA(x, y);
	}

	public boolean llegoAlObjetivo() {

		return x == objetivoX && y == objetivoY;

	}

	public EstadoSpider getEstado() {
		return estado;
	}

	public void setEstado(EstadoSpider estado) {
		this.estado = estado;
	}

}