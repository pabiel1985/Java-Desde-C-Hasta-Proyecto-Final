package ar.com.spiderdesktop.ia;

import java.util.Random;

import ar.com.spiderdesktop.spider.Spider;
import ar.com.spiderdesktop.world.Fly;
import ar.com.spiderdesktop.world.World;

public class CerebroSpider {

	private long ultimaMosca = 0;

	private static final int TIEMPO_REAPARICION = 10000;

	// ===============================
	// Constantes del mundo
	// ===============================

	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private static final int MARGEN = 20;

	private static final int TIEMPO_DESCANSO = 3000;
	private static final int TIEMPO_OBSERVACION = 1000;

	private static final double RADIO_VISION = 250;

	// ===============================
	// Objetos
	// ===============================

	private final Spider spider;
	private final World mundo;
	private final Random random = new Random();

	// ===============================
	// Temporizadores
	// ===============================

	private long inicioDescanso = 0;
	private long inicioObservacion = 0;

	// ===============================
	// Constructor
	// ===============================

	public CerebroSpider(Spider spider, World mundo) {

		this.spider = spider;
		this.mundo = mundo;

	}

	// ===============================
	// Actualización principal
	// ===============================

	public void actualizar() {

		// Primero se mueve el cuerpo
		spider.actualizar();

		reaparecerMoscas();

		// Después piensa
		switch (spider.getEstado()) {

		case CAMINANDO:
			actualizarCaminar();
			break;

		case PERSIGUIENDO:
			actualizarPersiguiendo();
			break;

		case OBSERVANDO:
			actualizarObservacion();
			break;

		case DESCANSANDO:
			actualizarDescanso();
			break;

		}

	}

	// ===============================
	// CAMINANDO
	// ===============================

	private void actualizarCaminar() {

		if (spider.llegoAlObjetivo()) {

			spider.observar();
			inicioObservacion = System.currentTimeMillis();

		}

	}

	// ===============================
	// PERSIGUIENDO
	// ===============================

	private void actualizarPersiguiendo() {

		Fly mosca = buscarMoscaMasCercana();

		if (mosca == null) {

			spider.descansar();
			inicioDescanso = System.currentTimeMillis();
			return;

		}

		// La mosca se mueve, por eso actualizamos
		// el objetivo continuamente.
		spider.moverHacia(mosca.getX(), mosca.getY());

		if (spider.llegoAlObjetivo()) {

		    mosca.morir();

		    ultimaMosca = System.currentTimeMillis();

		    spider.observar();

		    inicioObservacion = System.currentTimeMillis();

		}

	}

	// ===============================
	// OBSERVANDO
	// ===============================

	private void actualizarObservacion() {

		long ahora = System.currentTimeMillis();

		if (ahora - inicioObservacion >= TIEMPO_OBSERVACION) {

			spider.descansar();
			inicioDescanso = System.currentTimeMillis();

		}

	}

	// ===============================
	// DESCANSANDO
	// ===============================

	private void actualizarDescanso() {

		Fly mosca = buscarMoscaMasCercana();

		if (mosca != null) {

			spider.moverHacia(mosca.getX(), mosca.getY());
			spider.perseguir();

			return;

		}

		long ahora = System.currentTimeMillis();

		if (ahora - inicioDescanso >= TIEMPO_DESCANSO) {

			elegirDestinoBorde();

		}

	}

	// ===============================
	// Elegir destino
	// ===============================

	private void elegirDestinoBorde() {

		int lado = random.nextInt(4);

		double x = 0;
		double y = 0;

		switch (lado) {

		case 0: // Arriba
			x = random.nextInt(ANCHO - (MARGEN * 2)) + MARGEN;
			y = MARGEN;
			break;

		case 1: // Derecha
			x = ANCHO - MARGEN;
			y = random.nextInt(ALTO - (MARGEN * 2)) + MARGEN;
			break;

		case 2: // Abajo
			x = random.nextInt(ANCHO - (MARGEN * 2)) + MARGEN;
			y = ALTO - MARGEN;
			break;

		case 3: // Izquierda
			x = MARGEN;
			y = random.nextInt(ALTO - (MARGEN * 2)) + MARGEN;
			break;

		}

		spider.moverHacia(x, y);
		spider.caminar();

	}

	// ===============================
	// Buscar la mosca más cercana
	// ===============================

	private Fly buscarMoscaMasCercana() {

		Fly mejor = null;
		double menorDistancia = Double.MAX_VALUE;

		double spiderX = spider.getVista().getLayoutX();
		double spiderY = spider.getVista().getLayoutY();

		for (Fly mosca : mundo.getMoscas()) {

			if (!mosca.estaViva()) {
				continue;
			}

			double dx = mosca.getX() - spiderX;
			double dy = mosca.getY() - spiderY;

			double distancia = Math.sqrt(dx * dx + dy * dy);

			// Solo ve las moscas cercanas
			if (distancia <= RADIO_VISION && distancia < menorDistancia) {

				menorDistancia = distancia;
				mejor = mosca;

			}

		}

		return mejor;

	}

	private void reaparecerMoscas() {

		long ahora = System.currentTimeMillis();

		boolean hayMoscaViva = false;

		for (Fly mosca : mundo.getMoscas()) {

			if (mosca.estaViva()) {

				hayMoscaViva = true;
				break;

			}

		}

		if (!hayMoscaViva && ahora - ultimaMosca >= TIEMPO_REAPARICION) {

			mundo.revivirMosca();

			ultimaMosca = ahora;

		}

	}

	public double getTiempoReaparicion() {

		long restante = TIEMPO_REAPARICION - (System.currentTimeMillis() - ultimaMosca);

		if (restante < 0) {
			restante = 0;
		}

		return restante / 1000.0;

	}

}