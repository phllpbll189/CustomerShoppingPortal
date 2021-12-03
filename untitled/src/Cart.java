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

	public void setItems(ArrayList<Post> items) {
		this.cart = items;
	}

	//makes sure that cart reflects any changes to the posts in publisher.
	public void crossCheck(ArrayList<Post> posts) {
		for (Post post : this.cart) {
			if(posts.contains(post)){
				continue;
			}else{
				System.out.println("Someone bought my item.");
				cart.remove(post);
			}
		}
	}

	public void purchase(Customer customer){
		for (Post post : cart) {
			if(post.item.getPrice() > customer.balance){
				System.out.println("You don't have enough money!");
				return;
			}
			post.sold();
		}
	}

	public ArrayList<Post> getCart() {
		return cart;
	}

	
	/*
	public void checkout() {
		
	}
	*/
}
