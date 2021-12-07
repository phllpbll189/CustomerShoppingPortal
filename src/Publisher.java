/*
Author: Zachary Jones (Responsible for Subscriber portion of Observer Pattern)
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

// This is the poster for the Observer pattern
public interface Publisher {
    Boolean Purchase(Post item);
    void newSale(Post item);
    public void registerObserver(Poster sub);
    public void deleteSubs(Poster sub);
    public void updateSubs();
}

