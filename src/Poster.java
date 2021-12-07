import Item.Item;

import java.util.ArrayList;

public interface Poster {
	// Put the item up for sale and notify customers
	abstract Post ForSale(Item item, int count);
	abstract Post ForSale(Item item);

	// Call when an item is sold
	abstract void Sold(Item item);

	void update(ArrayList<Post> itemsForSale);
}

/*
AUCTIONEER = BEBAY
SUBJECT = PUBLISHER
*/