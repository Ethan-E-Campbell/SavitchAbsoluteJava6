/*
* CPS 202
* Spring 2021
* Ethan Campbell
*
* Stubbed by Dr. Close
*
*/
package airplaneseats;

import java.util.Scanner;

/**
* File name: SeatsDelegate.java
* <p>
* Description: Console-based Delegate (View/Controller) class for the airplane
* seat assignments problem.
* <p>
* This class is designed to support the Model-Delegate pattern.
* <p>
* Finished Version
* <p>
* @author Ethan Campbell
* @version 12-Feb-2021
*/
public class SeatsDelegate
{
    //-------instance fields-------

    private final SeatsModel seats;
    private String seatSelection;

    //-------constructors-------

    /**
    * No-arg constructor
    */
    public SeatsDelegate()
    {
        seats = new SeatsModel();
        seatSelection = "";
        displayHeader();
        assignSeats();
        
    } //end no-arg constructor
 
    public void assignSeats()
    {
        Scanner keyboard = new Scanner(System.in);
        String runAgain = "Y";
       
        //main loop to assign multiple seats
        while (seats.getSeatsLeft() > 0 && runAgain.equalsIgnoreCase("Y"))
        {
            //loop to assign one seatLetter
            do
            {
                //loop to get a valid seatLetter number
                do
                {
                    System.out.print("please enter the seat selection:  ");
                    seatSelection = keyboard.nextLine();
                }
                while (seatSelection.length() != 2 || !validSeat(seatSelection));
                
                //Assign the seat letter/pass to model
                if(seats.requestSeatAssignment(seatSelection.toUpperCase()))
                {
                    System.out.println("Seat " + seatSelection.toUpperCase() + " is now Assigned" );
                    
                    System.out.println("Seats remaining = "
                    + seats.getSeatsLeft()
                    + "\n");
                }
                else if (seats.getSeatsLeft() == 0)
                    System.out.println("No seats Remaining");
                else
                    System.out.println("Seat is already Assigned");
             
            displaySeats();
            
            //asks user if they wish to assign another seat
            if (seats.getSeatsLeft() > 0)
                do
                {
                    System.out.print("Assign another seat (Y/N):  ");
                    runAgain = keyboard.nextLine();
                }
                while (!runAgain.equalsIgnoreCase("Y"));
         }  
         while (!runAgain.equalsIgnoreCase("Y") && seats.getSeatsLeft() > 0);
     
        } //end main while
       
       if (seats.getSeatsLeft() == 0)
           System.out.println("All seats are assigned.");
       
        displaySeats();
              
    } //end public void assignSeats()
    
    /**
    * simply displays the header.
    */
    public void displayHeader()
    {
        System.out.println("\n\t\tTEST OF AIRPLANE SEAT ASSIGNMENTS\n\n"
                + "Ethan Campbell"
                + "\n12-Feb-2021\n");
        System.out.println("you will be selecting seats for this airplane"
                + "\nseating plan: \n");
        
        displaySeats();
        
        System.out.println("You will input the seat selection with the row number "
        +"followed by the seat letter (ex.3B)");
    } //end public void displayHeader()
    
    /**
     * Displays the airplane seats as a floor plan.
     */
    public void displaySeats()
    {
        System.out.println(seats.toString());
    } //end public void displaySeats
 
/**
 * validSeat takes user plane seat input, and determines if it is valid input or not.
 * it effectively throws away any bad input, until it receives good input from
 * when it was called.
 * @param userinput
 * @return validRow and validSeat, if they are true or false
 */
 
    public boolean validSeat(String userinput)
    {
        String row = userinput.substring(0,1);
        String seatLetter = String.valueOf(userinput.charAt(1)).toUpperCase();
        boolean validRow = false;
        boolean validSeat = false;
        boolean isValid = false;
        
        //this for loop makes sure that the row number is valid
        for (int i = 1; i < seats.getNumberofSeatRows() + 1; i++)
         if (row.equals(String.valueOf(i)))
                 validRow = true;
        if (seatLetter.equalsIgnoreCase("A") || seatLetter.equalsIgnoreCase("B")
                || seatLetter.equalsIgnoreCase("C") || seatLetter.equalsIgnoreCase("D"))
            validSeat = true;
        
        return validRow && validSeat;
    } //End public boolean validSeat

}//End public class SeatsDelegate


