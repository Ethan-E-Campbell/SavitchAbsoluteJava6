/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa4abstractpet;

/**
 * File name: PA4PetDelegate.java
 * <p>
 * Description: Console-based Delegate (View/Controller) class for the Pet
 * Three assignment problem.
 * <p>
 * This class is designed to support the Model-Delegate pattern.
 * <p>
 * Finished version.
 * <p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @version 3-March-2021 
 */
public class PA4PetDelegate
{
    //-------instance fields-------

    Pet[] listOfPets = new Pet[5];
    
    //-------constructors-------

    /**
     * No-arg constructor
     */
    public PA4PetDelegate()
    {
        
        displayHeader();
        displayPetRecordList();
        displayCatEqualityTestHeader();  
        displayCatEqualityResults();
        displayCatCloneOverrideResults();
        displayDogEqualsCloneOverrideResults();
 
    }//End no-arg constructor

    //-------instance methods-------

    /**
    * Displays the title header.
    */
    public void displayHeader()
    {
        System.out.println("\n\t\tTEST OF ABSTRACT PET CLASS WITH "+
                           "INHERITANCE\n");
        System.out.println("Ethan Campbell");
        System.out.println("March 3, 2021");
        System.out.println("\nThis program tests drug dosage calculations based"
                           + " on a cat or dog Pet type.\nAlso tested:  "
                           + "equals(), hashCode(), clone(), and the copy"
                           + " constructor.");

    } //end public void displayHeader()  
    
    /**
    *Displays the Pet Records for 5 pets, including carprofen
    *and acepromazine needed.
    */
    public void displayPetRecordList()
    {

        System.out.println("\nThe pets are stored in a list.");
        

        System.out.println("\nList of cats and dogs:\n");
        listOfPets[0] = new Cat("Garfield", 10, 8.0);
        listOfPets[1] = new Cat("Garfield, Jr.", 10, 8.0);
        listOfPets[2] = new Cat("Mr. Whickers", 4, 7.0);
        listOfPets[3] = new Dog("Odie", 8, 40.0);
        listOfPets[4] = new Dog("Rex", 11, 65.0);
        
        for (int i = 0; i < listOfPets.length; i++)
        {
        
            System.out.println(listOfPets[i].toString());
            System.out.println(String.format("acepromazine: %,.5f ", 
                               listOfPets[i].acepromazine()) + "ml.");
            System.out.println(String.format("carprofen: %,.5f ", 
                               listOfPets[i].carprofen()) + "ml.");

        }
        
    } //end public void diplayPetRecordList()
    
    /**
    *Displays the header for Cat Equality Tests.
    */
    public void displayCatEqualityTestHeader()
    {
        System.out.println("***************************************");
        System.out.println("\nThis is a test of the Cat equals override.");
        System.out.println("\n Lets compare the garfield object with the "
                           + "garfieldJr object. \nFirst,"
                           + " we'll print out both objects so that we can "
                           + "see if both cats\nhave the same name, age, and "
                           + "weight. Then, we'll test the equals method.\n");
        System.out.println(listOfPets[0] + "\n");
        System.out.println(listOfPets[1]);
        
        
    } //end public void displayCatEqualityTestHeader()
    
    /**
    * Displays the Cat Equality Test Results.
    */
    public void displayCatEqualityResults()
    {
        for (int i = 0; i < 2; i++)
        {
            if(listOfPets[0].equals(listOfPets[1]))
            {
                System.out.println("The equals method says that the Garfield "
                                   + "and GarfieldJr objects have logical "
                                   + "(deep) equality.");
                System.out.println("As expected, the equals override worked"
                                   + " correctly because now the cats have "
                                   + "exactly the "
                                   + "same names, ages, and weights.\n");
            }
            else
            {
                System.out.println("\nThe equals method says that the Garfield "
                                   + "and GarfieldJr objects do not have "
                                   + "logical (deep) equality");
                System.out.println("\n As expected, the equals override worked"
                                   + " correctly because the cats have "
                                   + "different names.");
                System.out.println("\n Now let's use the Cat name setter to"
                                   + " change the garfieldJr name field to"
                                   + " \"Garfield.\" \nThat will test the "
                                   + "other branch of the equals override. ");
            }
            
            listOfPets[1].setName("Garfield");
        }    
        
    }//end public void DisplayCatEqualityResults()
    
    /**
     *Displays the Cat Clone Override Results.
     */
    public void displayCatCloneOverrideResults()
    {
        System.out.println("***************************************");
        
        System.out.println("\nThis is a test of the Cat clone override:");
        System.out.println("\nLet's clone Garfield. here's the code to create "
                           + "the clone:");
        System.out.println("\n\tCat garfieldClone = ((Cat) listOfPets[0])."
                           + "clone();");
        System.out.println("\nNow we'll print out both the garfield object"
                           + " and the garfieldClone object"
                           + " so that we can see that both cats have the same "
                           + "name, age and"
                           + " weight.\nThen, we'll use the equals method to "
                           + "prove that they are the same.");
        
        Cat garfieldClone = ((Cat) listOfPets[0]).clone();
        
        System.out.println("\nThis is the garfield object:");
        System.out.println(listOfPets[0]);
        System.out.println("\nThis is the garfieldClone object:");
        System.out.println(garfieldClone);
        System.out.println("\nLet's use the equals method to verify:");
        
        if(listOfPets[0].equals(garfieldClone))
        {
            System.out.println("Garfield and Garfield's clone are "
                               + "logically equal");
        }
        else
        {
            System.out.println("Garfield and Garfields' clone are not logically"
                               + " equal");
        }
        
    } //end public void DisplayCatCloneOverrideResults()
    
    /**
     *Displays the Dog Equality and Clone Override results.
     */
    public void displayDogEqualsCloneOverrideResults()
    {
        System.out.println("\n***************************************");
        System.out.println("\nThis is a test of the Dog equals override:");
        
        listOfPets[4].setName("Odie");
        listOfPets[4].setAge(8);
        listOfPets[4].setWeight(40.0);
        
        if(listOfPets[4].equals(listOfPets[3]))
        {
            System.out.println("the odie and odieCopy objects are logically "
                              + "(deep) equal");
        }
        else
        {
            System.out.println("the odie and odieCopy objects are logically"
                               + "different");
        }
        
        System.out.println("\nThis is a test of the Dog clone override:");

        Dog odieClone = ((Dog) listOfPets[3]).clone();
        
        if(listOfPets[3].equals(odieClone))
        {
            System.out.println("the odie and odieClone objects are logically"
                               + " equal");
        }
        else
        {
            System.out.println("the odie and odieClone objects are not"
                    + " logically equal");
        }
        
    } //end displayDogEqualsCloneOverrideResults
        

}//End public class PA4PetDelegate