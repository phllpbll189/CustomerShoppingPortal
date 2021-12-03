

import Item.Item;

public class Post {
    /*
    This allows us to keep track of the original poster and the Item in which he is selling
    */

    Poster poster;
    Item item;

    Post(Poster poster, Item item){
        this.poster = poster;
        this.item = item;
    }

    //lets the poster know his item was sold
    public void sold(){
        poster.Sold(item);
    }
}
