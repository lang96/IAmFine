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
    public void showComment() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Meeting Feedback");
        alert.setHeaderText("Rosa Shazler");
        alert.setContentText("Therapist was great.");

        alert.showAndWait();

    }

    @FXML
    public void showComment2() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Meeting Feedback");
        alert.setHeaderText("Lee Abe Jib");
        alert.setContentText("Lee is so kind and very patient");

        alert.showAndWait();

    }

}
