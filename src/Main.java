/*
Author: Zachary Jones and Phil Bell (Main function basically split 50/50)
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

import Item.*;

public class Main {
    public static void main(String[] args) {
        //create publisher
        Publisher bebay = Bebay.getInstance();

        //create seller
        Poster Amazon = new Customer("Amazon", 20000);

        // Create customers
        Customer phil = new Customer("Phil", 2000);
        Customer zach = new Customer("Zach", 5000);

        // Creates new items to be posted
        Item skateboard = new Item("Skateboard", "A piece of wood with 4 wheels", 100.00);
        Item earbuds = new Item("Earbuds", "Makes sound", 150.00);
        // Register observers to be notified of updates

        bebay.registerObserver(phil);
        bebay.registerObserver(zach);

        
        bebay.newSale(Amazon.ForSale(skateboard));
        bebay.newSale(Amazon.ForSale(earbuds, 34));
        
        //update all users and publisher that a new item is up for sale.
        earbuds.addComponent(new Tag("electronic"))
                .addComponent(new Tag("wireless"))
                .addComponent(new Tag("blutooth"));

        bebay.newSale(Amazon.ForSale(new Item("SkateBoard", "A piece of wood with 4 wheels", 100.00)));
        bebay.newSale(Amazon.ForSale(earbuds, 34));
        phil.addToCart(0);
        zach.addToCart(0);
        

        phil.addToCart(1);
        zach.addToCart(1);

        phil.purchaseAllCart();
        zach.purchaseAllCart();
    }
}