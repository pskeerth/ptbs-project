package visitors;

import facade.Product;
import facade.Facade;

import java.util.ArrayList;
import java.util.Map;

public abstract class NodeVisitor {

	/**
	 *  
	 */
	public abstract void visitorProduct(Product product);

	public abstract void visitTrading(Trading trading, Map<String, ArrayList<String>> userToProductsOfferedMap);

	public abstract void visitorFacade(Facade facade);

}
