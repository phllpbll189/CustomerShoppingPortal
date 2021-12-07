/*
Author: Zachary Jones (Responsible for Composite Pattern)
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

package Item;
import java.util.ArrayList;
import java.util.UUID;

/* ---- COMPOSITE PATTERN ---- */

// Item is the composite class since it holds a collection of Components
public class Item extends Component {
	//description and price of an object
    private final UUID ID;
    private String description;
    private double price;

    // This is a collection of all the components that the item contains
    // Example: PS5 has controller, the PS5, and additional wires.
    // It also holds onto tags for the particular item.
    private ArrayList<Component> components = new ArrayList<Component>();

    // Constructor
    public Item(String name, String description, double price) {
        super(name);
        this.description = description;
        this.price = price;
        // Random ID to insure uniqueness among even the same items. AKA 2 controllers of the same model.
        ID = UUID.randomUUID();
    }

    // Add component to a package deal
    public void addComponent(Component component) {
        this.components.add(component);
    }
    
    // Loop through all components of an item and print it's tags and items
    public void iterateComponents(ArrayList<Component> components) {
		if (components.isEmpty()) {
			return;
		}
		
		for (Component component : components) {
			if (component instanceof Tag) {
				System.out.println(super.name + " has the tag: " + component.name);
			}
			else {
				System.out.println("Item Name is: " + component.name);
				iterateComponents(components);
			}
		}
	}

    // --------- GETTERS AND SETTERS --------- //
    public String getName() {
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
	
    public UUID getID() {
        return ID;
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
