import java.util.ArrayList;
import Item.Component;

public class Cart {
	private ArrayList<Object> cart;
	
	// Add an item to the cart
	public void addItem(Component item) {
		cart.add(item);
	}
	
	// Remove an item from the cart
	public void removeItem(Component item) {
		cart.remove(item);
	}
	
	/*
	public void checkout() {
		
	}
	*/
}
