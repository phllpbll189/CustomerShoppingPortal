import Item.Item;

public class Main {
    public static void main(String[] args) {
        //create publisher
        Publisher bebay = new Bebay();

        //create seller
        Poster Amazon = new Customer("Amazon", 20000, bebay);

        //create customer
    	Customer phil = new Customer("Phil", 2000, bebay);
        Customer john = new Customer("John", 5000, bebay);

        bebay.registerObserver(phil);
        bebay.registerObserver(john);
        
        //update all users and publisher that a new item is up for sale.
        bebay.newSale(Amazon.ForSale(new Item("SkateBoard", "A piece of wood with 4 wheels", 100.00)));

        phil.addToCart(0);
        john.addToCart(0);

        phil.purchaseAllCart();
    }
}