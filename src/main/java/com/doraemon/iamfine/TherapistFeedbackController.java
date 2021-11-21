package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TherapistFeedbackController {

    @FXML
    private Button backToTherHome;

    @FXML
    public void showComment() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Meeting Feedback");
        alert.setHeaderText("Rosa Shazler");
        alert.setContentText("Therapist was great.");

        alert.showAndWait();

    }

    @FXML
    public void backToHomepage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistHomepage.fxml"));
        Stage window = (Stage) backToTherHome.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

}
