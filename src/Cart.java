/*
Author: Zachary Jones and Phil Bell (We mostly worked on Cart together. Phil completed crossCheck() method.)
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

import java.util.ArrayList;

public class Cart {
	private ArrayList<Post> cart = new ArrayList<Post>();

	// Add an item to the cart
	public void addItem(Post item) {
		cart.add(item);
	}

	// Remove an item from the cart
	public void removeItem(Post item) {
		cart.remove(item);
	}

	//makes sure that cart reflects any changes to the posts in publisher.
	public void crossCheck(ArrayList<Post> posts) {
		ArrayList<Post> toRemove = new ArrayList<Post>();
		
		// Keep the posts currently within the cart
		for (Post post : this.cart) {
			if(posts.contains(post)) {
				continue;
			} else { 
				toRemove.add(post);
			}
		}
		// Any posts not within the cart remove
		for (Post post: toRemove) {
			this.cart.remove(post);
		}
	}

	/* ---- Setters and Getters ---- */
	
	public double getPrice() {
		int temp = 0;
		for (Post post:
				cart) {
			temp += post.item.getPrice();
		}
		return temp;
	}

	public ArrayList<Post> getCart() {
		return cart;
	}

	public void setItems(ArrayList<Post> items) {
		this.cart = items;
	}
}
