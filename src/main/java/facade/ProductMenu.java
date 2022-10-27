package facade;

import product.Person;

import java.util.HashMap;
import java.util.Map;

public interface ProductMenu {

	Person person = null;

	/**
	 *  
	 */
	public abstract void showMenu(Map menuItems);

	/**
	 *  
	 */
	public abstract void showAddButton();

	/**
	 *  
	 */
	public abstract void showViewButton();

	/**
	 *  
	 */
	public abstract void showRadioButton();

	/**
	 *  
	 */
	public abstract void showLabels();

	/**
	 *  
	 */
	public abstract void showComboxes();

}
