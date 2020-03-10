import java.util.InputMismatchException;
import java.util.Scanner;

public class IOHelper
{
    private static Scanner input = new Scanner(System.in);

    public static int getInt(int low, String prompt, int high) 
    {
        int response = 0;
        String garbage;
        boolean numericEntryOK;
        
        do 
        {
            System.out.print(prompt);
            numericEntryOK = false;
            
            try 
            {
            	// get the user's response
                response = input.nextInt();
                garbage = input.nextLine();
                numericEntryOK = true;
                
            } 
            catch (InputMismatchException e) 
            {
            	// if the user's response is not an integer
            	garbage = input.nextLine();
                System.out.println(garbage + " is not an integer!");
                response = low;
            } // end try-catch
            
            // if the user's input is outside the boundaries
            if (response < low || response > high)
                System.out.println("The number is outside the legal limits.");
            
        } while (numericEntryOK == false || response < low || response > high); // end loop
        
        return response;
    } // end getInt

    public static String getString(String prompt) 
    {
        String response;
        
        System.out.print(prompt);
        
        response = input.nextLine();
        
        return response;
    } // end getString method
    
} // end IOHelper class
