package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TherapistScheduleMeetingController {

    @FXML
    private Button backBtn;

    @FXML
    public void toTheraMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistMeeting.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    //todo: nak buatpe ni
    //accept meeting ni patutnya accept request meeting dari user on selected date
    @FXML
    public void acceptBtn() {

    }
}
