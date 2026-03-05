import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Invoice {
    private String title;
    private Address customerAddress;
    private ArrayList<LineItem> lineItems;
    public double totalAmount;

    public Invoice(String title, Address customerAddress, ArrayList<LineItem> lineItems) {
        this.title = title;
        this.customerAddress = customerAddress;
        this.lineItems = new ArrayList<>();
        calculateTotalAmount();
    }

    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public double calculateTotalAmount() {
        totalAmount = 0.0;
        for (LineItem item : lineItems) {
            totalAmount += item.getTotalPrice();
        }
        return totalAmount;
    }

    public String getTitle() {
        return title;
    }
    public Address getCustomerAddress() {
        return customerAddress;
    }
    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }
    public void setAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice Title: ").append(title).append("\n");
        sb.append("---------------------------------------------\n");
        sb.append("Customer: ").append(customerAddress.getCustomerName()).append("\n");
        sb.append("Address: ").append(customerAddress.getStreet()).append(", ")
                .append(customerAddress.getCity()).append(", ")
                .append(customerAddress.getState()).append(", ")
                .append(customerAddress.getZipCode()).append("\n");
        sb.append("---------------------------------------------\n");
        sb.append("Line Items:\n");
        for (LineItem item : lineItems) {
            sb.append("- ").append(item.getProduct().getName())
                    .append(": Quantity = ").append(item.getQuantity())
                    .append(", Price = ").append(item.getPrice())
                    .append("\n");
        }
        sb.append("\nTotal Amount: ").append(calculateTotalAmount()).append("\n");
        sb.append("--------------------------------------------\n");
        return sb.toString();
    }



}
