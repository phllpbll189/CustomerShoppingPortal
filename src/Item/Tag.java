/*
Author: Zachary Jones (Responsible for Composite Pattern)
Class: CSI-340-01 
Assignment:  Final Project
Date Assigned: 11/22 
Due Date:  12/6/2021 @ 11:59PM 
*/

package Item;

public class Tag extends Component {

    public Tag(String category){
        super(category);
    }

    @Override
    public void printComponents() {
        System.out.println("\tTag: " + super.name);
    }

}
