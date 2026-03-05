public class LineItem extends LineItemTableDialog {
    //-Store product, quantity, and price
    private Product product;
    private int quantity;
    private double price;

    public LineItem(Product product, int quantity) {
        super(null, null);
        this.product = product;
        this.quantity = quantity;
        calculateTotalPrice();
    }

    public double calculateTotalPrice() {
        this.price = product.getPrice() * quantity;
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return calculateTotalPrice();
    }
}
