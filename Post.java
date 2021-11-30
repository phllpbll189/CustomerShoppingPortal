import Item.Item;

public interface Post {
	
	// Put the item up for sale
	void ForSale(Item item);
	
	// Call when an item is sold
    void Sell(Item item);
}
