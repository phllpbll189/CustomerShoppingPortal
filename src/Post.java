/*
Author: Phil Bell (Responsible for Strategy Pattern) 
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

import Item.Item;

// Post is where the Strategy Pattern was implemented. 
// There are two different 'strategies' for Posts, each implementing sold() differently
public abstract class Post {
    Item item;
    Poster poster;
    abstract double sold();
}
