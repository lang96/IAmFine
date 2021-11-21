package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.doraemon.iamfine.MainApplication.currentUserID;
import static com.doraemon.iamfine.userType.Therapist.TherapistList;

public class TherapistHomepageController implements Initializable {

    @FXML
    private Button backBtn,profileBtn,meetingBtn;

    @FXML
    private Label therapistNameLabel;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        for (int i = 0; i < TherapistList.size(); i++) {

            if (TherapistList.get(i).getUsername().equals(currentUserID)) {

                therapistNameLabel.setText(TherapistList.get(i).getFullName());

            }

        }

    }

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
