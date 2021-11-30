package Item;

import java.util.ArrayList;

public class Object extends Item{
    private String description;
    private double price;
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
