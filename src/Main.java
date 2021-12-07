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

        //create customer
        Customer phil = new Customer("Phil", 2000);
        Customer zach = new Customer("Zach", 5000);
        
        Tag transportation = new Tag("Transportation");
        Tag entertainment = new Tag("Entertainment");
        Tag electronic = new Tag("Electronic");
        Tag accessory = new Tag("Accessory");
        
        // Creates new items to be posted
        Item skateboard = new Item("Skateboard", "A piece of wood with 4 wheels", 100.00);
        Item earbuds = new Item("Earbuds", "Makes sound", 150.00);

        // Shows tags in use. Describes an item.
        skateboard.addComponent(transportation);
        skateboard.addComponent(entertainment);
        skateboard.iterateComponents(skateboard.getComponents());
        System.out.println("Skateboard description: " + skateboard.getDescription());
        System.out.println("");
        
        earbuds.addComponent(electronic);
        earbuds.addComponent(accessory);
        earbuds.iterateComponents(earbuds.getComponents());
        System.out.println("Earbud description: " + earbuds.getDescription());
        System.out.println("");
        
        // Register observers to be notified of updates
        bebay.registerObserver(phil);
        bebay.registerObserver(zach);

        
        bebay.newSale(Amazon.ForSale(skateboard));
        bebay.newSale(Amazon.ForSale(earbuds, 34));
        
        //update all users and publisher that a new item is up for sale.
        phil.addToCart(0);
        zach.addToCart(0);
        

        phil.addToCart(1);
        zach.addToCart(1);

        phil.purchaseAllCart();
        zach.purchaseAllCart();
    }
}