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

public class editClass {

    @FXML
    private void backToMenu() throws IOException{
        App.setRoot("secondary");

    }

    @FXML
    private void changeLogins() throws IOException{
        App.setRoot("changeLoginsScreen");

    }




}