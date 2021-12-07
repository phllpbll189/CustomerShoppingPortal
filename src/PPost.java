import Item.Item;

public class PPost extends Post {
     /*
    This allows us to keep track of the original poster and the Item in which he is selling
    */

    Poster poster;
    int count;
    Bebay bebay;

    PPost(Poster poster, Item item, int count){
        super.item = item;
        this.poster = poster;
        this.count = count;
        this.bebay = Bebay.getInstance();
    }

    //lets the poster know his item was sold
    //also lets the publisher know to delete the product
    public double sold(){
        //if it is in the sale list then purchase it
        //the user has already been checked to see if they have enough money for it

        if(bebay.Purchase(this)){
            poster.Sold(item);
            return item.getPrice();
        }
        return 0.00;
    }
}
