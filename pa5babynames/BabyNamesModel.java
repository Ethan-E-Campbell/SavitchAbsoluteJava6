/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa5babynames;

import java.io.*;

import java.util.Arrays;

/**
 * File name: BabyNamesModel.java
 * <p>
 * Description: Data model for the PA5 Baby Names assignment
 * problem.
 * <p>
 * This class is designed to support the Model-Delegate pattern.
 * <p>
 * Finished Version
 * <p>
 * @author Ethan Campbell
 * @version 13-Mar-2021
 */
public class BabyNamesModel 
{
    
    private String[] boyNames;
    private String[] girlNames;
    
    private int[] boyFrequency;
    private int[] girlFrequency;
    
    /**
     * No-arg constructor
     */ 
    public BabyNamesModel()
    {
        boyNames = new String[1000];
        girlNames = new String[1000];
        boyFrequency = new int[1000];
        girlFrequency = new int[1000];
        
    }//End no-arg constructor
    
    /**
     * Reads .txt file and puts it into Arrays for easy access.
     * 
     * @param nameOfFile file passed in to read
     */ 
    public void readFile(String nameOfFile)
    {
        String[] names = new String[1000];
        int[] count = new int[1000];
        try
        {
            String line = null;
            int counter = 0;
            BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
            while((line = br.readLine())!= null)
            {
                String data[] = line.split(" ");
                names[counter] = data[0];
                names[counter] = names[counter].toLowerCase();
                count[counter] = Integer.parseInt(data[1]);
                counter++;
                
                
            }
            
            if(nameOfFile == "boynames.txt")
            {
                this.boyNames = names;
                this.boyFrequency = count;
            }
            else
            {
                this.girlNames = names;
                this.girlFrequency = count;
            }
            
            br.close();
            
            
        } //end of try block
   
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }
        
        catch (IOException e)
        {
            System.out.println("IO Exception");
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
        if(Arrays.asList(this.boyNames).contains(name))
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
        if(Arrays.asList(this.girlNames).contains(name))
        {
            return 1;
        }
        else
        {
            return -1;
        }

    } //end public int verifyGirnNameData
    
    /**
     * Returns the ranking of the boy name provided.
     * @param name the name that the user provided
     * @return the ranking of the provided boy name
     */
    public int getBoyIndexofName(String name)
    {
        int boyIndex = Arrays.asList(this.boyNames).indexOf(name);
        
        return (boyIndex + 1);
        
    } // public int getBoyIndexofNames
    
    /**
     * Calculates the registered births for the provided boy name.
     * @param name is the name that the user provided.
     * @return the number of births of boy in the US.
     */
    public int getBoyRegisteredBirths(String name)
    {
        int boyIndex = Arrays.asList(this.boyNames).indexOf(name);
        int boyRegisteredBirths = boyFrequency[boyIndex];
        
        return boyRegisteredBirths;
        
    } //end public int getBoyRegisteredBirths
    
    /**
     * Returns the ranking of the girl name provided.
     * @param name the name that the user provided
     * @return the ranking of the provided girl name
     */
    public int getGirlIndexofName(String name)
    {
        int girlIndex = Arrays.asList(this.girlNames).indexOf(name);
        
        return (girlIndex + 1);
        
    } //end public int getGirlIndexofName
    
    /**
     * Calculates the registered births for the provided girl name.
     * @param name is the name that the user provided.
     * @return the number of births of girl in the US.
     */
    public int getGirlRegisteredBirths(String name)
    {
        int girlIndex = Arrays.asList(this.girlNames).indexOf(name);
        int girlRegisteredBirths = girlFrequency[girlIndex];
        
        return girlRegisteredBirths;
        
    } //end public int getGirlRegisteredBirths
    
} //end public class BabyNamesModel
