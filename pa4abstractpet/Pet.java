/*
 * CPS 202
 * Spring 2021
 * Dr. Close
 * Ethan Campbell -Student
 * Code created by:
 * Savitch, Walter. 2016. Absolute Java. 6th ed. Boston: Addison-Wesley. 
 * ISBN: 0-134-24393-5; 978-
 * 0134041674 
 */

package pa4abstractpet;

/**
 *
 * File name:     Pet.java
 * <p>
 * Description:   Program that computes Drug Dosage of carprofen and 
 * acepromazine based on input. This is also done using subclasses.
 *    
 * @author Savitch, Walter. Heavily modified by Campbell, Ethan to include
 * subclasses as well as drug doses for certain drugs. Also declared Abstraction
 * @version 3-March-2021 
 * @override equals and hash code from object ancestor
 */
public abstract class Pet
{ 
    //-------instance fields-------
    
    private String name;
    private int age;//in years
    private double weight;//in pounds
    
    //-------constructors-------
    
    /**
     * No-arg constructor.
     */ 
    public Pet()
    {
        name = "no name";
        age = 1;
        weight = 1; 
    } //end no-arg constructor
    
    /**
     * Constructor, initializes pet name
     * 
     * @param initialName 
     */ 
    public Pet(String initialName)
    {
        name = initialName;
        age = 0;
        weight = 0;
    } //end initialName
    
    /**
     * Constructor, initializes pet age.
     * 
     * @param initialAge
     */ 
    public Pet(int initialAge)
    {
        name = "No name yet.";
        weight = 0;
        if (initialAge < 0)
        {
            System.exit(0);
        }
        else
            age = initialAge;
    } //end initialAge
    
    /**
     * Constructor, initializes pet weight.
     * 
     * @param initialWeight
     */
    public Pet(double initialWeight)
    {
        name = "No name yet";
        age = 0;
        if (initialWeight < 0)
        {
            System.exit(0);
        }
        else
            weight = initialWeight;
    } //end initalWeight
    
    /**
     * Constructor, sets name, age, weight
     * 
     * @param initialWeight pet's weight
     * @param initialAge    pet's age
     * @param initialName   pets name
     */
    public Pet(String initialName, int initialAge, 
                                          double initialWeight)
    {
        name = initialName;
        if ((initialAge < 0) || (initialWeight < 0))
        {
            System.exit(0);
        }
        else
        {
            age = initialAge;
            weight = initialWeight;
        }
      
    } //end public Pet
    
    /**
     *Constructor, copies object.
     */
    public Pet(Pet original)
    {
        if (original == null)
        {
            System.exit(0);
        }
        
        name = original.name;
        age = original.age;
        weight = original.weight;
        
    } //end public Pet copy constuctor
    
    //-------instance methods-------
    
    /**
     * sets name, age, and weight.
     * 
     * @param newName pet's name
     * @param newAge pet's age
     * @param newWeight pet's weight
     */
    public void set(String newName, int newAge, double newWeight) 
    {
        name = newName;

        if ((newAge < 0) || (newWeight < 0))
        {
            System.exit(0);
        }
        else
        {
            age = newAge;
            weight = newWeight;
        }
    } //end of public void set
    
    /**
     * sets new name
     * 
     * @param newName the pet's name
     */ 
    public void setName(String newName)
    {
        name = newName; 
        
    } //end public void setName

    /**
     * sets pet age
     * 
     * @param newAge pet's age
     */
    public void setAge(int newAge)
    {
        if (newAge < 0)
        {
            System.exit(0);
        }
        else
            age = newAge;
    } //end public void setAge
    
    /**
     * sets pet's weight
     * 
     * @param newWeight pet's weight
     */
    public void setWeight(double newWeight)
    {
        if (newWeight < 0)
        {
            System.exit(0);
        }
        else
            weight = newWeight;
    } //end public void setWeight
    
    /**
     * Returns the pet's name.
     * 
     * @return the pet's name.
     */
    public String getName()
    {
        return name;
    } //end public String getName()
    
    /**
     * Returns the pet's age.
     * 
     * @return the pet's age.
     */
    public int getAge()
    {
        return age;
    } //end public int getAge()

    /**
     * Returns the pet's weight.
     * 
     * @return the pet's weight
     */
    public double getWeight()
    {
        return weight;
    } //end public double getWeight()
    
    /**
     * calculates drug dosage of acepromazine for dog or cat and depending on
     * pet's weight.
     * 
     * @return acepromazine as zero
     */
    public abstract double acepromazine(); //end public double acepromazin
    //end public double acepromazin
    
    /**
     * calculates drug dosage of carprofen for dog or cat and depending on
     * pet's weight
     * 
     * @return nothing. This is an abstraction
     */
    public abstract double carprofen(); //end public double carprofen
    //end public double carprofen
    
    /**
     * Returns a string representation of a pet object
     * 
     * @return nothing. This is an abstraction
     */
    @Override
        public String toString()
    {
        return ("Name: " + name + " \nAge: " + age + " years"
                + "\nWeight: " + weight + " pounds");
    } //end public string toString()
        
    /**
     *Overrides equals method from Object ancestor to do a deep equality
     * check.
     * 
     * @param otherObject Pet object that is compared for deep equality
     * @return True or False
     */
    @Override
    public boolean equals(Object otherObject)
    {
        if(this == otherObject) //self identity check
        {
            return true; 
        }
      
        if(otherObject == null) //null check
        {
            return false;
        }
      
        if(getClass() != otherObject.getClass()) //same class check
        {
            return false;
        }
      
        final Pet tempPet = (Pet) otherObject;
        return (this.age == tempPet.age
        && new Double(weight).equals (tempPet.weight)
        && this.name.equals(tempPet.name));
        
    } // end public boolean equals    

    /**
     * creates a hashCode override/integer for Pet object.
     * @return Pet hashCode
     */
    @Override
    public int hashCode() 
    {
        int hash = 7;            
           
        hash = 59 * hash + name.hashCode();     
        hash = 59 * hash + age;
        hash = 59 * hash +  Double.hashCode(weight);        
                
        return hash;
        
    }//End public int hashCode()
        


} //end of public class Pet
