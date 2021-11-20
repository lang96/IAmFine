package com.doraemon.iamfine;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class UserRegisterController {

    @FXML
    private Button backBtn,userBtn,theraBtn;

    @FXML
    private TextField usernameTextField,passwordTextField,
            phoneNumTextField,emailTextField, ageTextField;

    @FXML
    private RadioButton male, female;

    @FXML
    private ToggleGroup radioGroup;

    @FXML
    public void toLandingPage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toUserHomePage() throws IOException {

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String phoneNum = phoneNumTextField.getText();
        String email = emailTextField.getText();
        String age = ageTextField.getText();
        String gender = "";

        if (username.equals("") || password.equals("") || phoneNum.equals("") ||
                email.equals("") || age.equals("")) {
            Alert dialog = new Alert(Alert.AlertType.ERROR,
                    "Please Fill in the form", ButtonType.OK);
            dialog.show();
        } else {
            Alert confirmDialogue = new Alert(Alert.AlertType.CONFIRMATION);
            confirmDialogue.setTitle("Confirmation");
            confirmDialogue.setHeaderText("Are you sure to continue?");

            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");

            confirmDialogue.getButtonTypes().clear();
            confirmDialogue.getButtonTypes().addAll(yes, no);
            Optional<ButtonType> option = confirmDialogue.showAndWait();
            if (option.get() == yes) {
                Alert dialogue = new Alert(Alert.AlertType.NONE,
                        "Register Successful", ButtonType.OK);
                dialogue.showAndWait();
                Parent root = FXMLLoader.load(getClass().getResource("userHomepage.fxml"));
                Stage window = (Stage) userBtn.getScene().getWindow();
                window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
                window.setScene(new Scene(root,335,602));
            }
        }
    }


}
