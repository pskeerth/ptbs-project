package visitors;

import java.util.ArrayList;
import java.util.Map;

public class ProductToBuyer extends Reminder{

    String user;
    String tradeProduct;

    public ProductToBuyer(String user, String tradeProduct) {
        this.user = user;
        this.tradeProduct = tradeProduct;
    }

    public String getUser() {
        return user;
    }

    public String getTradeProduct() {
        return tradeProduct;
    }


    @Override
    public void accept(NodeVisitor visitor, Map<String, ArrayList<String>> productToBuyerMap) {
        ProductToBuyer productToBuyer = new ProductToBuyer(getUser(), getTradeProduct());
        visitor.visitorFacade(productToBuyer, productToBuyerMap);
    }
}
