/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */
package pa6babynames;

import javax.swing.JOptionPane;

/**
 * File name: View.java
 * <p>
 * Description: View class for the PA6 Baby Names assignment problem.
 * <p>
 * This class is designed to support the Model View Controller pattern.
 * <p>
 * Finished version.
 * <p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @version 21-March-2021 
 */
public class View 
{
    
    /**
     * prompts user for name.
     * 
     * @return the name that is inputted.
     */
    public String displayandGetNameInput()
    {
        String name = JOptionPane.showInputDialog("Enter a baby name or "
                                                  + "enter Q to exit!");  
        
        return name; 
    } //end public String displayandGetNameInput()
    
    /**
     * Displays message that boy and girl exists within data.
     * 
     * @param name name passed to view from delegate
     * @param girlRanking raking/index within girl names, passed to view
     * @param girlRegisteredBirths amount of girl births, passed to view
     * @param boyRanking ranking/index within boy names, passed to view
     * @param boyRegisteredBirths amount of boy births, passed to view
     */
    public void girlAndBoyExists(String name, int girlRanking, 
                                 int girlRegisteredBirths,
                                 int boyRanking, int boyRegisteredBirths)
    {
        JOptionPane.showMessageDialog(null, name + " is ranked " 
                                      + girlRanking + 
                                      " in popularity among Girls "
                                      + "with " + girlRegisteredBirths + 
                                      " namings.\n" + name + " is "
                                      + "ranked " + boyRanking + 
                                      " in popularity among Boys with "
                                      + boyRegisteredBirths
                                      + " namings.");    
    } //end public void girlAndBoyExists
    
    /**
     * Displays message that boy exists within data.
     * 
     * @param name name passed to view from controller
     * @param boyRanking ranking/index, passed to view
     * @param boyRegisteredBirths amount of births, passed to view
     */
    public void boyExists(String name, int boyRanking, int boyRegisteredBirths)
    {
        JOptionPane.showMessageDialog(null, name + " is ranked " 
                                      + boyRanking + 
                                      " in popularity among Boys "
                                      + "with " + boyRegisteredBirths +
                                      " namings.\n" + name + " "
                                      + "is not ranked among the top "
                                      + "1000 Girl names."); 
    } //end public void boyExists
    
    /**
     * Displays message that girl exists.
     * 
     * @param name name passed to view from controller
     * @param girlRanking ranking/index, passed to view
     * @param girlRegisteredBirths amount of births, passed to view
     */
    public void girlExists(String name, int girlRanking, 
                           int girlRegisteredBirths)
    {
        JOptionPane.showMessageDialog(null, name + " is ranked " 
                                      + girlRanking + 
                                      " in popularity among Girls "
                                      + "with " + girlRegisteredBirths
                                      + " namings.\n" + name + 
                                      " is not ranked among the top "
                                      + "1000 Boy names.");
        
    } //end public void girlExists
    
    /**
     * Displays neither boy nor girl exists message.
     * 
     * @param name name, passed to view
     */
    public void neitherExists(String name)
    {
        JOptionPane.showMessageDialog(null, name + " is not ranked "
                                      + "among the top 1000 Girl names.\n"
                                      + name + " is not ranked among " +
                                      "the top 1000 Boy names."); 
        
    } //end public void neitherExists
    
    /**
     * Displays exit message.
     */
    public void exitSequence()
    {
        JOptionPane.showMessageDialog(null, "Enjoy the rest of your day!");
        
    } //end public void exitSequence()
    
    /**
     * displays the top 20 girl names in the console output.
     * @param name
     */
    public void topTwentyGirlNames(Object name)
    {
        System.out.println(name);
        
    } //end public void topTwentyGirlNames
    
} //end public class view
