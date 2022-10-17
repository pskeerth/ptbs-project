package facade;

public class Product {
    private int nCategoryType;
    private String item;

    public int getnCategoryType() {
        return nCategoryType;
    }

    public String getItem() {
        return item;
    }

    public Product(int nCategoryType, String item) {
        this.nCategoryType = nCategoryType;
        this.item = item;
    }
}
