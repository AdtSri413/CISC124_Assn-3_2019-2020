import java.io.Serializable;

/*
 * This class creates a Pizza Object with these attributes:
 * 		Size
 * 		Vegetarian
 * 		Cheese
 * 		Toppings:
 * 			Pineapple
 * 			Green Peppers
 * 			Ham
 * 
 * 	The cost of this Pizza can also be found, as well as if its the same as another Pizza. Furthermore, a String containing
 *  all the information about the Pizza can be generated.
 *  
 *  @author Aditi Srinivasan
 *  @NetID 18ars11
 */

public class Pizza implements Serializable
{
	// Enums for the size, amount of cheese and amount of toppings are created
	public enum Size {Small, Medium, Large};
	public enum Cheese {Single, Double, Triple};
	public enum Topping {None, Single};
	
	// Stores the size of the pizza
	private Size size;
	// Stores true if the pizza is vegetarian and false if not
	private boolean veg;
	// Stores the amount of cheese
	private Cheese cheese;
	// Stores the amount of pineapple
	private Topping pineapple;
	// Stores the amount of green peppers
	private Topping greenPeppers;
	// Stores the amount of ham
	private Topping ham;
	
	// Stores the price of the pizza
	private double cost = 0;
	
	
	/*
	 * Constructs a pizza with attributes size, vegetarian, cheese, pineapple, greenPeppers, and ham. Throws an
	 * exception if a vegetarian pizza has ham or if any of these attributes are null
	 */
	public Pizza(Size s, boolean v, Cheese c, Topping p, Topping g, Topping h) throws IllegalPizza
	{
		// Set all attributes
		size = s;
		veg = v;
		cheese = c;
		pineapple = p;
		greenPeppers = g;
		ham = h;
		
		// Find exceptions  Throw Illegal pizza if any of these exceptions are encountered
		if(s==null || c==null || p==null || g==null || h==null)
			throw new IllegalPizza ();
		
		// Find exceptions  Throw Illegal pizza if any of these exceptions are encountered
		if(v==true && h==Topping.Single)
			throw new IllegalPizza ("That's not a vegetarian pizza!");
	} // End constructor
	
	
	/*
	 * Constructs a pizza with attributes size, cheese, pineapple, greenPeppers, and ham. Throws an
	 * exception if any of these attributes are null. Assumes the pizza is not vegetarian
	 */
	public Pizza(Size s, Cheese c, Topping p, Topping g, Topping h) throws IllegalPizza
	{
		// Set all attributes
			size = s;
			veg = false;
			cheese = c;
			pineapple = p;
			greenPeppers = g;
			ham = h;
			
			// Find exceptions  Throw Illegal pizza if any of these exceptions are encountered
			if(s==null || c==null || p==null || g==null || h==null)
				throw new IllegalPizza ();
	} // End constructor
	
	
	/* 
	 * Constructs a default small pizza with single cheese and ham
	 */
	public Pizza()
	{
		// Set all attributes
		size = Size.Small;
		veg = false;
		cheese = Cheese.Single;
		pineapple = Topping.None;
		greenPeppers = Topping.None;
		ham = Topping.Single;
	} // end constructor
	
	
	/*
	 * Finds and returns the price of a pizza
	 */
	public double getCost()
	{
		cost = 0;
		
		// add cost of a pizza based on its size
		if(size == Size.Small)
			cost+=7;
		else if(size == Size.Medium)
			cost+=9;
		else
			cost+=11;
		
		// Add $1.50 for each extra cheese
		if(cheese == Cheese.Double)
			cost+=1.5;
		else if(cheese == Cheese.Triple)
			cost+=3;
		
		// Add $1.50 for each topping
		if(pineapple == Topping.Single)
			cost+=1.5;
		if(greenPeppers == Topping.Single)
			cost+=1.5;
		if(ham == Topping.Single)
			cost+=1.5;
		
		return cost;
	} // end getCost
	
	
	/*
	 * Constructs a string based on a pizza's attributes and cost.
	 */
	public String toString()
	{
		getCost();
		String s = "";
		
		// Add vegetarian to the string if the pizza is vegetarian
		if(veg == true)
			s="vegetarian ";
		
		// Add the size of the pizza to the string
		if(size == Size.Small)
			s="Small "+s+"pizza, ";
		else if(size == Size.Medium)
			s="Medium "+s+"pizza, ";
		else
			s="Large "+s+"pizza, ";

		// Add the amount of cheese to the string
		if(cheese == Cheese.Single)
			s+="Single cheese";
		else if(cheese == Cheese.Double)
			s+="Double cheese";
		else
			s+="Triple cheese";
		
		// Add the toppings to the string
		if(pineapple == Topping.Single)
			s+=", pineapple";
		if(greenPeppers == Topping.Single)
			s+=", green pepper";
		if(ham == Topping.Single)
			s+=", ham";
		
		// Add the price of the pizza to the string
		s+=". Cost: $"+String.format("%.2f", cost)+" each.";
		
		return s;
	} // end toString
	
	
	/*
	 * Compares one pizza to another. Returns true if they have the same attributes and price and false if not.
	 */
	public boolean equals(Object pizza1) 
	{
		if (pizza1 instanceof Pizza) 
		{
			Pizza pizza2 = (Pizza)pizza1;
			
			if(size == pizza2.size && cheese == pizza2.cheese && pineapple == pizza2.pineapple && greenPeppers == pizza2.greenPeppers && ham == pizza2.ham)
					return true;
		}
		return false;
	} // end equals
	
	
	/*
	 * Clones a pizza
	 */
	public Pizza clone() 
	{
		Pizza PClone = null;
		
		try 
		{
			PClone = new Pizza(size, veg, cheese, pineapple, greenPeppers, ham);
		}catch (IllegalPizza ip){
			
		}
		return PClone;
	} // end clone
}
