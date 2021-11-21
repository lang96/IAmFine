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

public class TherapistScheduleMeetingController {

    @FXML
    private Button backBtn, acceptBtn;

    @FXML
    public void toTheraMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistMeeting.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void acceptBtn() throws IOException {

        Alert confirmDialogue = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialogue.setTitle("Meeting Schedule");
        confirmDialogue.setHeaderText("The meeting request has been accepted!");
        confirmDialogue.showAndWait();

        Parent root = FXMLLoader.load(getClass().getResource("therapistMeeting.fxml"));
        Stage window = (Stage) acceptBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }
}
