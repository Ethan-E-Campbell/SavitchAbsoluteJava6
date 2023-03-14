/*
* CPS 202
* Spring 2021
* Ethan Campbell
*
* Stubbed by Dr. Close
*
*/

package airplaneseats;

/**
* File name: SeatsModel.java
* <p>
* Description: Data model for the Airplane Seats assignment
* problem.
* <p>
* This class is designed to support the Model-Delegate pattern.
* <p>
* Finished Version
* <p>
* @author Ethan Campbell
* @version 12-Feb-2021
*/
public class SeatsModel
{
    //-------static fields-------
    private static final int NUMBER_OF_TABLE_ROWS = 7;
    private static final int NUMBER_OF_TABLE_COLUMNS = 5;
    private static final int TOTAL_SEATS = NUMBER_OF_TABLE_ROWS
    * (NUMBER_OF_TABLE_COLUMNS - 1);

    //-------instance fields-------

    private String[][] seatsTable;
    private int seatsLeft;

    //-------constructors-------

    /**
    * No-arg constructor.
    */
    public SeatsModel()
    {
        seatsTable = new String[NUMBER_OF_TABLE_ROWS][NUMBER_OF_TABLE_COLUMNS];
        seatsLeft = TOTAL_SEATS;
         
        //add in all seatsTable columns for airplane row numbers
        for (int i = 0; i < NUMBER_OF_TABLE_ROWS; i++)
        {
           seatsTable[i][0] = String.valueOf(i+1);
        }
        
       //add in all seatsTable rows for airplane seat letters
        for (int i = 0; i < seatsTable.length; i++)
        {
            for (int j = 1; j < seatsTable[0].length; j++)
            {
                if (j == 1)
                {
                    seatsTable[i][j] = "A";
                }
                if (j == 2)
                {
                    seatsTable[i][j] = "B";
                }
                if (j == 3)
                {
                   seatsTable[i][j] = "C"; 
                }
                if (j == 4)
                {
                seatsTable[i][j] = "D"; 
                }
               }  
            
        }
           
    }//End no-arg constructor
 
    public int getSeatsLeft()
    {
        return seatsLeft;
    } //end public int getSeatsLeft()
  
    public int getNumberofSeatRows()
    {
        return NUMBER_OF_TABLE_ROWS;
    } //end public int getNumberofSeatRows
    
    public int getSeatsPerRow()
    {
        return NUMBER_OF_TABLE_COLUMNS - 1;
    } //end public int getSeatsPerRow()
         
 /**
  * Receives a valid seat assignment from the Delegate; it then either assigns
  * it, or it tells the delegate that the seat is not available.
  * <p>
  * @param userinput
  * @return true if seat was assigned, false if seat was already assigned
  */
    boolean requestSeatAssignment(String userinput) 
    {
        Boolean trf = false;
         
       //split the string
        String row = userinput.substring(0,1);
        
        String seatLetter = String.valueOf(userinput.charAt(1)).toUpperCase();
        

        // iterate over row
        for (int i = 0; i < seatsTable.length; i++)
        {
            //iterate over seat
            for (int j = 1; j < seatsTable[0].length; j++)
            {
                if (row.equals(String.valueOf(i + 1 )))
                {
                    if (seatLetter.equalsIgnoreCase("A"))
                       {
                        if (j == 1)
                            {
                                if(seatsTable[i][j].equals("X"))
                                {
                                  trf = false;  
                                } 
                                else 
                                {
                                seatsTable[i][j] = "X";
                                trf = true;
                                seatsLeft = seatsLeft - 1;
                                }
                            }
                        }
                    if (seatLetter.equalsIgnoreCase("B"))
                       {
                        if (j == 2)
                            {
                                if(seatsTable[i][j].equals("X"))
                                {
                                  trf = false;  
                                } 
                                else
                                {
                                seatsTable[i][j] = "X";
                                trf = true;
                                seatsLeft = seatsLeft - 1;
                                }
                            }
                        }
                    if (seatLetter.equalsIgnoreCase("C"))
                       {
                        if (j == 3)
                            {
                                if(seatsTable[i][j].equals("X"))
                                {
                                  trf = false;  
                                } 
                                else
                                {
                                seatsTable[i][j] = "X";
                                trf = true;
                                seatsLeft = seatsLeft - 1;
                                }
                            }
                        } 
                    if (seatLetter.equalsIgnoreCase("D"))
                       {
                        if (j == 4)
                            {
                                if(seatsTable[i][j].equals("X"))
                                {
                                  trf = false;  
                                } 
                                else
                                {
                                seatsTable[i][j] = "X";
                                trf = true;
                                seatsLeft = seatsLeft - 1;
                                }
                            }
                        }     
                  
                }
            }  
        }
        if(trf == true)
        {
        return true;
        }
        else
        {
            return false;
        }
    } //end public boolean requestSeatAssignment(String)
 
 /**
  * String representation of airplane seating assignments.
  * <p>
  * @return string representation of airplane seating assignments
  */
    @Override
    public String toString()
    {
        String seatDisplay = "";
        
        for (int i = 0; i < seatsTable.length; i++)
        {
            for (int j = 0; j < seatsTable[0].length; j++)
            {
                if ((j > 0 && j < 2)|| (j > 2))
                    seatDisplay += seatsTable[i][j];
                else if (j == 2)
                    seatDisplay += seatsTable[i][j] + " ";
                else
                    seatDisplay += seatsTable[i][j] + "  ";
                
           
            }
            seatDisplay += "\n";
        }
        return seatDisplay;    
    }//end public string toString

 }//End public class SeatsModel


