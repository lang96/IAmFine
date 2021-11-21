package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static com.doraemon.iamfine.MainApplication.*;
import static com.doraemon.iamfine.data.DataOperation.*;

public class TherapistRegisterController {

    @FXML
    private Button backBtn,theraBtn;

    @FXML
    private TextField fullNameTextField, passwordTextField,
            phoneNumTextField, emailTextField, licenseTextField,
            experienceTextField;

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
    public void toTheraHomepage() throws IOException {

        RadioButton gender = (RadioButton)radioGroup.getSelectedToggle();

        if (fullNameTextField.getText().equals("") || passwordTextField.getText().equals("") ||
                phoneNumTextField.getText().equals("") || emailTextField.getText().equals("") ||
                licenseTextField.getText().equals("") || experienceTextField.getText().equals("") || gender == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the details below completely!", ButtonType.OK);
            alert.showAndWait();
        } else {

            String fullName = fullNameTextField.getText();
            String password = passwordTextField.getText();
            String phoneNum = phoneNumTextField.getText();
            String email = emailTextField.getText();
            String license = licenseTextField.getText();
            String experience = experienceTextField.getText();
            String selectedGender = gender.getText();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are you sure to continue?");

            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");

            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(yes, no);
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == yes) {
                Alert dialogue = new Alert(Alert.AlertType.NONE,
                        "Registration successful", ButtonType.OK);

                String username = addTherapist(fullName, password, phoneNum, email, license, experience, selectedGender);

                dialogue.showAndWait();

                currentUserID = username;
                currentUserType = "Therapist";

                Parent root = FXMLLoader.load(getClass().getResource("therapistHomepage.fxml"));
                Stage window = (Stage) theraBtn.getScene().getWindow();
                window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
                window.setScene(new Scene(root,335,602));
            }
        }

    }
}
