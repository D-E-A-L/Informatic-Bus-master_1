package publicTransportController;
import java.util.ArrayList;
import publicTransportModel.*;
public class ChildController {
    private ArrayList<Person> childs;

    public ChildController() {
        childs = new ArrayList<Person>();
    }
    
    public void insertChild(Child el){
        childs.add(el);
    }

    public ArrayList<Person> getChilds() {
        return childs;
    }
}
