package product;

import facade.Facade;
import facade.Product;
import facade.ProductMenu;

import java.io.IOException;
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

	public Product createProductMenu(Map<String, ArrayList<String>> menuItems, String prodCategory, Map<String, String> productToNumberMap) throws IOException {
		Facade facade = new Facade();
		if(prodCategory.equals("Meat")) {
			productMenu = new MeatProductMenu();
		} else {
			productMenu = new ProduceProductMenu();
		}
		System.out.println("Existing menu items:");
		showMenu(menuItems);
		System.out.println("Enter item to add, otherwise -1 to skip add");
		String item = sc.next();
		if(!(item.equals("-1"))) {
			item = item.substring(0,1).toUpperCase() + item.substring(1);
			ArrayList<String> itemList = menuItems.get(prodCategory);
			itemList.add(item);
			menuItems.put(prodCategory, itemList);
			String addMenuItem = prodCategory + ":" + item;
			facade.writeToFile(facade.getMenuFilePath(), addMenuItem);
			System.out.println("Added new product to products file");
			return new Product(Integer.parseInt(productToNumberMap.get(prodCategory)), item);
		} else {
			System.out.println("Enter the product you want to sell");
			String sellProduct = sc.next();
			return new Product(Integer.parseInt(productToNumberMap.get(prodCategory)), sellProduct);
		}
	}

}
