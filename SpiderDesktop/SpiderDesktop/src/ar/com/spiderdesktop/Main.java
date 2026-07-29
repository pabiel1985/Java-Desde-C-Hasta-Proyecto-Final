package ar.com.spiderdesktop;

import ar.com.spiderdesktop.ia.CerebroSpider;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import ar.com.spiderdesktop.spider.Spider;

public class Main extends Application {

	@Override
	public void start(Stage ventana) {

		double x = 550;
		double y = 550;

		Pane raiz = new Pane();
		raiz.setStyle("-fx-background-color: grey;");

		Spider arania = new Spider(x, y);

		CerebroSpider cerebro = new CerebroSpider(arania);

		raiz.getChildren().add(arania.getVista());

		Scene escena = new Scene(raiz, 800, 600);

		// El mouse indica el objetivo de la araña
		escena.setOnMouseMoved(evento -> {
			arania.moverHacia(evento.getX(), evento.getY());
		});

		Timeline reloj = new Timeline(

				new KeyFrame(Duration.millis(16), evento -> {

					cerebro.actualizar();

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