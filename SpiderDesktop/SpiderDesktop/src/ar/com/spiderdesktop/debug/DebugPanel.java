package ar.com.spiderdesktop.debug;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DebugPanel {

    private VBox panel = new VBox(4);

    private Label estado = new Label();
    private Label mosca = new Label();
    private Label tiempo = new Label();

    public DebugPanel() {

        panel.setLayoutX(10);
        panel.setLayoutY(10);

        estado.setTextFill(Color.WHITE);
        mosca.setTextFill(Color.WHITE);
        tiempo.setTextFill(Color.WHITE);

        estado.setFont(Font.font("Consolas",16));
        mosca.setFont(Font.font("Consolas",16));
        tiempo.setFont(Font.font("Consolas",16));

        panel.getChildren().addAll(
                estado,
                mosca,
                tiempo
        );

    }

    public VBox getVista() {

        return panel;

    }

    public void actualizar(String estadoSpider,
                           boolean moscaViva,
                           double segundos) {

        estado.setText("Estado : " + estadoSpider);

        mosca.setText("Mosca  : " + (moscaViva ? "VIVA" : "MUERTA"));

        tiempo.setText(String.format("Respawn: %.1f s", segundos));

    }

}