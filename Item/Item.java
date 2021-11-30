package Item;

/*
	- Items can be posted for sale by Customers
	- Items will only be taken off the market when a Customer checks out their cart with the item 
*/
public abstract class Item {
    protected String name;

    public Item(String name){
        this.name = name;
    }
    
}
