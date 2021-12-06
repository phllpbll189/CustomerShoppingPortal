import java.util.ArrayList;
import Item.Item;

/*
	- Customers can post items for sale (from their inventory) and buy items from other customers (to their cart)
	- Customers will be notified (Observer) when an item is posted or sold
*/
public class Customer implements Poster{
    private Cart cart = new Cart();
    private String username;
    protected double balance;
    public ArrayList<Post> posts;

    Customer(String user, double balance){
        this.username = user;
        this.balance = balance;
    }

    // See if everything in the users cart is an adequate price
    public Boolean Purchasable() {
        if(cart.getPrice() > balance){
            System.out.println("You don't have enough money!");
            return false;
        }
        return true;
    }

    //purchase a single item and
    //let the publisher know the item has been claimed
    public Boolean Purchase(Post post){
        //returns true or false based on if the purchase was possible

        double price = post.sold();

        if( price != 0.00 ){
            System.out.println("you purchased " + post.item.getName());
            this.balance = balance - price;
            return true;
        }
        return false;
    }


    //Add to cart and purchase all from cart functions
    public void addToCart(int index){
        if(index <= posts.size()-1){
            Post post = posts.get(index);
            cart.addItem(post);
            System.out.println("added " + post.item.getName() + " to " + username + "'s cart");
        }

    }

    //purchases all of the items in the cart
    public void purchaseAllCart(){
        ArrayList<Post> toPurchase = cart.getCart();
        System.out.println(username + ": buying all from cart");
        if(!Purchasable()){
            return;
        }

        for(int i = 0; i <= toPurchase.size() - 1; i++){
            if( Purchase(toPurchase.get(i)) ){
                i--;
            }
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
        cart.crossCheck(itemsForSale);
    }
}