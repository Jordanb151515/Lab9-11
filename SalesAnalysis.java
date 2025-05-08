import java.util.Scanner;
import java.io.*;

/**
 * SalesAnalysis class includes methods to process file, add to an array of sales, and display
 * output to the user regarding the sales.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 5/8/25
 */
public class SalesAnalysis 
{
    public int DAYS_OF_THE_WEEK = 7;
    private double[] weeklyNumber;
    private String inputFile;
    private int lineNumber = 0;

    /**
     * Constructor for objects of class SalesAnalysis. Assigns the input to inputFile and intializes
     * new array for sales.
     * 
     * @param  inFile  the string fot the path of the file
     */
    public SalesAnalysis(String inFile)
    {
        inputFile = inFile;
        weeklyNumber = new double[4];
    }

    /**
     * Method creates file and scanner objects and reads each line from the file.
     */
    public void processFile()throws IOException
    {
        String line;
        File file = new File(inputFile);
        Scanner inputFile = new Scanner(file);
        while(inputFile.hasNextLine()){
              line = inputFile.nextLine();
              String[] tokens = line.split(",");
              setArrayElement(tokens);
        }
        inputFile.close();
    }
    
    /**
     * Method adds the contents of each line in the file to an array for the sales.
     *
     * @param  inArray  the inputted array for the elements that are going to be totaled
     */
    private void setArrayElement(String[] inArray)
    {
        double total = 0;
        for (String s : inArray){
            total += Double.parseDouble(s);
        }
        weeklyNumber[lineNumber] = total;
        lineNumber++;
    }
    
    /**
     * Method calculates the total, min, max, and average and displays the results to the console.
     */
    public void writeOutput()
    {
       double totalSales = 0;
       double min = weeklyNumber[0];
       double max = weeklyNumber[0];
       int minWeek = 0, maxWeek = 0;
       for(int i=0; i<weeklyNumber.length; i++){
            totalSales += weeklyNumber[i];
            if(weeklyNumber[i]<min){
            min = weeklyNumber[i];
            minWeek = i;
        }
            if(weeklyNumber[i]>max){
            max = weeklyNumber[i];
            maxWeek = i;
        }
            
            System.out.print("\nWeek " + (i+1) + " Info");
            System.out.printf("\nTotal Sales: $%,.2f", weeklyNumber[i]);
            System.out.printf("\nAvg Daily Sales for Week: $%,.2f\n", weeklyNumber[i]/DAYS_OF_THE_WEEK);
            
        }
        System.out.printf("\nTotal Sales for all Weeks: $%,.2f\n", totalSales);
        System.out.printf("Avg Weekly Sales: $%,.2f\n", totalSales/weeklyNumber.length);
        System.out.printf("Week %d had the highest amount of sales\n", maxWeek + 1);
        System.out.printf("Week %d had the lowest amount of sales\n", minWeek + 1);
    }
}
