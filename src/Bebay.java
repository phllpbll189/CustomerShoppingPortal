import java.util.ArrayList;

public class Bebay implements Publisher{
    //vendingList is the list of items that are currently for sale

    //this is the list of customers that will recieve updates about vending list
    private ArrayList<Customer> CustomerList = new ArrayList<Customer>();
    private ArrayList<Post> itemsForSale = new ArrayList<Post>();

    //inform user that there item was sold
    //remove the item
    //update subs
    @Override
    public Boolean Purchase(Post item) {
        item.sold();
        Boolean temp = this.itemsForSale.remove(item);
        if(temp){
            updateSubs();
        }
        
        return temp;
    }

    //this is effectively logging someone in. May need to add functionality here later for
    //darkmode and light mode support.
    @Override
    public void registerObserver(Customer e) {
        CustomerList.add(e);
    }

    //this is to be used whenever someone "logs out"
    @Override
    public void deleteSubs(Customer e) {
        CustomerList.remove(e);
    }

    //way to update every customer currently logged in of any change to
    //the list of items to sell
    @Override
    public void updateSubs() {
        for (Customer customer : CustomerList) {
            customer.update(itemsForSale);
        }
    }

    //add a new item to the list of items to sell in the form of a post
    //update all users when done
    @Override
    public void newSale(Post item) {
        System.out.println("Publisher: added " + item.item.getName() + " to the sale list");
        this.itemsForSale.add(item); 
        updateSubs();
    }
}