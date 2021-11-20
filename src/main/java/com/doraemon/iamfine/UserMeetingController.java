package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class UserMeetingController {

    @FXML
    private Button backBtn, submitBtn;

    @FXML
    private TextField commentTextField;


    @FXML
    public void toUserSetMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userMeetingSchedule.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void submitAction() throws IOException {
        if (commentTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Please add comments", ButtonType.OK);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Feedback");
            alert.setContentText("Thank you for the feedback");

            ButtonType ok = new ButtonType("Ok");
            alert.getButtonTypes().clear();
            alert.getButtonTypes().add(ok);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == ok) {
                Parent root = FXMLLoader.load(getClass().getResource("userHomepage.fxml"));
                Stage window = (Stage) submitBtn.getScene().getWindow();
                window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
                window.setScene(new Scene(root,335,602));
            }
        }
    }
}
