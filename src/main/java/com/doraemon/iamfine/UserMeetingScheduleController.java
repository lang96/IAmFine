package com.doraemon.iamfine;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class UserMeetingScheduleController extends Application {

    @FXML
    private Button backBtn,setMeetingBtn,meetBtn;


    @FXML
    public void toUserHomepage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userHomepage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    //todo: confuse on what this does
    //ini just pergi dekat page set meeting la. page yang ni untuk tengok appointment
    @FXML
    public void toSetMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userSetMeeting.fxml"));
        Stage window = (Stage) setMeetingBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toJoinMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userMeeting.fxml"));
        Stage window = (Stage) meetBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

        getHostServices().showDocument("https://meet.google.com/");

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
