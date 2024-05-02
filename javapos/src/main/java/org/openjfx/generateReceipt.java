package org.openjfx;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//i think we should have a prices array here already


public class generateReceipt {
    int[] itemResult = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int totalInt;
    String[] ret = new String[17];


    public String[] generate(int[] itemQuantity)
    {
        int n;

        /**the other alternative would to not make a string for itemquanitty and have an itneger for each item then
        and dont let it print into the lsit view all at once
        just print as its pressed

        means youlls have to change the variables in secondary controller and the method in generateReceipt **/


        itemResult = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] itemPrice = new int[]{100,110,90,100,80,60,50,70,70,70,70,70,20,20};

        //add two to this?

        String itemQS;
        String itemRS;
        //for loop to create the pieces
        ret[0]="RECEIPT:\n";
        ret[1]="Quantity:    Item:   SubTotal:";

        //change n +1 for every ne item
        for(n=0;n<=13;n++){
            if(itemQuantity[n]>0){
                switch(n) {
                    case 0:
                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x         CHORIZO  PHP"+itemRS;
                        break;
                    case 1:
                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x         SPAM        PHP"+itemRS;

                        break;
                    case 2:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x         HOTDOG      PHP"+itemRS;

                        break;
                    case 3:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x       CORNED BEEF   PHP"+itemRS;

                        break;
                    case 4:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x       TAPSILOG     PHP"+itemRS;

                        break;
                    case 5:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x       SIOMAI     PHP"+itemRS;

                        break;
                    case 6:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x       COFFEE     PHP"+itemRS;

                        break;
                    case 7:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x     WINTERMELON  PHP"+itemRS;

                        break;
                    case 8:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x     CHOCOLATE PHP"+itemRS;

                        break;
                    case 9:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x               TEA   PHP"+itemRS;

                        break;
                    case 10:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x              TARO     PHP"+itemRS;

                        break;
                    case 11:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x              GREEN     PHP"+itemRS;

                        break;
                    case 12:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x     SERVICE FEE    PHP"+itemRS;

                        break;
                    case 13:

                        itemResult[n]+=itemPrice[n]*itemQuantity[n];

                        itemQS= Integer.toString(itemQuantity[n]);
                        itemRS= Integer.toString(itemResult[n]);


                        ret[n+2]=itemQS+"x    DELIVERY FEE    PHP"+itemRS;

                        break;
                }
            }
        }

        return ret;
    }

    public String setTotalArea(){
        String totalString;
        totalInt=0;

        //for total problem here is that it only returns int thats why you would want it in its own method
        for(int i = 0; i < 15; i++)
        {
            totalInt += itemResult[i];
        }


        totalString = Integer.toString(totalInt);
        //total ends here
        return totalString;

    }

    public String calculateTotal(int cash){
        int changeInt;
        String changeString;

        //make if for negative
        //way to delete result
        changeInt = cash - totalInt;
        changeString = Integer.toString(changeInt);

        //
        return changeString;
    }

    public void printReceipt(){
        FileWriter myReceipt = null;
        int len = ret.length;
        try {
            myReceipt = new FileWriter("receipt.txt");
            String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date());
            myReceipt.write("RECEIPT:\n" +
                    timeStamp +
                    "\n-----------------------------------------" +
                    "\n     Quantity:    Item:   SubTotal:\n");
            for (int i = 2; i<len;i++){
                if(ret[i]!=null) {
                    myReceipt.write("\t" + ret[i] + "\n");
                }
            myReceipt.write("\nTOTAL\t\t\t" + "P" + totalInt +
                    "\nCASH\t\t\t" + "P" + cash +
                    "\nCHANGE\t\t\t" + "P" + changeInt);
            }
            myReceipt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //something that returns an array of strings
}
