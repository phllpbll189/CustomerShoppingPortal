import Item.Item;

public abstract class Poster {
	Poster() {
		this.postings = new Cart();
	}

	protected Cart postings;
	
	// Put the item up for sale and notify customers
	abstract void ForSale(Item item);
	
	// Call when an item is sold
    abstract void Sell(Item item);
}



/*

AUCTIONEER = BEBAY
SUBJECT = PUBLISHER
BIDDER = POSTER

*/