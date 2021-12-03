import Item.Item;

public interface Poster {
	// Put the item up for sale and notify customers
	abstract Post ForSale(Item item);
	
	// Call when an item is sold
    abstract void Sold(Item item);
}



/*

AUCTIONEER = BEBAY
SUBJECT = PUBLISHER
BIDDER = POSTER

*/