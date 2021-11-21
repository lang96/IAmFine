package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSetMeetingController implements Initializable {

    @FXML
    private Button backBtn,setMeetingBtn;

    @FXML
    private ComboBox hours,minutes;


    @FXML
    public void toUserMeetingSchedule() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userMeetingSchedule.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        hours.getItems().removeAll(hours.getItems());
        hours.getItems().addAll("09", "10", "11", "12", "13", "14", "15", "16", "17");
        minutes.getItems().removeAll(minutes.getItems());
        minutes.getItems().addAll("00", "15", "30", "45");
    }

    @FXML
    public void setMeeting() throws IOException {

        Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
        errorAlert.setHeaderText("Meeting scheduled");
        errorAlert.setContentText("Your requested meeting details have been set!");
        errorAlert.showAndWait();
        Parent root = FXMLLoader.load(getClass().getResource("userMeetingSchedule.fxml"));
        Stage window = (Stage) setMeetingBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

}
