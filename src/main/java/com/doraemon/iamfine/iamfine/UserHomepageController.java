package com.doraemon.iamfine.iamfine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserHomepageController {



    @FXML
    private Button backBtn,profileBtn,conditionBtn,preferenceBtn;


    @FXML
    public void toLandingPage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toUserProfile() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        Stage window = (Stage) profileBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toCondition() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("conditionPage.fxml"));
        Stage window = (Stage) conditionBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toPreferences() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("preferencesPage.fxml"));
        Stage window = (Stage) preferenceBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }


}
