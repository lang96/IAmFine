package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class UserSetMeetingController {

    //todo: setMeetingBtn for what?

    @FXML
    private Button backBtn,setMeetingBtn;


    @FXML
    public void toUserMeetingSchedule() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userMeetingSchedule.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }
}
