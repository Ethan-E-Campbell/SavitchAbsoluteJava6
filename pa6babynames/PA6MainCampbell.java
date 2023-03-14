/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa6babynames;

/**
 * File name:     PA6MainCampbell.java
 * <p>
 * Uses Classes: BabyNamesModel, PA6JOController, View
 * <p>
 * Data files: boynames2020.txt, girlnames2020.txt
 * <p>
 * Description:   Main class for PA6 Baby Names assignment program in Savitch, 
 *                Walter. 
 *                2016. <i>Absolute Java</i> 6th ed. Boston:
 *                Addison-Wesley, Ch. 10, Programming Project 1 chapter 10  
 *<p>
 * This class is designed to support the Model View Controller pattern.
 *<p>
 * Finished version.
 *<p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @version 21-March-2021 
 */
public class PA6MainCampbell
{
    
    /**
     *Main method. Launches console, or GUI object, which searches for baby 
     * names and how many times they are used/frequency.
     * 
     * @param args string array for command line parameters
     */
    public static void main(String[] args)
    {
        PA6JOController controller = new PA6JOController();
        
    } //end public static void main(String[])
    
} //end public class PA6MainCampbell

