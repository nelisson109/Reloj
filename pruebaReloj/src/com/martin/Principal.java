package com.martin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import martin.Reloj;

public class Principal extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label hora = new Label();
        VBox vBox = new VBox();
        Reloj reloj = new Reloj();
        reloj.comenzar();
        vBox.getChildren().add(reloj);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
