/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa5babynames;

/**
 * File name:     PA5MainCampbell.java
 * <p>
 * Uses Classes: BabyNamesModel, BabyNamesConsolDelegate
 * <p>
 * Data files: boynames.txt, girlnames.txt
 * <p>
 * Description:   Main class for PA5 Baby Names assignment program in Savitch, 
 *                Walter. 
 *                2016. <i>Absolute Java</i> 6th ed. Boston:
 *                Addison-Wesley, Ch. 10, Programming Project 1 chapter 10  
 *<p>
 * This class is designed to support the Model-Delegate pattern.
 *<p>
 * Finished version.
 *<p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @version 12-March-2021 
 */
public class PA5MainCampbell
{
    
    /**
     *Main method. Launches console, or GUI object, which searches for baby 
     * names and how many times they are used/frequency.
     * 
     * @param args string array for command line parameters
     */
    public static void main(String[] args)
    {
        //BabyNamesConsoleDelegate delegate = new BabyNamesConsoleDelegate();
        PA5JODelegate delegate = new PA5JODelegate();
        
    }//end public static void main(String[])
    
} //end class PA5MainCampbell

