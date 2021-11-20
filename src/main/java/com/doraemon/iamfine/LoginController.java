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

public class LoginController {

    @FXML
    private Button backBtn,theraBtn;
    @FXML
    private TextField usernameTextField, passwordTextField;

    @FXML
    public void toLandingPage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));
    }

    @FXML
    public void toTherapistHomePage() throws IOException {
        //dummy
        String usernameFirebase = "Adib";
        String passwordFirebase = "rocket";

        String getUsername = usernameTextField.getText();
        String getPassword = passwordTextField.getText();

        if (getUsername.equals(usernameFirebase) && getPassword.equals(passwordFirebase)) {
            Parent root = FXMLLoader.load(getClass().getResource("therapistHomepage.fxml"));
            Stage window = (Stage) theraBtn.getScene().getWindow();
            window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
            window.setScene(new Scene(root,335,602));
        } else {
            Alert dialog = new Alert(Alert.AlertType.ERROR, "Incorrect Username or Password", ButtonType.OK);
            dialog.show();
        }

    }
}
