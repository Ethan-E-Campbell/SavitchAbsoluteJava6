/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa5babynames;

import java.util.Scanner;

/**
 * File name: BabyNamesConsoleDelegate.java
 * <p>
 * Description: Console-based Delegate (View/Controller) class for the 
 * PA5 Baby Names assignment problem.
 * <p>
 * This class is designed to support the Model-Delegate pattern.
 * <p>
 * Finished version.
 * <p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @version 12-March-2021 
 */
public class BabyNamesConsoleDelegate 
{
    
    //-------instance fields-------
    
    BabyNamesModel nameSearch = new BabyNamesModel();
    private String name;
    private int boyRegisteredBirths;
    private int boyRanking;
    private int girlRegisteredBirths;
    private int girlRanking;
    private boolean girlExists;
    private boolean boyExists;
    
    //-------constructors-------
    
    /**
     * No-arg constructor
     */
    public BabyNamesConsoleDelegate()
    {
        nameSearch.readFile("boynames.txt");
        nameSearch.readFile("girlnames.txt");
        name = "none yet";
        boyRegisteredBirths = 0;
        boyRanking = 0;
        girlRegisteredBirths = 0;
        girlRanking = 0;
        girlExists = true;
        boyExists = true;
        getNameDataorExit();

    }//End no-arg constructor  
    
    /**
    * Gets and displays the Name data if it is a Boy or Girl based on what the
    * user enters.
    * It will also prompt an exit if the entered information is actually a Q.
    */
    public void getNameDataorExit()
    {

        int exitStatus = 0; //this is the do-while loop variable
        do
        {  
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter a baby name or " + "enter Q to exit!");
            name = keyboard.next();
            
            name = name.toLowerCase(); //makes sure all data is lowercase
        
            if(name.equalsIgnoreCase("q")) //change exit status to 1, break while
            {
                
                exitStatus = 1;

            } //end q check
            
            //Below checks/verifies if provided name is in database
            int boyNameVerify = nameSearch.verifyBoyNameData(name); 
            int girlNameVerify = nameSearch.verifyGirlNameData(name);
        
            if (boyNameVerify == 1)
            {
                boyRegisteredBirths = nameSearch.getBoyRegisteredBirths(name);
                boyRanking = nameSearch.getBoyIndexofName(name);
                boyExists = true;
            
            }
            
            else  
            {
                boyExists = false;  
            }
            
            if (girlNameVerify == 1)
            {
                
                girlRegisteredBirths = nameSearch.getGirlRegisteredBirths(name);
                girlRanking = nameSearch.getGirlIndexofName(name); 
                girlExists = true;
            }
            
            else
            {
                girlExists = false; 
            }
            
            //below simply makes sure that the first letter is capitalized
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            
            if(exitStatus == 0) //only displayed if the exitStatus is still 0
            {
                this.displayData();
                
            } //end if exitStatus
            
        } //end do-while loop
        while(exitStatus == 0);
        
        if(exitStatus == 1);
        {
            System.out.println("Enjoy the rest of your day!");
            System.exit(0);
        }
        
    } //end public void getandDisplayNameDataorExit
    
    /**
     * Displays the Name data if it is a Boy or Girl based on what the
     * user enters.
     */
    public void displayData()
    {
        if (girlExists == true && boyExists == true)
        {
            System.out.println(name + " is ranked " 
                               + girlRanking +  " in popularity among Girls "
                               + "with " + girlRegisteredBirths + " namings\n" 
                               + name + " is " + "ranked " + boyRanking  
                               + " in popularity among boys with "
                               + boyRegisteredBirths + " namings"); 
            
        }
                
        if (girlExists == false && boyExists == true)
        {
            System.out.println(name + " is ranked " 
                               + boyRanking + " in popularity among Boys "
                               + "with " + boyRegisteredBirths 
                               + " namings\n" + name
                               + " is not ranked among the top "
                               + "1000 girl names"); 
            
        }
                
        if (girlExists == true && boyExists == false)
        {
            System.out.println(name + " is ranked " 
                               + girlRanking + 
                               " in popularity among Girls "
                               + "with " + girlRegisteredBirths
                               + " namings\n" + name + 
                               " is not ranked among the top "
                               + "1000 boy names");
        }
                
        else if (girlExists == false && boyExists == false)
        {   
            System.out.println(name + " is not ranked "
                               + "among the top 1000 girl names\n" + name  
                               + " is not ranked among the top 1000"
                               + " boy names"); 
        }
                
    } //end public void displayData
    
} // end public class BabyNamesConsoleDelegate
