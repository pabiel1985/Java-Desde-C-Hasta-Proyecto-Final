package ar.com.spiderdesktop.spider;

import ar.com.spiderdesktop.home.SpiderHome;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spider {

	// ==============================
	// Apariencia
	// ==============================

	private Image imagen;
	private ImageView vista;

	// ==============================
	// Posición
	// ==============================

	private double x;
	private double y;

	// ==============================
	// Destino
	// ==============================

	private double objetivoX;
	private double objetivoY;

	// ==============================
	// Movimiento
	// ==============================

	private double velocidadActual = 0;
	private double velocidadMaxima = 3;
	private double aceleracion = 0.20;

	// ==============================
	// Animación
	// ==============================

	private double oscilacion = 0;

	// ==============================
	// Estado
	// ==============================

	private EstadoSpider estado = EstadoSpider.DESCANSANDO;

	// ==============================
	// Casa
	// ==============================

	private SpiderHome casa;

	// ==============================
	// Constructor
	// ==============================

	public Spider(double x, double y, SpiderHome casa) {

		this.casa = casa;

		imagen = new Image(getClass().getResourceAsStream("/images/spider.png"));
		vista = new ImageView(imagen);

		vista.setFitWidth(100);
		vista.setPreserveRatio(true);

		moverA(x, y);

		objetivoX = x;
		objetivoY = y;
	}

	// ==============================
	// Getters
	// ==============================

	public ImageView getVista() {
		return vista;
	}

	public EstadoSpider getEstado() {
		return estado;
	}

	public SpiderHome getCasa() {
		return casa;
	}

	// ==============================
	// Estados
	// ==============================

	public void caminar() {
		estado = EstadoSpider.CAMINANDO;
	}

	public void descansar() {
		estado = EstadoSpider.DESCANSANDO;
	}

	public void observar() {
		estado = EstadoSpider.OBSERVANDO;
	}

	public void perseguir() {
		estado = EstadoSpider.PERSIGUIENDO;
	}
	// ==============================
	// Movimiento
	// ==============================

	public void moverHacia(double x, double y) {

		objetivoX = x;
		objetivoY = y;

	}

	public void moverA(double x, double y) {

		this.x = x;
		this.y = y;

		vista.setLayoutX(this.x);
		vista.setLayoutY(this.y);

	}

	// ==============================
	// Actualización
	// ==============================

	public void actualizar() {

		switch (estado) {

	    case CAMINANDO:
	        actualizarMovimiento();
	        break;

	    case PERSIGUIENDO:
	        actualizarMovimiento();
	        break;

	    case DESCANSANDO:
	        break;

	    case OBSERVANDO:
	        break;
	}

	}

	// ==============================
	// Movimiento interno
	// ==============================

	private void actualizarMovimiento() {

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

		oscilacion += 0.90;

		double balanceo = Math.sin(oscilacion) * 4;

		vista.setRotate(angulo - 90 + balanceo);

		moverA(x, y);

	}

	// ==============================
	// Consultas
	// ==============================

	public boolean llegoAlObjetivo() {

		double dx = objetivoX - x;
		double dy = objetivoY - y;

		return Math.sqrt(dx * dx + dy * dy) < 1;

	}

	public boolean estaDescansando() {
		return estado == EstadoSpider.DESCANSANDO;
	}

}