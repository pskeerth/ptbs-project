package visitors;

import java.util.ArrayList;
import java.util.Map;

public abstract class Reminder {

    public abstract void accept(NodeVisitor visitor, Map<String, ArrayList<String>> userToProductsOfferedMap);

}
