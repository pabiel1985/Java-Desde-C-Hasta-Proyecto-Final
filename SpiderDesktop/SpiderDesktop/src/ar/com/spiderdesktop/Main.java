package ar.com.spiderdesktop;

import ar.com.spiderdesktop.world.Fly;
import ar.com.spiderdesktop.home.SpiderHome;
import ar.com.spiderdesktop.ia.CerebroSpider;
import ar.com.spiderdesktop.spider.Spider;
import ar.com.spiderdesktop.world.World;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	@Override
	public void start(Stage ventana) {

		// Posición inicial de la araña
		double x = 550;
		double y = 550;

		// Panel principal
		Pane raiz = new Pane();
		raiz.setStyle("-fx-background-color: grey;");

		// Casa de la araña
		SpiderHome casa = new SpiderHome(730, 40);
		
		World mundo = new World();

		Fly mosca = new Fly(400,300);

		mundo.agregarMosca(mosca);

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

		// El mouse indica el objetivo
		escena.setOnMouseMoved(evento -> {
			arania.moverHacia(evento.getX(), evento.getY());
		});

		// Bucle principal del juego
		Timeline reloj = new Timeline(

				new KeyFrame(Duration.millis(16), evento -> {

					cerebro.actualizar();
					mosca.actualizar();

				})

		);

		reloj.setCycleCount(Timeline.INDEFINITE);
		reloj.play();

		ventana.setTitle("Spider Desktop");
		ventana.setScene(escena);
		ventana.show();
	}

	public static void main(String[] args) {

		launch(args);

	}

}