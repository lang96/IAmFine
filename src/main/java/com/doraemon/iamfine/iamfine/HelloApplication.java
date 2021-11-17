package com.doraemon.iamfine.iamfine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
        primaryStage.setTitle("I Am Fine");
        primaryStage.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        primaryStage.setScene(new Scene(root,335,602));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}