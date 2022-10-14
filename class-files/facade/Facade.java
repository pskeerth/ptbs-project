package facade;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public boolean login(String username, String password) {
		// write sql query

		// SELECT TOP 1 products.id FROM products WHERE products.id = ?;

		Login login = new Login();
		return login.validateUser(username, password);

	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	/**
	 *  
	 */
	public void decideBidding() {

	}

	/**
	 *  
	 */
	public void discussBidding() {

	}

	/**
	 *  
	 */
	public void submitBidding() {

	}

	/**
	 *  
	 */
	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	/**
	 *  
	 */
	public void createProductList() {

	}

	/**
	 *  
	 */
	public void AttachProductToUser() {

	}

	/**
	 *  
	 */
	public Product SelectProduct() {
		return null;
	}

	/**
	 *  
	 */
	public void productOperation() {

	}

}
