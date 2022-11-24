package com.example.flappybird;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplikacija extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getRoot().requestFocus();
        stage.setTitle("Flappy Bird!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}