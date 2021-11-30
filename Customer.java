import Item.Item;

/*
	- Customers can post items for sale (from their inventory) and buy items from other customers (to their cart)
	- Customers will be notified (Observer) when an item is posted or sold
*/
public class Customer extends Poster {
	protected Cart cart;
	
	protected double balance;
	
	
	public Item Purchase(double amount) {
		return null;
	}

	// Once another customer confirms checkout, update balance and remove from inventory
	@Override
	public void Sell(Item item) {
		
		// Update Customer Balance
		//balance = balance;
		
		// Update inventory upon checkout confirmation
		postings.removeItem(item);
	}

	// Add item from inventory to market, and notify customers it's for sale 
	@Override
	public void ForSale(Item item) {
		
	}


}