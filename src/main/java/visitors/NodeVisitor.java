package visitors;

import facade.Product;
import facade.Facade;

public abstract class NodeVisitor {

	/**
	 *  
	 */
	public abstract void visitorProduct(Product product);

	public abstract void visitTrading(Trading trading);

	public abstract void visitorFacade(Facade facade);

}
