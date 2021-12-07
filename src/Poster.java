/*
Author: Zachary Jones (Responsible for Subscriber portion of Observer Pattern)
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

import Item.Item;
import java.util.ArrayList;

// This is the subscriber for the Observer Pattern
public interface Poster {
	// Put the item up for sale and notify customers
	abstract Post ForSale(Item item, int count);
	abstract Post ForSale(Item item);

	// Call when an item is sold
	abstract void Sold(Item item);

	void update(ArrayList<Post> itemsForSale);
}
