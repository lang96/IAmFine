package com.doraemon.iamfine;

import java.net.URI;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TherapistMeetingController extends Application {

    @FXML
    private Button backBtn,setBtn,meetBtn;

    @FXML
    public void toTheraHomepage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistHomepage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toTheraScheduleMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistScheduleMeeting.fxml"));
        Stage window = (Stage) setBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toTheraJoinMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistJoinMeeting.fxml"));
        Stage window = (Stage) meetBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
