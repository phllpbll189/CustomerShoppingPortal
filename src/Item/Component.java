/*
Author: Zachary Jones (Responsible for Composite Pattern)
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

package Item;

// Component is the base interface for all objects in the composition
public abstract class Component {
	
    //Name of the tag or of the object
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    abstract public void printComponents();
    
}
