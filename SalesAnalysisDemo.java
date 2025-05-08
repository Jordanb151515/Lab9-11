import java.util.Scanner;
import java.io.*;

/**
 * Application takes name of the file to read from, test if file exists, and calls to
 * the SalesAnalysis class for calculation and output.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 5/8/25
 */
public class SalesAnalysisDemo
{
    public static void main(String[] args)throws IOException{
        String file;
        
       Scanner keyboard = new Scanner(System.in);
       System.out.print("Enter the file name: ");
       file = keyboard.nextLine();
       
       File fileTest = new File(file);
       while(!(fileTest.exists())){
        System.out.print("File does not exist. Enter file name: ");
        file = keyboard.nextLine();
        }
       SalesAnalysis object = new SalesAnalysis(file);
       object.processFile();
       object.writeOutput();
    
    }
}
