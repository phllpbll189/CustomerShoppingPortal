import java.util.ArrayList;
import Item.Item;

public class Cart {

	private ArrayList<Item> cart;
	
	// Add an item to the cart
	public void addItem(Item item) {
		cart.add(item);
	}
	
	// Remove an item from the cart
	public void removeItem(Item item) {
		cart.remove(item);
	}
	
	/*
	public void checkout() {
		
	}
	*/
}
