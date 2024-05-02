package org.openjfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PrimaryController {
    @FXML
    TextField usernameBox;

    @FXML
    PasswordField password;

    @FXML
    Label loginError;


    @FXML
    private void login() throws IOException {
        screenLogin us = new screenLogin();

        String User, Pass;
        int action;
        User = usernameBox.getText();
        Pass = password.getText();

        action = us.CheckUser(User,Pass);

        if((action == 2)||(action == 3)||(action == 4)){
            App.setRoot("secondary");
        }
        else if(action == 0){
            loginError.setText("Wrong Password, Try Again");
        }
        else if(action == 1){
            loginError.setText("User does not exist, Try Again");
        }
    }



}
