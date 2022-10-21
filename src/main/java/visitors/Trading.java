package visitors;

import java.util.ArrayList;
import java.util.Map;

public class Trading {

	String user;
	String tradeProduct;

	public Trading(String user, String tradeProduct) {
	}

	public String getUser() {
		return user;
	}

	public String getTradeProduct() {
		return tradeProduct;
	}



	public void accept(NodeVisitor visitor, Map<String, ArrayList<String>> userToProductsOfferedMap) {
		Trading trading = new Trading(getUser(), getTradeProduct());
		visitor.visitTrading(trading, userToProductsOfferedMap);
	}

}
