/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa3pet;

/**
 * File name: PA3PetDelegate.java
 * <p>
 * Description: Console-based Delegate (View/Controller) class for the Pet
 * Three assignment problem.
 * <p>
 * This class is designed to support the Model-Delegate pattern.
 * <p>
 * Finished version.
 * <p>
 * @author Ethan Campbell ecampbe1@heidelberg.edu
 * @version 21-Feb-2021
 */
public class PA3PetDelegate
{
    //-------instance fields-------

    String name = "Max";
    int age = 5;
    double weight = 40;
    Pet usersPet = new Dog();

    //-------constructors-------

    /**
     * No-arg constructor
     */
    public PA3PetDelegate()
    {
        usersPet = new Dog(name,age,weight); //switch as necessary
        usersPet.set(name, age, weight);
        displayHeader();
        displayPetReport();
        displayEqualityTestHeader();  
        displayEqualityResults();
 
    }//End no-arg constructor

    //-------instance methods-------

    /**
    * Displays the title header.
    */
    public void displayHeader()
    {
        System.out.println("\n\t\tTEST OF VETINARY PET CLASS WITH "+
                           "INHERITANCE\n");
        System.out.println("Ethan Campbell");
        System.out.println("February 14, 2021");
        System.out.println("\nThis program tests drug dosage calculations based"
                           + " on a cat or dog Pet type.");

    } //end public void displayHeader()  
    
    /**
    *Displays the Pet Report, including carprofen
    *and acepromazine needed.
    */
    public void displayPetReport()
    {
        System.out.println("\n\tPET DRUG DOSAGE REPORT");
        System.out.println("\nOur Records now say that the family pet is "
                            + "registered as follows:  ");
        System.out.println(usersPet.toString());
        System.out.println(String.format("Dose of carprofen: %,.4f ", 
                           usersPet.carprofen()) + "ml.");
        System.out.println(String.format("Dose of acepromazine: %,.4f ", 
                           usersPet.acepromazine()) + "ml.");
        
    } //end public void diplayPetReport()
    
    /**
    *Displays the header for Equality Tests.
    */
    public void displayEqualityTestHeader()
    {
        System.out.println("\n\tTESTING THE COPY CONSTRUCTOR AND THE "
                 + "EQUALS OVERRIDE\n");
        System.out.println("\n First, we will create a new Pet named \"Bob\" "
                 + "and then copy Bob to a new Dog named "
                + "\"Alice\" using this copy constructor code:");
        System.out.println("\n Pet bob  =  new Dog (\"Bob\", 4, 8.0);"
                + "\n Pet alice  =  new Dog ((Dog)bob);");
        System.out.println("\nNext, we will use the equals override to see if"
                + " they have deep equality with this code: ");
        System.out.println("\nif (bob.equals(alice))"
                + "\n\t System.out.println(\"Bob and Alice are logically "
                + "the same\"); \nelse"
                + "\n\t System.out.println(\"Bob and Alice are logically "
                + "different\");");
        
    } //end public void displayEqualityTestHeader()
    
    /**
    * Displays the Equality Test Results.
    */
    public void displayEqualityResults()
    {
        System.out.println("\n\tTEST RESULTS OF COPY CONSTRUCTOR AND "
                           + "EQUALS OVERRIDE\n"); 
        
        Pet Bob = new Dog("Bob", 4, 8.0);
        Pet Alice = new Dog((Dog)Bob);
        
        if(Bob.equals(Alice))
            System.out.println("Result of deep equality check using the "
            + "equals method: Bob and Alice are logically the same");
        else
            System.out.println("Result of deep equality check using the "
            + "equals method: Bob and Alice are logically different");
        
        if(Bob == Alice)
            System.out.println("\nResult of equality  operator (==) check: "
            + "Bob and Alice are not referenced by different pointers");
        
        else
            System.out.println("\nResult of equality  operator (==) check: "
            + "Bob and Alice are referenced by different pointers"); 
        
        System.out.println("\n\tTEST RESULTS OF HASH CODE EQUALITY");
        
        Integer BobHash = Bob.hashCode();
        Integer AliceHash = Alice.hashCode();
        
        if(BobHash.equals(AliceHash))
        {
            System.out.println("\nBob hash equals Alice hash");
            System.out.println(Bob.hashCode());
            System.out.println(Alice.hashCode());
        }
        else
        {
            System.out.println("\nBob hash does not equal Alice hash");
            System.out.println(Bob.hashCode());
            System.out.println(Alice.hashCode());
        }
        
    }//end public void DisplayEqualityResults()
    


}//End public class PA3PetDelegate