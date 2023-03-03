import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.awt.print.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> finalArrayOutput = new ArrayList<>();
        String[] splitedOutput; //= new String[100];
        String line;
        String fileName = "dt4.csv";
        int i = 1,j=0,count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                splitedOutput = line.split(";");
//                System.out.println("A/A: " + i);
//                System.out.println("Αρ.Κατ. : " + splitedOutput[0] + "(" + splitedOutput[1] + ")" + "\n"
//                        + "Διεύθυνση: " + splitedOutput[2] + "\n"
//                        + "Αρ.Ταμείου – θέση: " + splitedOutput[4] + "(" + splitedOutput[3] + ")" + "\n"
//                        + "Type : " + splitedOutput[5] +"  UserName: "+splitedOutput[14] +"\n"
//                        + "Computer name : " + splitedOutput[10] + "\n"
//                        + "IP Address: "+splitedOutput[7]+"  Gateway: "+splitedOutput[9]+"\n"
//                        + "Φορολογικός : " + splitedOutput[11] + "\n");


                if(splitedOutput[11].equals("NAI")){
                    System.out.println("A/A: " + i);
                    count++;
                    System.out.println("Αρ.Κατ. : " + splitedOutput[0] + "(" + splitedOutput[1] + ")" + "\n"
                            + "Διεύθυνση: " + splitedOutput[2] + "\n"
                            + "Αρ.Ταμείου – θέση: " + splitedOutput[4] + "(" + splitedOutput[3] + ")" + "\n"
                            + "Computer name : " + splitedOutput[10] + "  UserName: " + splitedOutput[14] + "\n"
                            //+ "IP Address: "+splitedOutput[7]+"  Gateway: "+splitedOutput[9]+"\n"
                            + "Φορολογικός : " + splitedOutput[11] + "\n");
                }


                finalArrayOutput.add(j,"Αρ.Κατ. : " + splitedOutput[0] + "(" + splitedOutput[1] + ")" + "\n"
                        + "Διεύθυνση: " + splitedOutput[2] + "\n"
                        + "Αρ.Ταμείου – θέση: " + splitedOutput[4] + "(" + splitedOutput[3] + ")" + "\n"
                        + "Type : " + splitedOutput[5] +"  UserName: "+splitedOutput[14] +"\n"
                        + "Computer name : " + splitedOutput[10] + "\n"
                        + "IP Address: "+splitedOutput[7]+"  Gateway: "+splitedOutput[9]+"\n"
                        + "Φορολογικός : " + splitedOutput[11] + "\n");
                System.out.println(count);
                i++;
                j++;
            }

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        String ArrayToString;
        ArrayToString = finalArrayOutput.get(0);

        UIManager.put("swing.boldMetal", Boolean.FALSE);
        JFrame f = new JFrame("Welcome");
        JPanel p = new JPanel();

        f.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        int NumberOutPut=0;
        JButton printButton = new JButton("Print me");
        JTextField tf = new JTextField("0");

        printButton.addActionListener(new HelloWorldPrinter(finalArrayOutput,NumberOutPut));

        printButton.setSize(200,100);
        tf.setSize(100,100);

        f.add(printButton);
        f.add(tf);

        f.setSize(200,300);
        //f.pack();
        f.setVisible(true);
    }//End of PSVmain
}//end of Main Class