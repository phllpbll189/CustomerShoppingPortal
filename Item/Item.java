package Item;
import java.util.ArrayList;

public class Item extends Component {
	//description and price of an object
    private String description;
    private double price;

    //this is what is in the item that is sold.
    //I.E. ps5 has controller, ps5, and wires.
    //It also holds onto tags for the particular item.
    private ArrayList<Component> items = new ArrayList<Component>();

    public Item(String name, String description, double price) {
        super(name);
        this.description = description;
        this.price = price;
    }

    
    public void addItem(Component item) {
        this.items.add(item);
    }


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public ArrayList<Component> getItems() {
		return items;
	}


	public void setItems(ArrayList<Component> items) {
		this.items = items;
	}

    
}
