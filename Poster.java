import java.security.PrivilegedAction;
import java.util.ArrayList;

import Item.Item;

public abstract class Poster {
	Poster(){
		this.postings = new Cart();
	}

	protected Cart postings;

	// Put the item up for sale
	abstract void ForSale(Object item);
	
	// Call when an item is sold
    abstract void Sell(Object item);
}
