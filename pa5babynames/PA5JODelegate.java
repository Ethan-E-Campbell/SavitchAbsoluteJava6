/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa5babynames;

import javax.swing.JOptionPane;

/**
 * File name: PA5JODelegate.java
 * <p>
 * Description: GUI-based Delegate (View/Controller) class for the 
 * PA5 Baby Names assignment problem.
 * <p>
 * This class is designed to support the Model-Delegate pattern.
 * <p>
 * Finished version.
 * <p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @version 12-March-2021 
 */
public class PA5JODelegate
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
    public PA5JODelegate()
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
    * Gets the Name data if it is a Boy or Girl based on what the
    * user enters.
    * It will also prompt an exit if the entered information is actually a Q.
    */
    public void getNameDataorExit()
    {

        int exitStatus = 0; //this is the do-while loop variable
        
        do
        {  
       
            name = JOptionPane.showInputDialog("Enter a baby name or "
                                               + "enter Q to exit!");
            
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
            }
            
        } //end do-while loop
        while(exitStatus == 0);
        
        if(exitStatus == 1);
        {
            JOptionPane.showMessageDialog(null, "Enjoy the rest of your day!");
            System.exit(0);
        }
        
    } //end public void getandDisplayNameDataorExit
    
    /**
     *Displays the Name data if it is a Boy or Girl based on what the
    * user enters.
     */
    public void displayData()
    {
        if (girlExists == true && boyExists == true)
        {
            JOptionPane.showMessageDialog(null, name + " is ranked " 
                                          + girlRanking + 
                                          " in popularity among Girls "
                                          + "with " + girlRegisteredBirths + 
                                          " namings\n" + name + " is "
                                          + "ranked " + boyRanking + 
                                          " in popularity among Boys with "
                                          + boyRegisteredBirths
                                          + " namings"); 
        }
                
        if (girlExists == false && boyExists == true)
        {
            JOptionPane.showMessageDialog(null, name + " is ranked " 
                                          + boyRanking + 
                                          " in popularity among Boys "
                                          + "with " + boyRegisteredBirths +
                                          " namings\n" + name + " "
                                          + "is not ranked among the top "
                                          + "1000 Girl names"); 
            
        }
                
        if (girlExists == true && boyExists == false)
        {
            JOptionPane.showMessageDialog(null, name + " is ranked " 
                                          + girlRanking + 
                                          " in popularity among Girls "
                                          + "with " + girlRegisteredBirths
                                          + " namings\n" + name + 
                                          " is not ranked among the top "
                                          + "1000 Boy names");
        }
                
        else if (girlExists == false && boyExists == false)
        {   
            JOptionPane.showMessageDialog(null, name + " is not ranked "
                                          + "among the top 1000 Girl names\n"
                                          + name + " is not ranked among " +
                                          "the top 1000 Boy names"); 
        }
                  
    } //end public void displayData()
    
} //end class PA5JODelegate
