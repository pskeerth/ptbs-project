package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Product {
    private int nCategoryType;
    private String item;

    public Product(){}
    public Product(int nCategoryType, String item) {
        this.nCategoryType = nCategoryType;
        this.item = item;
    }

    public void setnCategoryType(int nCategoryType) {
        this.nCategoryType = nCategoryType;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getnCategoryType() {
        return nCategoryType;
    }

    public String getItem() {
        return item;
    }


}
