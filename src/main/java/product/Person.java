package product;

import facade.Product;
import facade.ProductMenu;

import java.util.ArrayList;
import java.util.Map;

public abstract class Person {

	private ProductMenu theProductMenu;

	private ProductMenu productMenu;

	public abstract void showMenu(Map<String, ArrayList<String>> menuItems);

	/**
	 *  
	 */
	public void showAddButton() {

	}

	/**
	 *  
	 */
	public void showViewButton() {

	}

	/**
	 *  
	 */
	public void showRadioButton() {

	}

	/**
	 *  
	 */
	public void showLabels() {

	}

	public abstract Product createProductMenu(Map<String, ArrayList<String>> menuItems, String prodCategory, Map<String, String> productToNumberMap);

}
