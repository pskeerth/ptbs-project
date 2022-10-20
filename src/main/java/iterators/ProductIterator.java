package iterators;

import facade.Product;

public class ProductIterator implements ListIterator {
	private final ClassProductList classProductList;
	int pointer = 0;

	public ProductIterator(ClassProductList classProductList) {
		this.classProductList = classProductList;
	}

	public boolean hasNext() {
		if(pointer >= classProductList.size() - 1) {
			return false;
		}
		return true;
	}

	public Product Next() {
		Product product = classProductList.get(pointer);
		pointer += 1;
		return product;
	}


	public void MoveToHead() {
		pointer = 0;
	}

	/**
	 *  
	 */
	public void Remove() {
		classProductList.remove(pointer);
	}

}
