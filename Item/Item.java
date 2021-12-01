package Item;
import java.util.ArrayList;
import java.util.UUID;

public class Item extends Component {
	//description and price of an object
    private final UUID ID;
    private String description;
    private double price;

    //this is what is in the item that is sold.
    //I.E. ps5 has controller, ps5, and wires.
    //It also holds onto tags for the particular item.
    private ArrayList<Component> components = new ArrayList<Component>();

    public Item(String name, String description, double price) {
        super(name);
        this.description = description;
        this.price = price;
        //random ID to insure uniqueness among even the same items. AKA 2 controllers of the same model.
        ID = UUID.randomUUID();
    }

    //add component to a package deal
    public void addComponent(Component component) {
        this.components.add(component);
    }

    public UUID getID() {
        return ID;
    }


    //============GETTERS/SETTERS==============//
    public String getName(){
        return super.name;
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


	public ArrayList<Component> getComponents() {
		return components;
	}


	public void setItems(ArrayList<Component> components) {
		this.components = components;
	}
}
