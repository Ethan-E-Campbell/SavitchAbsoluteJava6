/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa6babynames;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * File name: BabyNamesModel.java
 * <p>
 * Description: Data model for the PA6 Baby Names assignment
 * problem.
 * <p>
 * This class is designed to support the Model View Controller pattern.
 * <p>
 * Finished Version
 * <p>
 * @author Ethan Campbell
 * @version 21-Mar-2021
 */
public class BabyNamesModel 
{
    
    private List<String> boyNames;
    private List<String> girlNames;
    
    private List<Integer> boyFrequency;
    private List<Integer> girlFrequency;
    
    private List<String> combinedGirlList;
    
    /**
     * No-arg constructor
     */ 
    public BabyNamesModel()
    {
        boyNames = new ArrayList<>(1000);
        girlNames = new ArrayList<>(1000);
        boyFrequency = new ArrayList<>(1000);
        girlFrequency = new ArrayList<>(1000);
        combinedGirlList = new ArrayList<>(1000);
        
        this.readFile("boynames2020.txt");
        this.readFile("girlnames2020.txt");
        
    }//End no-arg constructor
    
    /**
     * Reads .txt file and puts it into ArrayLists for easy access.
     * 
     * @param nameOfFile file passed in to read
     */ 
    public void readFile(String nameOfFile)
    {
        List<String> names = new ArrayList<>(1000);
        List<Integer> count = new ArrayList<>(1000);
        List<String> girlCombined = new ArrayList<>(1000);
        
        Scanner inputStream = null;
        
        try
        {
            inputStream = new Scanner(new FileInputStream(nameOfFile));       
            String line = null;
            int counter = 0;
            while(inputStream.hasNextLine())
            {
                line = inputStream.nextLine();
                girlCombined.add(line); //this is the combined list for bonus
                
                List<String> targetList = Arrays.asList(line.split(" "));
                
                targetList.set(0,(targetList.get(0)).toLowerCase());
                
                names.add(targetList.get(0)); 
                
                count.add(Integer.parseInt(targetList.get(1)));                
                counter++;

            }
            
            if(nameOfFile == "boynames2020.txt")
            {
                this.boyNames = names;
                this.boyFrequency = count;
            }
            else
            {
                this.combinedGirlList = girlCombined;
                this.girlNames = names;
                this.girlFrequency = count;
            }
            
            inputStream.close();
            
        } //end of try block
   
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }
        
    } //end public void readFile()
    
    /**
     * Checks to see if the name provided is within the boy array.
     *
     * @param name is the name that the user provided
     * @return 1 if the name is in the data, return -1 if the name is not
     */
    public int verifyBoyNameData(String name)
    {
        if(boyNames.contains(name))
        {
            return 1;
        }
        else
        {
            return -1;
        }
        
    } //public int verifyBoyNames
    
    /**
     * checks to see if the name provided is within the girl array.
     * @param name the name that the user provided
     * @return 1 if the name is in the data, return -1 if the name is not
     */
    public int verifyGirlNameData(String name)
    {
        if(girlNames.contains(name))
        {
            return 1;
        }
        else
        {
            return -1;
        }

    } //end public int verifyGirlNameData
    
    /**
     * Returns the ranking of the boy name provided.
     * @param name the name that the user provided
     * @return the ranking of the provided boy name
     */
    public int getBoyIndexofName(String name)
    {
        return (boyNames.indexOf(name) + 1);
        
    } // public int getBoyIndexofNames
    
    /**
     * Calculates the registered births for the provided boy name.
     * @param name is the name that the user provided.
     * @return the number of births of boy in the US.
     */
    public int getBoyRegisteredBirths(String name)
    {
        int boyRegisteredBirths = boyFrequency.get(boyNames.indexOf(name));
        
        return boyRegisteredBirths;
        
    } //end public int getBoyRegisteredBirths
    
    /**
     * Returns the ranking of the girl name provided.
     * @param name the name that the user provided
     * @return the ranking of the provided girl name
     */
    public int getGirlIndexofName(String name)
    {
        return (girlNames.indexOf(name) + 1);
        
    } //end public int getGirlIndexofName
    
    /**
     * Calculates the registered births for the provided girl name.
     * @param name is the name that the user provided.
     * @return the number of births of girl in the US.
     */
    public int getGirlRegisteredBirths(String name)
    {
        int girlRegisteredBirths = girlFrequency.get(girlNames.indexOf(name));
        
        return girlRegisteredBirths;
        
    } //end public int getGirlRegisteredBirths
    
    /**
     * Sorts and returns the list of top 20 Girls in ascending order, 
     * as well as the birth rate of said girls.
     * 
     * @return a list containing the first 20 girl names in ascending order 
     */
    public List sortGirlList()
    {
        List<String> containstop20girls = new ArrayList<>(1000);
        Collections.sort(combinedGirlList);
        int counter = 0;
        while (counter < 20)
            {
                containstop20girls.add(combinedGirlList.get(counter));
                counter++;
            }
        
        return containstop20girls;
        
    } //end public List sortGirlList()
    
} //end public class BabyNamesModel
