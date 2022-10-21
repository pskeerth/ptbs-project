package visitors;

import facade.Reminder;
import facade.Product;
import facade.Facade;
import iterators.ClassProductList;
import iterators.ProductIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	@Override
	public void visitorProduct(ClassProductList classProductList) {

		int i=0;
		ProductIterator productIterator = new ProductIterator(classProductList);
		productIterator.MoveToHead();
		System.out.println("Printing all products and their categories");
		System.out.println("Product categories: 0 for Meat and 1 for Produce");
		while (productIterator.hasNext()) {
			Product product = productIterator.Next();
			System.out.println("Product details : no. "+ i);
			System.out.println("Name: "+product.getItem());
			System.out.println("Product category: "+product.getnCategoryType());
			System.out.println();
			i+=1;
		}
	}

	@Override
	public void visitTrading(Trading trading, Map<String, ArrayList<String>> userToProductsOfferedMap) {
		if(userToProductsOfferedMap.containsKey(trading.getUser())) {
			ArrayList<String> itemList = userToProductsOfferedMap.get(trading.getUser());
			itemList.add(trading.getTradeProduct());
			userToProductsOfferedMap.put(trading.getUser(), itemList);
		} else {
			userToProductsOfferedMap.put(trading.getUser(), new ArrayList<>(Arrays.asList(trading.getTradeProduct())));
		}
	}

	public void visitorFacade(Facade facade) {

	}

}
