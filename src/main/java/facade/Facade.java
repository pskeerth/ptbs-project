package facade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;
	Scanner sc = new Scanner(System.in);

	public boolean login(String username, String password) throws SQLException {
		// write sql query
		Boolean result;
		// SELECT TOP 1 products.id FROM products WHERE products.id = ?;

		Login login = new Login();
		result = login.validateUser(username, password);
		if(result) {
//			UserType = select type_of_user from userdetails where name='nikith';
		}
		return result;
	}

	public void addTrading() {

//		JFrame f=new JFrame("ProductMenu");
//		JButton b=new JButton("Add");
//		b.setBounds(50,100,95,30);
//		b.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//
//			}
//		});
//		f.add(b);
//		f.setSize(400,400);
//		f.setLayout(null);
//		f.setVisible(true);
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
