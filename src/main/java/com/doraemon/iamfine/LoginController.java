package com.doraemon.iamfine;

import static com.doraemon.iamfine.MainApplication.*;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



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
    public void toHomePage() throws IOException {

        ArrayList<String> usernameArr = new ArrayList<>();
        ArrayList<String> passwordArr = new ArrayList<>();
        ArrayList<String> typeArr = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject userData = (JSONObject) obj;

            JSONArray JSONUserArr = (JSONArray) userData.get("username");
            JSONArray JSONpassArr = (JSONArray) userData.get("password");
            JSONArray JSONtypeArr = (JSONArray) userData.get("type");

            if (JSONUserArr.size() != 0) { // only proceed with array if there are users registered

                for (int i = 0; i < JSONUserArr.size(); i++) {

                    String ID = "" + JSONUserArr.get(i);
                    String pass = "" + JSONpassArr.get(i);
                    String type = "" + JSONtypeArr.get(i);

                    usernameArr.add(ID);
                    passwordArr.add(pass);
                    typeArr.add(type);

                }

            } else {

                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("No users registered!");
                errorAlert.setContentText("Please register for a new account.");
                errorAlert.showAndWait();

            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

        String getUsername = usernameTextField.getText();
        String getPassword = passwordTextField.getText();

        boolean found = false;
        int idIndex = 0;

        for (int i = 0; i < usernameArr.size(); i++) {

            if (usernameArr.get(i).equals(getUsername)) {
                found = true;
                idIndex = i;
            }

        }

        if (found) {

            if (passwordArr.get(idIndex).equals(getPassword)) {

                String type = typeArr.get(idIndex);

                if (type.equals("User")) {

                    currentUserID = getUsername;
                    currentUserType = "User";

                    // go to user homepage
                    Parent root = FXMLLoader.load(getClass().getResource("userHomepage.fxml"));
                    Stage window = (Stage) theraBtn.getScene().getWindow();
                    window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
                    window.setScene(new Scene(root,335,602));

                } else if (type.equals("Therapist")) {

                    currentUserID = getUsername;
                    currentUserType = "Therapist";

                    // go to therapist homepage
                    Parent root = FXMLLoader.load(getClass().getResource("therapistHomepage.fxml"));
                    Stage window = (Stage) theraBtn.getScene().getWindow();
                    window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
                    window.setScene(new Scene(root,335,602));

                }

            } else {

                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Error");
                errorAlert.setContentText("Wrong Username or Password");
                errorAlert.showAndWait();
                usernameTextField.setText("");
                passwordTextField.setText("");

            }

        } else {

            if (getUsername.equals("") || getPassword.equals("")) {

                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Please insert Username and Password");
                errorAlert.showAndWait();

            } else {

                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Error");
                errorAlert.setContentText("Wrong Username or Password");
                errorAlert.showAndWait();
                usernameTextField.setText("");
                passwordTextField.setText("");}

        }

    }
}
