/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 */

package pa4abstractpet;

/**
 *
 * File name:     Dog.java
 * <p>
 * Description:   Subclass that computes Drug Dosage of carprofen and 
 * acepromazine.
 *    
 * @author Campbell, Ethan
 * @version 3-March-2021 
 * @override equals and hash code from Pet ancestor
 * @override carprofen and acepromazine from Pet ancestor
 */
public class Dog extends Pet       
{
    
    /**
     *Calls Pet constructor with no arguments using super operator.
     */
    public Dog()
    {
        super();
    } //end no-arg constructor
    
    /**
     * calls the pet name constructor.
     * @param name the pet's name
     */
    public Dog(String name)
    {
        super(name);
    } //end initial name
    
    /**
     * calls the pet weight constructor.
     * @param weight the pet's weight
     */
    public Dog(double weight)
    {
        super(weight);
    } //end initial weight
    
    /**
     * Calls the pet constructor with three arguments using super operator.
     * @param name the pet's name
     * @param age the pet's age
     * @param weight the pet's weight
     */
    public Dog(String name, int age, double weight)
    {
        super(name,age,weight);
    } //end pet three argument constructor
    
    /**
     *Constructor, copies Dog object.
     * 
     * @param original the original dog that creates the new copy
     */
    public Dog(Dog original)       
    {
        super();
        
        super.setName(original.getName());
        super.setAge(original.getAge());
        super.setWeight(original.getWeight());  
        
    } //end copy constructor
    
    /**
     * calculates drug dosage of acepromazine for Dog, depending on
     * pet's weight. It also overrides the Pet class to return the proper
     * dosage.
     * @return dosageAmount as calculated with variables
     */
    @Override
    public double acepromazine()
    {
        double dosageAmount = 0;
        dosageAmount = (getWeight() / 2.2) * (0.03 /10);    
        return dosageAmount;
    } //end public double acepromazine()

    /**
     * calculates drug dosage of carprofen for Dog, depending on
     * pet's weight. It also overrides the Pet class to return the proper
     * dosage.
     * @return dosageAmount as calculated with variables
     */
    @Override
    public double carprofen()
    {
        double dosageAmount = 0;
        dosageAmount = (getWeight() / 2.2) * (0.5 /12);
        return dosageAmount;  
    } //end public double carprofen()

    /**
     * Returns a string representation of a Dog pet object. Overrides Pet class
     * to return pet type
     * 
     * @return the string containing name, age, weight, and type of pet
     */
    @Override
    public String toString ()
    {
        return ("\nPet Type: Dog\n" + super.toString());
    }  //end public String toString()    
   
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
     * creates a hashCode override/integer for Dog object.
     * @return Dog hashCode
     */
    @Override
    public int hashCode() 
    {
        return super.hashCode();
        
    } //end public int hashCode()
    
    /**
     * Dog clone() override calls the Dog copy constructor.
     * 
     * @return A deep copy of this Dog object
     */
    @Override
    public Dog clone()
    {
        return new Dog(this);
        
    } //end public dog clone
   
} // end Public class Dog extends Pet

