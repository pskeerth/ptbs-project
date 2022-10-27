package product;

import facade.ProductMenu;

import java.util.HashMap;
import java.util.Map;

public class MeatProductMenu implements ProductMenu {

	/**
	 *  
	 *  
	 */
	public void showMenu(Map menuItems) {
		System.out.println("---Bridge design pattern implemented here---");
		System.out.println("Meat Product Menu:");
		for(Object key : menuItems.keySet()) {
			if(key.equals("Meat"))
				System.out.println(menuItems.get(key));
		}
	}


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
