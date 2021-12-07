import java.util.ArrayList;

public class Bebay implements Publisher{
    //vendingList is the list of items that are currently for sale

    //this is the list of customers that will recieve updates about vending list
    private ArrayList<Poster> CustomerList = new ArrayList<Poster>();
    private ArrayList<Post> itemsForSale = new ArrayList<Post>();
    private static Bebay bebay;
    //inform user that there item was sold
    //remove the item
    //update subs
    public static Bebay getInstance(){
        if(bebay == null){
            bebay = new Bebay();
        }
        return bebay;
    }

    @Override
    public Boolean Purchase(Post item) {

        //if its not in the list it returns false
        if(item instanceof SPost || ((PPost) item).count == 1){
            Boolean temp = this.itemsForSale.remove(item);
            if(temp){
                updateSubs();
            }
            return temp;
        }
        return true;
    }

    //this is effectively logging someone in. May need to add functionality here later for
    //darkmode and light mode support.
    @Override
    public void registerObserver(Poster e) {
        CustomerList.add(e);
        e.update(itemsForSale);
    }

    //this is to be used whenever someone "logs out"
    @Override
    public void deleteSubs(Poster e) {
        CustomerList.remove(e);
    }

    //way to update every customer currently logged in of any change to
    //the list of items to sell
    @Override
    public void updateSubs() {
        System.out.println("\nPublisher: updating customers\n");
        for (Poster customer : CustomerList) {
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