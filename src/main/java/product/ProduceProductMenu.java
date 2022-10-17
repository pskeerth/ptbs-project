package product;

import facade.ProductMenu;

import java.util.HashMap;
import java.util.Map;

public class ProduceProductMenu implements ProductMenu {

	/**
	 *  
	 */
	public void showMenu(Map menuItems) {
		System.out.println("Meat Product Menu:");
		for(Object item:menuItems.entrySet()) {
			System.out.println(item.toString());
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
