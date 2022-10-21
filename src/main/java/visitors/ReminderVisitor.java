package visitors;

import facade.Reminder;
import facade.Product;
import facade.Facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	@Override
	public void visitorProduct(Product product) {

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
