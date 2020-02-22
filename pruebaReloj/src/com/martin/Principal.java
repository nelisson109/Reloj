package com.martin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import martin.Accion;
import martin.Reloj;
import martin.Tarea;

import java.util.Date;

public class Principal extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        Reloj reloj = new Reloj();
        Date date = new Date();
        reloj.comenzar();
        reloj.setFormatoHs(true);
        Tarea tarea = new Tarea(21, 03, 40, date, "probando");
        reloj.registrarTarea(tarea);
        reloj.añadirAccion(new Accion() {
            @Override
            public void ejecuta(Tarea tarea) {
                System.out.println(tarea.getTexto());
            }
        });

        vBox.getChildren().add(reloj);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String [] args){
        launch(args);
    }
}
