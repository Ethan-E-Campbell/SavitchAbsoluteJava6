/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa3pet;

/**
 *
 * File name:     Cat.java
 * <p>
 * Description:   Subclass that computes Drug Dosage of carprofen and 
 * acepromazine.
 *    
 * @author Campbell, Ethan
 * @version 21-Feb-2021 
 * @override equals and hash code from Pet ancestor
 * @override carprofen and acepromazine from Pet ancestor
 */
public class Cat extends Pet       
{
    
    /**
     *Calls Pet constructor with no arguments using super operator.
     */
    public Cat()
    {
        super();
    } //end no-arg constructor
    
    /**
     * calls the pet name constructor.
     * @param name the pet's name
     */
    public Cat(String name)
    {
        super(name);
    } //end initial name
    
    /**
     * calls the pet weight constructor.
     * @param weight the pet's weight
     */
    public Cat(double weight)
    {
        super(weight);
    }//end initial weight
    
    /**
     * Calls the pet constructor with three arguments using super operator.
     * @param name the pet's name
     * @param age the pet's age
     * @param weight the pet's weight
     */
    public Cat(String name, int age, double weight)
    {
        super(name,age,weight);
    }  //end pet three argument constructor
    
    /**
     *Constructor, copies Cat object.
     * 
     * @param original
     */
    public Cat(Cat original)       
    {
        super();
        
        if (original == null)
        {
            System.out.println("fatal error");
            System.exit(0);
        }

        original.setAge(getAge());
        original.setName(getName());
        original.setWeight(getWeight());        
    } //end copy constructor
    
    /**
     * calculates drug dosage of acepromazine for Cat, depending on
     * pet's weight. It also overrides the Pet class to return the proper
     * dosage.
     * @return dosageAmount as calculated with variables
     */
    @Override
    public double acepromazine()
    {
        double dosageAmount = 0;
        
        dosageAmount = (getWeight() / 2.2) * (0.002/10);
            
        return dosageAmount;
    }//end public double acepromazine
    
    /**
     * calculates drug dosage of carprofen for Cat, depending on
     * pet's weight. It also overrides the Pet class to return the proper
     * dosage.
     * @return dosageAmount as calculated with variables
     */
    @Override
    public double carprofen()
    {
        double dosageAmount = 0;
        
        dosageAmount = (getWeight() / 2.2) * (0.25/12);

        return dosageAmount;  
    } //end public double carprofen()

    /**
     * Returns a string representation of a Cat pet object. Overrides Pet class
     * to return pet type
     * 
     * @return the string containing name, age, weight, and type of pet
     */
    @Override
    public String toString ()
    {
        return (super.toString()
                + "\nPet Type: Cat");
    } //end public String toString()
   
    /**
     *Overrides equals method from Pet class to do a deep equality
     * check.
     * 
     * @param otherObject Pet object that is compared for deep equality
     * @return True or False
     */
    @Override
    public boolean equals(Object otherObject)
    {
        if(!super.equals(otherObject))
            return false;
        else
            return true;
    } //end public boolean equals
    
    /**
     * creates a hashCode override/integer for Cat object.
     * @return Cat hashCode
     */
    @Override
    public int hashCode() 
    {     
        int hash = 7;
        return hash;
    } //end public int hashCode()
   
} // end public class Cat extends Pet
