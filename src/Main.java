import Item.Item;

public class Main {
    public static void main(String[] args) {
        //create publisher
        Publisher bebay = Bebay.getInstance();

        //create seller
        Poster Amazon = new Customer("Amazon", 20000); 

        //create customer
        Customer phil = new Customer("Phil", 2000);
        Customer john = new Customer("John", 5000);

        bebay.registerObserver(phil);
        bebay.registerObserver(john);

        //update all users and publisher that a new item is up for sale.
        bebay.newSale(Amazon.ForSale(new Item("SkateBoard", "A piece of wood with 4 wheels", 100.00)));
        bebay.newSale(Amazon.ForSale(new Item("earbuds", "Makes sound", 150.00), 34));
        phil.addToCart(0);
        john.addToCart(0);

        phil.addToCart(1);
        john.addToCart(1);

        phil.purchaseAllCart();
        john.purchaseAllCart();
    }
}