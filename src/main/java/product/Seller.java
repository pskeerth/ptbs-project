package product;

import facade.Product;
import facade.ProductMenu;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Seller extends Person {

	private ProductMenu productMenu;
	private Scanner sc = new Scanner(System.in);
	public Seller() {
		super();
	}
	/**
	 *  
	 */
	public void showMenu(Map<String, ArrayList<String>> menuItems) {
		productMenu.showMenu(menuItems);
	}

	public Product createProductMenu(Map<String, ArrayList<String>> menuItems, String prodCategory, Map<String, String> productToNumberMap) {
		System.out.println("Existing menu items:");
		showMenu(menuItems);
		System.out.println("Enter item to add");
		String item = sc.next();
		item = item.substring(0,1).toUpperCase() + item.substring(1);
		return new Product(Integer.parseInt(productToNumberMap.get(prodCategory)), item);
	}

}
