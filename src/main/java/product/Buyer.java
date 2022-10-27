package product;

import facade.Product;
import facade.ProductMenu;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Buyer extends Person {
	private ProductMenu productMenu;
	private Scanner sc = new Scanner(System.in);
	public Buyer() {
		super();
	}
	/**
	 *  
	 */
	public void showMenu(Map<String, ArrayList<String>> menuItems) {
		productMenu.showMenu(menuItems);
	}

	public Product createProductMenu(Map<String, ArrayList<String>> menuItems, String prodCategory, Map<String, String> productToNumberMap) {
		if(prodCategory.equals("Meat")) {
			productMenu = new MeatProductMenu();
		} else {
			productMenu = new ProduceProductMenu();
		}
		showMenu(menuItems);
		System.out.println("Enter item you would like to buy");
		String item = sc.next();
		item = item.substring(0,1).toUpperCase() + item.substring(1);
		if(menuItems.get(prodCategory).contains(item))
			return new Product(Integer.parseInt(productToNumberMap.get(prodCategory)), item);
		else
			return new Product(-1, item);
	}

}
