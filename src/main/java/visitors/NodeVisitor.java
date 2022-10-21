package visitors;

import facade.Facade;
import iterators.ClassProductList;

import java.util.ArrayList;
import java.util.Map;

public abstract class NodeVisitor {

	/**
	 *  
	 */
	public abstract void visitorProduct(ClassProductList product);

	public abstract void visitTrading(Trading trading, Map<String, ArrayList<String>> userToProductsOfferedMap);

	public abstract void visitorFacade(Facade facade);

}
