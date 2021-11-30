import Item.Item;

/*
	- Customers can post items for sale (from their inventory) and buy items from other customers (to their cart)
	- Customers will be notified (Observer) when an item is posted or sold
*/
public class Customer implements Post, Get {

	protected Cart cart;
	protected Cart inventory;
	
	protected double balance;
	
	
	// Buy item and add to cart
	@Override
	public Item Purchase(double amount) {
		return null;
	}

	// Once another customer confirms checkout, update balance and remove from inventory
	@Override
	public void Sell(Item item) {
		
		// Update Customer Balance
		//balance = balance - Item.price;
		
		// Update inventory upon checkout confirmation
		inventory.removeItem(item);
	}

	// Add item from inventory to market, and notify customers it's for sale 
	@Override
	public void ForSale(Item item) {
		
	}

}