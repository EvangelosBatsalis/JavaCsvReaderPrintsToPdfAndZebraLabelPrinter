import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloWorldPrinter implements Printable, ActionListener {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> kati;
    int numberOutPut;
    public HelloWorldPrinter(ArrayList<String> s, int numberOutPut) {
        this.kati = s;
        this.numberOutPut=numberOutPut;
    }

    public int print(Graphics g, PageFormat pf, int page) throws
            PrinterException {

        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Now we perform our rendering */
//        g.drawString("Hello world!!!", 100, 100);
//        g.drawString(kati.get(0), 100, 100);
//        int pos = 0;
//        for(String list: kati){
//            g.drawString(list,100,100+pos);
//            pos+=20;
//        }

        numberOutPut = 150;
        System.out.println(numberOutPut);
        String[] test = kati.get(numberOutPut).split("\n");
        System.out.println(test.length);
        String kati = test[0];//1
        String kati1 = test[1];//2
        String kati2 = test[2];//3
        String kati3= test[3];//4
        String kati4 = test[4];//5
        String kati5 = test[5];//6


        g.drawString("A/A: "+numberOutPut,100,100);
        g.drawString(kati,100,120);
        g.drawString(kati1,100,140);
        g.drawString(kati2,100,160);
        g.drawString(kati3,100,180);
        g.drawString(kati4,100,200);
        g.drawString(kati5,100,220);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                /* The job did not successfully complete */
            }
        }
    }
}
 