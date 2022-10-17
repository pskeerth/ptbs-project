package product;

import facade.ProductMenu;

import java.util.HashMap;
import java.util.Map;

public class ProduceProductMenu implements ProductMenu {

	/**
	 *  
	 */
	public void showMenu(Map menuItems) {
		System.out.println("Produce Menu:");
		for (Object key : menuItems.keySet()) {
			if (key.equals("Produce")) {
				System.out.println(menuItems.get(key));
			}

		}
	}


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

	/**
	 *  
	 */
	public void showComboxes() {

	}

}
