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
