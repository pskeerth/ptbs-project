package facade;

import product.Buyer;
import product.Person;
import product.Seller;
import visitors.*;
import iterators.ClassProductList;

import java.io.*;
import java.util.*;

public class Facade {



	private int UserType;

	private Product theSelectedProduct;

	private String currentUser;

	private ClassProductList theProductList = new ClassProductList();

	private Person thePerson;

	int nProductCategory;
	HashMap userCredentials = new HashMap<String, String>();
	HashMap typeOfUser = new HashMap<String, String>();
	Map<String, String> productToNumberMap = new HashMap<>();
	Map<String, ArrayList<String>> menuItems = new HashMap<>();
	Map<String, ArrayList<String>> userToProductsOfferedMap = new HashMap<>();
	Map<String, ArrayList<String>> productToBuyerMap = new HashMap<>();

	Scanner sc = new Scanner(System.in);

	String buyerLoginsFilePath = "src/main/resources/BuyerInfo.txt";

	String menuFilePath = "src/main/resources/ProductInfo.txt";
	String sellerLoginsFilePath = "src/main/resources/SellerInfo.txt";
	String userProductLogFile = "src/main/resources/UserProduct.txt";

	public boolean login() throws IOException {
		System.out.println("---Facade design pattern implemented here---");
		Boolean result;
		String username;
		String password;
		System.out.println("Username :  ");
		username = sc.next();
		setCurrentUser(username);
		System.out.println("Password :  ");
		password = sc.next();
		readFromFileforUserDetails(buyerLoginsFilePath, 0);
		readFromFileforUserDetails(sellerLoginsFilePath, 1);
		Login login = new Login();
		result = login.validateUser(username, password, userCredentials);
		if(result) {
			UserType = (int) typeOfUser.get(username);
		}
		readMenuFile(menuFilePath);
		readUserProductLogFile();
		if (UserType == 0) {
			thePerson = new Buyer();
		} else {
			thePerson = new Seller();
		}
		System.out.println("---Factory Method design pattern implemented here---");
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
		System.out.println("Enter product category : Meat or Produce");
		String prodCategory = sc.next();
		prodCategory = prodCategory.substring(0,1).toUpperCase() + prodCategory.substring(1);
		nProductCategory = Integer.parseInt(productToNumberMap.get(prodCategory));
		product = thePerson.createProductMenu(menuItems, prodCategory, productToNumberMap);
		if ((product.getnCategoryType() != -1) && (getUserType().equals("Buyer"))) {
			System.out.println("The following sellers are offering "+ product.getItem());
			for(String tradeUser: userToProductsOfferedMap.keySet()) {
				ArrayList<String> offeringList = userToProductsOfferedMap.get(tradeUser);
				if(offeringList.contains(product.getItem())) {
					System.out.println(tradeUser);
				}
			}
			System.out.println("Type name of seller that you want to buy the item from: ");
			String userToBuyFrom = sc.next();
			String removeTrade = userToBuyFrom + ":" + product.getItem();
			removeFromUserProductFile(removeTrade);
			String trade = getCurrentUser() + ":" + product.getItem();
			writeToFile(userProductLogFile, trade);
			System.out.println("Trade added to user Product log file");
		} else if ((product.getnCategoryType() != -1) && (getUserType().equals("Seller"))){
			ArrayList<String> buyerList = discussBidding(product);
			if (buyerList != null && !buyerList.isEmpty()) {
				String buyerToSellTo = decideBidding();
				submitBidding(product, buyerToSellTo);
			} else {
				System.out.println("Buyer List for this product is empty");
			}
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
		System.out.println("Whose trade would you like to view from the below list: ");
		System.out.println(userCredentials.keySet());
		System.out.println("Enter person's name: ");
		String user = sc.next();
		System.out.println("Printing out all trade log of user = "+ user);
		BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/UserProduct.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			String[] split = line.split(":", 2);
			if (split.length >= 2) {
				String tradeUser = split[0];
				if(tradeUser.equals(user)) {
					System.out.println(line);
				}
			} else {
				System.out.println("This line contains too many args: " + line);
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
	public String decideBidding() {
		System.out.println("Type name of buyer that you want to sell the item to: ");
		String buyerToSellTo = sc.next();
		return buyerToSellTo;
	}

	public String getMenuFilePath() {
		return menuFilePath;
	}
	/**
	 *  
	 */
	public ArrayList<String> discussBidding(Product product) {
		System.out.println("The following buyers want to buy "+ product.getItem());
		ArrayList<String> buyerList = productToBuyerMap.get(product.getItem());
		System.out.println(buyerList);
		return buyerList;
	}

	/**
	 *  
	 */
	public void submitBidding(Product product, String buyerToSellTo) {
		String removeTrade = getCurrentUser() + ":" + product.getItem();
		removeFromUserProductFile(removeTrade);
		System.out.println("Seller Trade removed from user Product log file because it was sold to "+ buyerToSellTo);

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
			fileToWriteTo = buyerLoginsFilePath;
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
		for(Map.Entry<String, ArrayList<String>> entry: menuItems.entrySet()) {
			ArrayList<String> list = entry.getValue();
			for(String item: list){
				Product product = new Product();
				product.setItem(item);
				product.setnCategoryType(Integer.parseInt(productToNumberMap.get(entry.getKey())));
				theProductList.add(product);
			}
		}
	}

	public void getProductList() {

		ReminderVisitor reminderVisitor = new ReminderVisitor();
		theProductList.accept(reminderVisitor, theProductList);
	}

	/**
	 *  
	 */
	public void attachProductToUser(String tradeUser, String trade) {
		Trading trading = new Trading(tradeUser, trade);
		ReminderVisitor reminderVisitor = new ReminderVisitor();
		trading.accept(reminderVisitor, userToProductsOfferedMap);
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
				System.out.println("This line contains too many args: " + line);
			}
		}
	}

	public void readUserProductLogFile() throws IOException {
		String line;
		BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/UserProduct.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			String[] split = line.split(":", 2);
			if (split.length >= 2) {
				String tradeUser = split[0];
				String trade = split[1];
				if(typeOfUser.get(tradeUser).equals(1)) {
					attachProductToUser(tradeUser, trade);
				}
				if(typeOfUser.get(tradeUser).equals(0)) {
					attachBuyerToProduct(tradeUser, trade);
				}
			} else {
				System.out.println("This line contains too many args: " + line);
			}
		}
		System.out.println("---Visitor design pattern implemented here---");
	}

	private void attachBuyerToProduct(String tradeUser, String trade) {
		ProductToBuyer productToBuyer = new ProductToBuyer(tradeUser, trade);
		ReminderVisitor reminderVisitor = new ReminderVisitor();
		productToBuyer.accept(reminderVisitor, productToBuyerMap);
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
				System.out.println("This line contains too many args: " + line);
			}
		}
	}

	public void removeFromUserProductFile(String removeTrade) {
		//remove from file te line remove trade
	}




}
