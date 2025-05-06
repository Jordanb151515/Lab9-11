import java.util.Scanner;
import java.io.*;


/**
 * Write a description of class SalesAnalysisDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SalesAnalysisDemo
{
    public static void main(String[] args){
        String file;
        
       Scanner keyboard = new Scanner(System.in);
       System.out.print("Enter the file name: ");
       file = keyboard.nextLine();
       
       while(!(file.exists())){
        System.out.print("File does not exist. Enter file name: ");
        file = keyboard.nextLine();
        }
       SalesAnalysis object = new SalesAnalysis(file);
       object.processFile();
       object.writeOutput();
    
    }
}
