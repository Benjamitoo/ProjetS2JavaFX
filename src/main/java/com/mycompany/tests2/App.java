package com.mycompany.tests2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.stage.Stage;
import vue.*;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        new AjoutEvenement(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
