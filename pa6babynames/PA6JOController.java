/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa6babynames;

/**
 * File name: PA6JOController.java
 * <p>
 * Description: Controller class for the PA6 Baby Names assignment problem.
 * <p>
 * This class is designed to support the Model View Controller pattern.
 * <p>
 * Finished version.
 * <p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @version 21-March-2021 
 */
public class PA6JOController
{
    //-------instance fields-------
    
    BabyNamesModel nameSearch = new BabyNamesModel();
    View viewer = new View();
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
    public PA6JOController()
    {
        name = "none yet";
        boyRegisteredBirths = 0;
        boyRanking = 0;
        girlRegisteredBirths = 0;
        girlRanking = 0;
        girlExists = true;
        boyExists = true;
        this.sortTop20();
        this.getNameDataorExit();

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
            
            name = viewer.displayandGetNameInput();
            name = name.toLowerCase(); //makes sure all input is lowercase
        
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
        
        if(exitStatus == 1); //displays exit screen and exits
        {
            viewer.exitSequence();
            System.exit(0);
        }
        
    } //end public void getNameDataorExit
    
    /**
     * Prompts Viewer to display 
     * the Name data if it is a Boy or Girl based on what the user enters.
     *
     */
    public void displayData()
    {
        if (girlExists == true && boyExists == true)
        {
            viewer.girlAndBoyExists(name,girlRanking,girlRegisteredBirths,
                                    boyRanking,boyRegisteredBirths);
        }
                
        if (girlExists == false && boyExists == true)
        {
            viewer.boyExists(name,boyRanking,boyRegisteredBirths);
        }
                
        if (girlExists == true && boyExists == false)
        {
            viewer.girlExists(name,girlRanking,girlRegisteredBirths); 
        }
                
        else if (girlExists == false && boyExists == false)
        {   
            viewer.neitherExists(name);
        }
                  
    } //end public void displayData()
    
    /**
     *Prompts the viewer to display the top 20 Girl names in ascending order.
     * 
     */
    public void sortTop20()
    {
        for(int i = 0; i < (nameSearch.sortGirlList()).size(); i++) 
        {
            viewer.topTwentyGirlNames(nameSearch.sortGirlList().get(i));
        }

    } //end public void sortTop20()
    
} //end class PA6JODelegate
