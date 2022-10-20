package facade;

import iterators.ProductIterator;
import product.Buyer;
import product.MeatProductMenu;
import product.Person;
import product.Seller;

import java.io.*;
import java.util.*;

public class Facade {



	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;
	private String currentUser;

	private ClassProductList theProductList;

	private Person thePerson;
	private MeatProductMenu meatProductMenu = new MeatProductMenu();
	HashMap userCredentials = new HashMap<String, String>();
	HashMap typeOfUser = new HashMap<String, String>();
	Map<String, String> productToNumberMap = new HashMap<>();
	Map<String, ArrayList<String>> menuItems = new HashMap<>();
	Scanner sc = new Scanner(System.in);

	String credentialsFilePath1 = "src/main/resources/buyers.txt";
	String menuFilePath = "src/main/resources/meat-produce-menu.txt";
	String sellerLoginsFilePath = "src/main/resources/sellers.txt";
	String userProductLogFile = "src/main/resources/user-product.txt";

	public boolean login() throws IOException {
		Boolean result;
		String username;
		String password;
		System.out.println("Username :  ");
		username = sc.next();
		setCurrentUser(username);
		System.out.println("Password :  ");
		password = sc.next();
		Login login = new Login();
		result = login.validateUser(username, password, userCredentials);
		if(result) {
			UserType = (int) typeOfUser.get(username);
		}
		readFromFileforUserDetails(credentialsFilePath1, 0);
		readFromFileforUserDetails(sellerLoginsFilePath, 1);
		readMenuFile(menuFilePath);
		createProductList();
		return result;
	}

	public void setCurrentUser(String username){
		currentUser = username;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void addTrading() throws IOException {
		Product product;
		System.out.println("Enter product category : Eg Meat, Produce etc ..");
		String prodCategory = sc.next();
		prodCategory = prodCategory.substring(0,1).toUpperCase() + prodCategory.substring(1);
		nProductCategory = Integer.parseInt(productToNumberMap.get(prodCategory));
		if (UserType == 0) {
			thePerson = new Buyer();
		} else {
			thePerson = new Seller();
		}
		product = thePerson.createProductMenu(menuItems, prodCategory, productToNumberMap);
		if (product.getnCategoryType() != -1) {
			String trade = getCurrentUser() + ":" + product.getItem();
			writeToFile(userProductLogFile, trade);
			System.out.println("Trade added to user Product log file");
		} else {
			System.out.println("Invalid trade");
		}

		if(getUserType().equals("Seller")){
			String category = product.getnCategoryType() == 0 ? "Meat" : "Produce";
			ArrayList<String> itemList = menuItems.get(category);
			itemList.add(product.getItem());
			menuItems.put(category, itemList);
			String addMenuItem = category + ":" + product.getItem();
			writeToFile(menuFilePath, addMenuItem);
			System.out.println("Added new product to products file");
		}
	}

	public void viewTrading() throws IOException {
		String line;
		System.out.println("Whose trade would you like to view");
		//print out buyers and sellers names
		String user = sc.next();
		System.out.println("Printing out all trades of "+ user);
		BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/user-product.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			String[] split = line.split(":", 2);
			if (split.length >= 2) {
				String key = split[0];
				if(key.equals(user)) {
					System.out.println(line);
				}
			} else {
				System.out.println("ignoring line: " + line);
			}
		}

	}

	public String getUserType() {
		if(UserType == 0)
			return "Buyer";
		return "Seller";
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

	public void createUser() throws IOException {
		String username;
		String password;
		String userType;
		String fileToWriteTo;
		UserInfoItem userinfoitem = new UserInfoItem();
		System.out.println("Enter name of the user");
		username = sc.next();
		System.out.println("Enter the password that you want to set");
		password = sc.next();
		System.out.println("Are you a buyer or seller");
		userType = sc.next();
		userType = userType.substring(0,1).toUpperCase() + userType.substring(1);
		userinfoitem.setName(username);
		userinfoitem.setPassword(password);
		userinfoitem.setType(userType);
		userCredentials.put(username, password);
		typeOfUser.put(username, productToNumberMap.get(userType));
		String insertUser = userinfoitem.getName() + ":" + userinfoitem.getPassword();
		System.out.println("Successfully created user");

		if(userType.equals("Buyer")) {
			fileToWriteTo = credentialsFilePath1;
		} else {
			fileToWriteTo = sellerLoginsFilePath;
		}
		writeToFile(fileToWriteTo, insertUser);
		System.out.println("User added to list of users file");

	}

	/**
	 *  
	 */
	public void createProductList() {
		//check description
		iterators.ClassProductList classProductList = new iterators.ClassProductList();
		ProductIterator productIterator;
		for(Map.Entry<String, ArrayList<String>> entry: menuItems.entrySet()) {
			ArrayList<String> list = entry.getValue();
			for(String item: list){
				Product product = new Product();
				product.setItem(item);
				product.setnCategoryType(Integer.parseInt(productToNumberMap.get(entry.getKey())));
				classProductList.add(product);
			}
		}
		int i=0;
		productIterator = new ProductIterator(classProductList);
		productIterator.MoveToHead();
		while (productIterator.hasNext()) {
			Product product = productIterator.Next();
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

	public void writeToFile(String filePathToWriteTo, String entry) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathToWriteTo, true));
		bufferedWriter.write(entry + "\n");
		bufferedWriter.close();
	}

	public void readFromFileforUserDetails(String fileToReadPath, int userType) throws IOException {
		String line;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToReadPath));
		while ((line = bufferedReader.readLine()) != null) {
			String[] split = line.split(":", 2);
			if (split.length >= 2) {
				String key = split[0];
				String value = split[1];
				userCredentials.put(key, value);
				typeOfUser.put(key, userType);
			} else {
				System.out.println("ignoring line: " + line);
			}
		}
	}

	public void readMenuFile(String fileToReadPath) throws IOException {
		String line;
		int i=0;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToReadPath));
		while ((line = bufferedReader.readLine()) != null) {
			String[] split = line.split(":", 2);
			if (split.length >= 2) {
				String key = split[0];
				String value = split[1];
				if(menuItems.containsKey(key)) {
					ArrayList<String> items = menuItems.get(key);
					items.add(value);
					menuItems.put(key, items);
				}
				else {
					menuItems.put(key, new ArrayList<>(Arrays.asList(value)));
					productToNumberMap.put(key, String.valueOf(i));
					i=i+1;
				}
			} else {
				System.out.println("ignoring line: " + line);
			}
		}
	}




}
