import java.io.Serializable;

/*
 * This class creates a LineItem object with the attributes:
 * 		Pizza
 * 		numPizza (Number of pizzas)
 * 
 * Provides accessors for both the pizza and the numPizza attributes. Allows numPizza to be changed. The pizzas'
 * cost is also calculated with the discount implemented. A String containing all the information about the 
 * LineItem can be generated. Furthermore, two LineItems can be compared based on their costs.
 * 
 * @Author Aditi Srinivasan
 * @NetID 18as11
 */

public class LineItem implements Comparable<LineItem>, Serializable
{

	// Stores the number of pizzas ordered
	private int numPizza = 0;
	// Stores the pizza ordered
	private Pizza pizza;
	
	
	/*
	 * Constructs a LineItem with the attributes pizza and numPizza (number of pizzas). If the Pizza provided is null,
	 * IllegalPizza is thrown.
	 */
	public LineItem(int n, Pizza p) throws IllegalPizza
	{
		// Set attributes
		setNumber(n);
		pizza = p;
		
		// Search for errors. Throw IllegalPizza if errors are found
		if(p==null)
			throw new IllegalPizza("That's not a pizza!");
	} // End constructor
	
	
	/*
	 * Constructs a LineItem with the attribute pizza. The number of pizzas is assumed to be 1. If the Pizza 
	 * provided is null, IllegalPizza is thrown.
	 */
	public LineItem(Pizza p) throws IllegalPizza
	{
		// Set attributes
		setNumber(1);
		pizza = p;
		
		// Search for errors. Throw IllegalPizza if errors are found
		if(p==null)
			throw new IllegalPizza("That's not a pizza!");
	} // End constructor
	
	
	/*
	 * accessor for the pizza attribute
	 */
	public Pizza getPizza()
	{
		return pizza;
	} // End getPizza
	
	
	/*
	 * Set the number of pizzas ordered to an integer between 1-100
	 */
	public void setNumber(int i) throws IllegalPizza
	{
		if(i<1 || i>100)
			throw new IllegalPizza ("Illegal number of pizzas!!!");
		
		numPizza=i;
	} // End numPizza
	
	
	/*
	 * Accessor for numPizza (number of pizzas)
	 */
	public int getNumber()
	{
		return numPizza;
	} // End getNumber
	
	
	/*
	 * Finds the cost of the LineItem with the discount for bulk ordering if applicable
	 */
	public double getCost()
	{
		double cost;
		
		if(numPizza>=10 && numPizza<=20)
			cost = 0.9*numPizza*pizza.getCost();
		
		else if(numPizza>20)
			cost = 0.85*numPizza*pizza.getCost();
		
		else
			cost = numPizza*pizza.getCost();
		
		return cost;
	} // End getCost
	
	
	/*
	 * Generates a String of all the attributes
	 */
	public String toString() {
		
		if(numPizza<10)
			return " "+numPizza+" "+pizza;
		else
			return numPizza+" "+pizza;
	} // end toString
	
	
	/*
	 * Compare the price of 2 LineItems. Return the difference between the prices.
	 */
	public int compareTo(LineItem lt)
	{
		int compare = (int)(lt.getCost() - getCost());
		return compare;
	} // End compareTo
}
