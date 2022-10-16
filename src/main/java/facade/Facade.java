package facade;

import java.util.HashMap;
import java.util.Scanner;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;
	Scanner sc = new Scanner(System.in);

	public boolean login(String username, String password, HashMap userCredentials) {
		Boolean result;
		Login login = new Login();
		result = login.validateUser(username, password, userCredentials );
		if(result) {

		}
		return result;
	}

	public void addTrading() {

		createProductList();


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

		//insert into database

	}

	/**
	 *  
	 */
	public void createProductList() {

		System.out.println("Enter the list of items separated by commas");
		String prodList = sc.next();

		if(UserType==0){
//			insert into ptbs.buyerTradingMenu (name, trading_menu) VALUES ("user", "cycle, skateboard");
			System.out.println("Successfully created buyerTradingMenu");
		} else {
//			insert into ptbs.sellerTradingMenu (name, trading_menu) VALUES ("user", "cycle, skateboard");
			System.out.println("Successfully created sellerTradingMenu");
		}


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
