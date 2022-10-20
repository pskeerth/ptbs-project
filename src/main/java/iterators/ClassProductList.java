package iterators;

import facade.Product;
import visitors.NodeVisitor;

import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

	public ClassProductList(){
		super();
	}

	private ProductIterator productIterator;

	public void accept(NodeVisitor visitor) {

	}

}
