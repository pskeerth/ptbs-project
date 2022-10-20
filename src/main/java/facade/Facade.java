package facade;

import iterators.ProductIterator;
import product.Buyer;
import product.MeatProductMenu;
import product.Person;
import product.Seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Facade {



	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;
	private MeatProductMenu meatProductMenu = new MeatProductMenu();
	Scanner sc = new Scanner(System.in);

	public boolean login(String username, String password, HashMap userCredentials, HashMap typeOfUser) {
		Boolean result;
		Login login = new Login();
		result = login.validateUser(username, password, userCredentials);
		if(result) {
			UserType = (int) typeOfUser.get(username);
		}
		return result;
	}

	public Product addTrading(Map<String, ArrayList<String>> menuItems, Map<String, String> productToNumberMap) {
		System.out.println("Enter product category : Eg Meat, Produce etc ..");
		String prodCategory = sc.next();
		prodCategory = prodCategory.substring(0,1).toUpperCase() + prodCategory.substring(1);
		nProductCategory = Integer.parseInt(productToNumberMap.get(prodCategory));
//		if(!((nProductCategory == 0) || (nProductCategory == 1))){
//			System.out.println("Invalid option");
//		}
//		else {
			if (UserType == 0) {
				thePerson = new Buyer();
				return thePerson.createProductMenu(menuItems, prodCategory, productToNumberMap);
			} else {
				thePerson = new Seller();
				return thePerson.createProductMenu(menuItems, prodCategory, productToNumberMap);
			}
//		}
	}

	public void viewTrading(Map menuItems) {

	}

	public int getUserType() {
		return UserType;
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
	public void createProductList(Map<String, ArrayList<String>> menuItems, Map<String, String> productToNumberMap) {

//		System.out.println("Enter the list of items separated by commas");
//		String prodList = sc.next();
//
//
//		if(UserType==0){
////			insert into ptbs.buyerTradingMenu (name, trading_menu) VALUES ("user", "cycle, skateboard");
//			System.out.println("Successfully created buyerTradingMenu");
//		} else {
////			insert into ptbs.sellerTradingMenu (name, trading_menu) VALUES ("user", "cycle, skateboard");
//			System.out.println("Successfully created sellerTradingMenu");
//		}


		iterators.ClassProductList classProductList = new iterators.ClassProductList();
		ProductIterator productIterator;
		Product product = new Product();
		for(Map.Entry<String, ArrayList<String>> entry: menuItems.entrySet()) {
			ArrayList<String> list = entry.getValue();
			for(String item: list){
				product.setItem(item);
				product.setnCategoryType(Integer.parseInt(productToNumberMap.get(entry.getKey())));
				classProductList.add(product);
			}
		}
		int i=0;
		productIterator = new ProductIterator(classProductList);
		while (productIterator.hasNext()) {
			product = productIterator.Next();
			System.out.println("Product details : no. "+ i);
			System.out.println(product.getItem());
			System.out.println(product.getnCategoryType());
			i+=1;
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
