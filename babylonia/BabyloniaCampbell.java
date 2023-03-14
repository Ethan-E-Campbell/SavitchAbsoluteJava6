
package babylonia;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;


        

public class BabyloniaCampbell
{ 

    
    /**
     * Prompts user to enter Radicand.Keyboard entry is fully bullet-proofed to allow only positive doubles.
     * @return
     */
    public static double obtainValidRadicand()
    {
        Scanner keyboard = new Scanner(System.in);
        String obtainValidRadicand = "";
        
        System.out.print("Enter the radicand:  ");
        obtainValidRadicand = keyboard.nextLine();
        while (!isValidNumber(obtainValidRadicand,"") 
               || obtainValidRadicand.contains("-"))
        {
            System.out.print("Enter the Radicand:   ");
            obtainValidRadicand = keyboard.nextLine();            
        }
        
        return Double.parseDouble(obtainValidRadicand);
                
    }//End public static double obtainValidRadicand()
    
    public static double EstimateSquareRoot(double radicand)
    {
        double new_estimate = radicand / 2;
        double old_estimate = radicand;
        int guess_counter = 1;
        double roundOff;
        while (((old_estimate - new_estimate) / old_estimate) > 0.001)
        {
            old_estimate = new_estimate;
            new_estimate = (old_estimate + (radicand / old_estimate)) / 2;
            
            DecimalFormat formatter = new DecimalFormat("#,###.0000");
            System.out.println("Guess " + guess_counter + " = " + formatter.format(new_estimate));
            guess_counter += 1;   
        }
    
        
    
        
        
       return new_estimate; 
    } //end public static double estimateSquareRoot()
             
    
    /** 
     * Validates a string as a number using regular expression pattern matching.
     * <p>
     * @author Daryl Close dclose@heidelberg.edu
     * @return             true if string is a valid number, false otherwise.
     * @param numberString string to be converted to a number
     * @param type         "natural" invokes check for natural number
     *                     otherwise a real
     */ 
    
    
    public static boolean isValidNumber(String numberString, String type)
    {   
        String regex;
        
        if (type.equalsIgnoreCase("natural"))
            regex = "[0-9]+";                //Match unsigned ints only        
        else
            regex = "^[-+]?"                 //Match opt. sign in the set
                    + "[0-9]"                //Match digits 
                    + ".?[0-9]+"             //Match opt. dot and digits
                    + "([eE][-+]?[0-9]+)?$"; //Match scientific   
               
        Pattern p = Pattern.compile(regex);        
        Matcher m = p.matcher(numberString);
        
        boolean isValid = m.matches();
      
        //Convenience form:
        /*
        isValid = Pattern.matches("^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$", 
                                  numberString);
        */
        
        return isValid;
       
    }//End public static boolean isValidNumber(String) 
    
    
    /**
     * Main method to compute and display attempts at finding square root
     * <p>
     * @param args String array for command line arguments
     */
    
    public static void main(String[] args)
    {  
        double square_root = 0.0;
        double radicand = 0.0;

        
        
        //Display program header
        System.out.println("\n\t\tCOMPUTE A SQUARE ROOT\n");
        System.out.println("Ethan Campbell");
        System.out.println("January 25, 2021");
        System.out.println("This program estimates square roots using the "
                + "Babylonia algorithm.");
        
        //Prompt user for input
        radicand = obtainValidRadicand();
           
 
        if (radicand == 0)
        {
            square_root = 0;
        }
        else if (radicand == 1)
        {
        square_root = 1;
        }
        else
        {
        square_root = EstimateSquareRoot(radicand);
        }
        
         DecimalFormat formatter = new DecimalFormat("#,###.0000");
         
        System.out.println("The estimated square root of " + radicand + " is " + formatter.format(square_root));
        
        System.out.println();
            
    }//End public static void main(String[])
    
}//End class BabyloniaCampbell