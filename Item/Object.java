package Item;
import java.util.ArrayList;

public class Object extends Item {
	//description and price of an object
    private String description;
    private double price;

    //this is what is in the item that is sold.
    //Ie ps5 has controller, ps5, and wires.
    //It also holds onto tags for the particular item.
    private ArrayList<Item> items = new ArrayList<Item>();

    public Object(String name, String description, double price) {
        super(name);
        this.description = description;
        this.price = price;
    }

    
    public void addItem(Item item) {
        this.items.add(item);
    }

}
