/*
Author: Zachary Jones (Responsible for Subscriber portion of Observer Pattern)
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

import java.util.ArrayList;
import Item.Item;

public class Customer implements Poster {
	
	// List of items for sale managed by Publisher
    public ArrayList<Post> posts;

    // Customers items to purchase 
    private Cart cart = new Cart();
    private String username;
 
    protected double balance;

    // Constructor
    Customer(String user, double balance){
        this.username = user;
        this.balance = balance;
    }

    // See if everything in the users cart is an adequate price
    // Returns true if customer has the funds to purchase item
    public Boolean Purchasable() {
        if (cart.getPrice() > balance){
            System.out.println("You don't have enough money!");
            return false;
        }
        return true;
    }

    // Returns true or false based on if the purchase was possible
    // Purchase a single item and update customer funds. Publisher updates the carts
    public Boolean Purchase(Post post) {

        double price = post.sold();

        if ( price != 0.00 ){
            this.balance = balance - price;
            return true;
        }
        
        return false;
    }

    // Add to cart and purchase all from cart functions
    public void addToCart(int index){
        if (index <= posts.size()-1){
            Post post = posts.get(index);
            cart.addItem(post);
            System.out.println("added " + post.item.getName() + " to " + username + "'s cart");
        }

    }

    // Purchases all of the items in the cart if the user has the funds
    public void purchaseAllCart(){
        ArrayList<Post> toPurchase = cart.getCart();
        
        // Check user's funds
        if (!Purchasable()){
            return;
        }

        // Loop through the purchased items
        for(int i = 0; i <= toPurchase.size() - 1; i++){
            Post temp = toPurchase.get(i);
            System.out.println(username + " bought: " + temp.item.getName());
            // If if user has funds
            if (Purchase(temp)){
            	// Keep looping through the collection if theres multiple items
                if ((temp instanceof PPost && ((PPost) temp).count <= 1) || temp instanceof SPost){
                    i--;
                }
            }
        }

    }

    //============================= POSTER OVERRIDES =============================================================================
    
    // Creates a post to be sent to the publisher
    @Override
    public Post ForSale(Item item, int count) {
        System.out.println(username + ": Making a large offer");
        return new PPost(this, item, count);
    }

    public Post ForSale(Item item) {
        System.out.println(username + ": Making a new offer");
        return new SPost(this, item);
    }

    // If our item was sold then this will be called
    @Override
    public void Sold(Item item) {
        //sell the item
        this.balance += item.getPrice();
        System.out.print(username + ": your item " + item.getName() + " was sold\nYour balance is now: " + balance +"\n\n");
    }

    // Everytime there is a new post this is called
    // Updates customer's posts
    public void update(ArrayList<Post> itemsForSale) {
        this.posts = itemsForSale;
        cart.crossCheck(itemsForSale);
    }
}