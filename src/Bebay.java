/*
Author: Phil Bell and Zachary Jones (Phil did most of the Bebay file. He completed the Singleton Pattern, and the Publisher portion of Observer, but there 
was a lot of back and forth discussion with how to tackle Bebay correctly.) 
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

import java.util.ArrayList;

public class Bebay implements Publisher{
    //vendingList is the list of items that are currently for sale

    //this is the list of customers that will recieve updates about vending list
    private ArrayList<Poster> CustomerList = new ArrayList<Poster>();
    private ArrayList<Post> itemsForSale = new ArrayList<Post>();
    private static Bebay bebay;

    /* ---- SINGLETON PATTERN ---- */
    public static Bebay getInstance(){
        if(bebay == null){
            bebay = new Bebay();
        }
        return bebay;
    }

    @Override
    public Boolean Purchase(Post item) {

        // If its not in the list it returns false
        if (item instanceof SPost || ((PPost) item).count == 1) {
            Boolean temp = this.itemsForSale.remove(item);
            if (temp) {
                updateSubs();
            }
            
            return temp;
        }

        return true;
    }

    //this is effectively logging someone in. May need to add functionality here later for
    //darkmode and light mode support.
    @Override
    public void registerObserver(Poster e) {
        CustomerList.add(e);
        e.update(itemsForSale);
    }

    //this is to be used whenever someone "logs out"
    @Override
    public void deleteSubs(Poster e) {
        CustomerList.remove(e);
    }

    //way to update every customer currently logged in of any change to
    //the list of items to sell
    @Override
    public void updateSubs() {
        System.out.println("\nPublisher: updating customers\n");
        for (Poster customer : CustomerList) {
            customer.update(itemsForSale);
        }
    }

    // Add a new item to the list of items to sell in the form of a post
    // Update all users when done
    @Override
    public void newSale(Post item) {
        System.out.println("Publisher: added " + item.item.getName() + " to the sale list");
        item.item.printComponents();
        this.itemsForSale.add(item);
        updateSubs();

    }
}