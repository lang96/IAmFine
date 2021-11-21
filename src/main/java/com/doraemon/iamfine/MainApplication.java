package com.doraemon.iamfine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

import static com.doraemon.iamfine.data.DataOperation.initData;
import static com.doraemon.iamfine.userType.User.UserList;


public class MainApplication extends Application {

    public static String currentUserID; // determine logged in user
    public static String currentUserType; // determine logged in userType

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("I Am Fine");
        primaryStage.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        primaryStage.setScene(new Scene(root,335,602));
        primaryStage.show();

    }

    public static void main(String[] args) throws IOException {
        initData();
        launch();
    }
}