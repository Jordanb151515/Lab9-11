
/**
 * Write a description of class SalesAnalysis here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SalesAnalysis
{
    // instance variables - replace the example below with your own
    public int DAYS_OF_THE_WEEK = 7;
    private double[] weeklyNumber;
    private String inputFile;
    private int lineNumber = 0;

    /**
     * Constructor for objects of class SalesAnalysis
     */
    public SalesAnalysis(String inFile)
    {
        inputFile = inFile;
        weeklyNumber = new double[4];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void processFile()
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void setArrayElement(String[] inArray)
    {
        double total;
        for (String s : inArray){
            total += Double.parseDouble(s);
        }
        weeklyNumber[lineNumber] = total;
        lineNumber++;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void writeOutput()
    {
       double totalSales = 0;
       double min = weeklyNumber[0];
       double max = weeklyNumber[0];
       int minWeek, maxWeek;
       for(int i=0; i<=weeklyNumber.length; i++){
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
            System.out.printf("\nAvg Daily Sales for Week: $%,.2f", weeklyNumber[i]/DAYS_OF_THE_WEEK);
            
        }
        System.out.printf("Total Sales for all Weeks: $%,.2f\n", totalSales);
        System.out.printf("Avg Weekly Sales: $%,.2f\n", totalSales/DAYS_OF_THE_WEEK);
        System.out.printf("Week %d had the highest amount of sales", maxWeek + 1);
        System.out.printf("Week %d had the lowest amount of sales", minWeek + 1);
    }
}
