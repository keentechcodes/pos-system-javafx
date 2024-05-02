package org.openjfx;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class loginChangeController {

    @FXML
    ListView usernamesList;

    @FXML
    ListView passwordsList;

    @FXML
    Button displayButton;

    @FXML
    TextField usernameNew;



    public String[] fileRead(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\Rafael M. Cabrera\\Desktop\\Projects\\jAVA POS\\javapos\\src\\main\\resources\\org\\openjfx\\" + filename));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);
        return arr;
    }


@FXML
private void displayUsernamesandPasswords() throws IOException{
        usernamesList.getItems().clear();
        passwordsList.getItems().clear();

        String [] usernames= new String[3];
        String [] passwords = new String[3];
    usernames = fileRead("usernames.txt");
    passwords = fileRead("passwords.txt");
    displayButton.setOpacity(0);
    displayButton.setDisable(true);


for (int n = 0; n<3;n++) {
    usernamesList.getItems().add(usernames[n]);
    passwordsList.getItems().add(passwords[n]);
}

}

    @FXML
    private void changeStart() throws IOException {
        final int selectedIdx = usernamesList.getSelectionModel().getSelectedIndex();
        String newUser = usernameNew.getText();
        String[] usernames = new String[3];
        usernames = fileRead("usernames.txt");


        if (selectedIdx != -1) {
            //something to write on the file
            usernames[selectedIdx]=newUser;
        }

        //now open the file and put the usernames array on it
        FileWriter myUsers = null;
        int len = usernames.length;
        try {
            myUsers = new FileWriter("C:\\Users\\Rafael M. Cabrera\\Desktop\\Projects\\jAVA POS\\javapos\\src\\main\\resources\\org\\openjfx\\usernames.txt");
            for (int i = 0; i<len;i++){
                if(usernames[i]!=null) {
                    myUsers.write( usernames[i] + "\n");
                }
            }
            myUsers.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        displayUsernamesandPasswords();

    }

    @FXML
    private void changeStartPass() throws IOException {
        final int selectedIdx = usernamesList.getSelectionModel().getSelectedIndex();
        String newUser = usernameNew.getText();
        String[] usernames = new String[3];
        usernames = fileRead("passwords.txt");


        if (selectedIdx != -1) {
            //something to write on the file
            usernames[selectedIdx]=newUser;
        }

        //now open the file and put the usernames array on it
        FileWriter myPass = null;
        int len = usernames.length;
        try {
            myPass = new FileWriter("C:\\Users\\Rafael M. Cabrera\\Desktop\\Projects\\jAVA POS\\javapos\\src\\main\\resources\\org\\openjfx\\passwords.txt");
            for (int i = 0; i<len;i++){
                if(usernames[i]!=null) {
                    myPass.write( usernames[i] + "\n");
                }
            }
            myPass.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        displayUsernamesandPasswords();

    }





    @FXML
    private void backToMenu() throws IOException{
        App.setRoot("edit");
    }




}