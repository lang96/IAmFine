package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.ArrayList;

import java.io.IOException;

public class LandingPageController {

    @FXML
    private Button registerBtn, signInBtn, filterBtn;

    @FXML
    public void toRegister() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userRegister.fxml"));
        Stage window = (Stage) registerBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));
    }

    @FXML
    public void toLogin() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage window = (Stage) signInBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));
    }

    @FXML
    public void showConfirmation() throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("Please select your user type");

        ButtonType user = new ButtonType("User");
        ButtonType therapist = new ButtonType("Therapist");


        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(user, therapist);

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null) {
        } else if (option.get() == user) {

            Parent root = FXMLLoader.load(getClass().getResource("userRegister.fxml"));
            Stage window = (Stage) signInBtn.getScene().getWindow();
            window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
            window.setScene(new Scene(root,335,602));
            String musicFile = "test.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

        } else if (option.get() == therapist) {
            Parent root = FXMLLoader.load(getClass().getResource("therapistRegister.fxml"));
            Stage window = (Stage) signInBtn.getScene().getWindow();
            window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
            window.setScene(new Scene(root,335,602));
            String musicFile = "test.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();


        }
    }
}
