package ar.com.spiderdesktop;

import ar.com.spiderdesktop.world.Fly;
import ar.com.spiderdesktop.debug.DebugPanel;
import ar.com.spiderdesktop.home.SpiderHome;
import ar.com.spiderdesktop.ia.CerebroSpider;
import ar.com.spiderdesktop.spider.Spider;
import ar.com.spiderdesktop.world.World;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {

	@Override
	public void start(Stage ventana) {

		// Posición inicial de la araña
		double x = 550;
		double y = 550;

		// Panel principal
		Pane raiz = new Pane();
		// Hacemos el fondo del root transparente (la escena y el stage también serán transparentes)
		raiz.setStyle("-fx-background-color: transparent;");

		// Casa de la araña
		SpiderHome casa = new SpiderHome(730, 40);

		World mundo = new World();

		Fly mosca = mundo.crearMoscaAleatoria();

		// Araña
		Spider arania = new Spider(x, y, casa);

		// Cerebro
		CerebroSpider cerebro = new CerebroSpider(arania, mundo);

		// Agregamos la araña a la escena
		raiz.getChildren().add(casa.getVista());

		raiz.getChildren().add(arania.getVista());

		raiz.getChildren().add(mosca.getVista());
		// Escena
		Scene escena = new Scene(raiz, 800, 600);
		// Hacemos la escena transparente
		escena.setFill(Color.TRANSPARENT);

		DebugPanel debug = new DebugPanel();

		raiz.getChildren().add(debug.getVista());

		// El mouse indica el objetivo
		escena.setOnMouseMoved(evento -> {
			arania.moverHacia(evento.getX(), evento.getY());
		});

		// Bucle principal del juego
		Timeline reloj = new Timeline(

				new KeyFrame(Duration.millis(16), evento -> {

					mundo.actualizar();

					cerebro.actualizar();

					debug.actualizar(arania.getEstado().toString(), mosca.estaViva(), cerebro.getTiempoReaparicion());
				
				})

		);

		reloj.setCycleCount(Timeline.INDEFINITE);
		reloj.play();

		ventana.setTitle("Spider Desktop");
		// Quitamos las decoraciones y hacemos transparente el stage
		ventana.initStyle(StageStyle.TRANSPARENT);
		ventana.setScene(escena);
		// Ocupamos la pantalla (maximizado). Si preferís pantalla completa, reemplazar por setFullScreen(true).
		ventana.setMaximized(true);
		ventana.show();
	}

	public static void main(String[] args) {

		launch(args);

	}

}
