package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TherapistHomepageController {

    @FXML
    private Button backBtn,profileBtn,meetingBtn;

    @FXML
    public void toLandingPage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toTherapistProfile() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistProfile.fxml"));
        Stage window = (Stage) profileBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toTherapistMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistMeeting.fxml"));
        Stage window = (Stage) profileBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

//    @FXML
//    public void toPreferences() throws IOException {
//
//        Parent root = FXMLLoader.load(getClass().getResource("preferencesPage.fxml"));
//        Stage window = (Stage) preferenceBtn.getScene().getWindow();
//        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
//        window.setScene(new Scene(root,335,602));
//
//    }


}
