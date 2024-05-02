package org.openjfx;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;



public class SecondaryController{
    //descrription textarea
    //5 items for now
    int[] itemQuantity = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    String[] receiptStrings = new String[16];
    generateReceipt generateReceipt = new generateReceipt();


    @FXML
    TextArea detailsField;

    @FXML
    TextField money;

    @FXML
    TextArea totalArea;

    @FXML
    Button okButton;

    @FXML
    Text insufficient;

    @FXML
    ListView list;
    @FXML
    Label printedLabel;


    @FXML
    private void clearDetails() throws IOException{
        detailsField.clear();
    }


    @FXML
    private void setReceiptArea() throws IOException{
        //have a class that takes the array as a parameter
    //when button of something is pressed add 1 to the array
        list.getItems().clear();
        totalArea.clear();

        receiptStrings = generateReceipt.generate(itemQuantity);
        int n;



        //for loop right here loops for how many pieces we have so far
        //change n to +1 for everytime you add a ne button add two to this? this was 4
        for(n=0;n<=14;n++) {
            if (receiptStrings[n]!=null) {
                list.getItems().add(receiptStrings[n]);

            }
        }
        //make a new method for calculating the total so the numbers will stay in generateReceipt class
        //totalArea.setText();
            //i think we can use append text with a for loop each piece of the returned array
    }

    //reset button
    @FXML
    private void reset() throws IOException{
        App.setRoot("secondary");

    }

    //exitButton
    @FXML
    private void switchToPrime() throws IOException {
        App.setRoot("loginscreen");
    }

    @FXML
    private void switchToEdit() throws IOException{
        App.setRoot("edit");
    }



    //completeButton
    @FXML
    private void complete() throws IOException{


        money.setOpacity(1);
        okButton.setOpacity(1);
        okButton.setDisable(false);
        //what does getText return make a variable to gold the text from money




        //call primary

    }

    //okBUtton
    @FXML
    private void calculate() throws IOException{
        int moneyINT;
        //clear the totalArea
        insufficient.setText(" ");

        moneyINT = Integer.parseInt(money.getText());
        int inum = Integer.parseInt(generateReceipt.calculateTotal(moneyINT));

        if (inum<0){
            insufficient.setText("INSUFFICIENT FUNDS");
            money.clear();

        }else {
            money.setOpacity(0);
            okButton.setOpacity(0);
            okButton.setDisable(true);

            totalArea.appendText("\n     CHANGE:   "+Integer.toString(inum));

        }


    }
    //print receipt
    @FXML
    private void printReceipt(){
        generateReceipt.printReceipt();
        printedLabel.setOpacity(1);
    }


    @FXML
    private void chorizoDescription() throws IOException{
        detailsField.setText("THIS IS CHORIZO MUDKIP and rice\n\n100Php \nPreparation Time: 20 mins");
    }

    @FXML
    private void chorizoPressed() throws IOException{
        itemQuantity[0]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }

//food tab
    @FXML
    private void spamDescription() throws IOException{
        detailsField.setText("you like spam?\n\n110Php \nPreparation Time: 30 mins");
    }

    @FXML
    private void spamPressed() throws IOException{
        itemQuantity[1]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }

    @FXML
    private void hotdogDescription() throws IOException{
        detailsField.setText("This is hotdog\nserver with rice\n\n90Php \nPreparation Time: 20 mins");
    }

    @FXML
    private void hotdogPressed() throws IOException{
        itemQuantity[2]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }

    @FXML
    private void cornedDescription() throws IOException{
        detailsField.setText("corned beef\nserver with rice\n\n100Php \nPreparation Time: 20 mins");
    }

    @FXML
    private void cornedPressed() throws IOException{
        itemQuantity[3]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }

    @FXML
    private void tapsilogDescription() throws IOException{
        detailsField.setText("Tapa \nwith rice!\n\n80Php \nPreparation Time: 30 mins");
    }

    @FXML
    private void tapsilogPressed() throws IOException{
        itemQuantity[4]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }

    @FXML
    private void siomaiDescription() throws IOException{
        detailsField.setText("Siomai \nwith rice!\n\n60Php \nPreparation Time:15 mins");
    }

    @FXML
    private void siomaiPressed() throws IOException{
        itemQuantity[5]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }


//drinks tab
    @FXML
    private void coffeeDescription() throws IOException{
    detailsField.setText("Cup of Coffee\nmade with nice beans\n\n50Php \nPreparation Time: 10 mins");
    }

    @FXML
    private void coffeePressed() throws IOException{
        itemQuantity[6]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }

    @FXML
    private void wintermelonDescription() throws IOException{
        detailsField.setText("Classic Wintermelon\nwith pearls\n\n70Php \nPreparation Time: 10 mins");
    }

    @FXML
    private void wintermelonPressed() throws IOException{
        itemQuantity[7]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }
    @FXML
    private void chocolateDescription() throws IOException{
        detailsField.setText("Just Chocolate!\nwith pearls\n\n70Php \nPreparation Time: 10 mins");
    }

    @FXML
    private void chocolatePressed() throws IOException{
        itemQuantity[8]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }
    @FXML
    private void teaDescription() throws IOException{
        detailsField.setText("Just Chocolate!\nwith pearls\n\n70Php \nPreparation Time: 10 mins");
    }

    @FXML
    private void teaPressed() throws IOException{
        itemQuantity[9]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }
    @FXML
    private void taroDescription() throws IOException{
        detailsField.setText("its taro!!\nwith pearls\n\n70Php \nPreparation Time: 10 mins");
    }

    @FXML
    private void taroPressed() throws IOException{
        itemQuantity[10]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }
    @FXML
    private void greenDescription() throws IOException{
        detailsField.setText("tea topped with green\nwith pearls\n\n70Php \nPreparation Time: 10 mins");
    }

    @FXML
    private void greenPressed() throws IOException{
        itemQuantity[11]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }

    //misc tab
    @FXML
    private void serviceDescription() throws IOException{
        detailsField.setText("Service Fee\n\n70Php \n");
    }

    @FXML
    private void servicePressed() throws IOException{
        itemQuantity[12]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }
    @FXML
    private void deliveryDescription() throws IOException{
        detailsField.setText("Delivery Fee\n\n20Php \n");
    }

    @FXML
    private void deliveryPressed() throws IOException{
        itemQuantity[13]+=1;
        setReceiptArea();
        totalArea.setText("        Total:   ");
        totalArea.appendText(generateReceipt.setTotalArea());
    }
}