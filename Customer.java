import java.util.ArrayList;
import Item.Item;

/*
	- Customers can post items for sale (from their inventory) and buy items from other customers (to their cart)
	- Customers will be notified (Observer) when an item is posted or sold
*/
public class Customer implements Poster{
    private Cart cart = new Cart();
    private Publisher pub;
    private String username;
	protected double balance;
    public ArrayList<Post> posts;

	Customer(String user, double balance, Publisher pub){
        this.username = user;
        this.balance = balance;
        this.pub = pub;
    }
	// Buy item and add to cart
	public void Purchase(Post post) {
		if(post.item.getPrice() > balance){
            System.out.println("You don't have enough money!");
            return;
        }
        if(pub.Purchase(post)){
            System.out.println("you purchased" + post.item.getName());
            this.balance = balance - post.item.getPrice();
            return;
        }
	}


    //Add to cart and puchase all from cart functions
    public void addToCart(int index){
        if(index <= posts.size()-1){
            Post post = posts.get(index);
            cart.addItem(post);
            System.out.println("added " + post.item.getName() + " to " + username + "'s cart");
        }
       
    }

    public void purchaseAllCart(){
        System.out.println(username + ": buying all from cart");
        for (Post post : cart.getCart()) {
            Purchase(post);
        }
        
    }

    //============================= POSTER OVERRIDES =============================================================================
   //creates a post to be sent to the publisher
    @Override
    public Post ForSale(Item item) {
        System.out.println(username + ": Making a sale");
        return new Post(this, item);
    }

    //if our item was sold then this will be called
    @Override
    public void Sold(Item item) {
        //sell the item
        this.balance += item.getPrice();
        System.out.print(username + ": your item " + item.getName() + " was sold\nYour balance is now: " + balance +"\n");
    }

    //everytime there is a new post this is called
    public void update(ArrayList<Post> itemsForSale) {
        System.out.println(username + ": sales updated");
        this.posts = itemsForSale;
        cart.crossCheck(this.posts);
    }
}