package ar.com.spiderdesktop;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import ar.com.spiderdesktop.spider.Spider;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage ventana) {

		double x = 550;
		double y = 550;

		Pane raiz = new Pane();

		Spider arania = new Spider(x, y);

		Timeline reloj = new Timeline(

				new KeyFrame(Duration.millis(100), evento -> {

					arania.actualizar();
				})

		);

		reloj.setCycleCount(Timeline.INDEFINITE);
		reloj.play();
		
			arania.moverA(200, 100);

		raiz.getChildren().add(arania.getVista());

		Scene escena = new Scene(raiz, 800, 600);
		
		escena.setOnMouseMoved(evento -> {

			arania.moverHacia(evento.getX(), evento.getY());

		});

		ventana.setTitle("Spider Desktop");
		ventana.setScene(escena);
		ventana.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}