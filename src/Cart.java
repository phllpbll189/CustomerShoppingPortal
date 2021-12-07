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
		ArrayList<Post> toRemove = new ArrayList<Post>();
		for (Post post : this.cart) {
			if(posts.contains(post)){
				continue;
			}else{
				toRemove.add(post);
			}
		}
		for (Post post: toRemove) {
			this.cart.remove(post);
		}
	}

	public double getPrice(){
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

}
