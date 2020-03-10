/*
 * This is the IllegalPizza exception class. If any of the parameters are violated when creating a 
 * Pizza or a LineItem, this will be thrown.
 * 
 * @author Aditi Srinivasan
 * @NetID 18ars11
 */
public class IllegalPizza extends Exception {
	
	public IllegalPizza (String message) {
		super(message);
	}
	
	public IllegalPizza () {
		super("Hello! I am not a pizza!");
	}
	
}