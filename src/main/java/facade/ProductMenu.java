package facade;

import product.Person;

public interface ProductMenu {

	Person person = null;

	/**
	 *  
	 */
	public abstract void showMenu();

	/**
	 *  
	 */
	public abstract void showAddButtton();

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
