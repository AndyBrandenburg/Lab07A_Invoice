public class Address {
    private String customerName;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String customerName, String street, String city, String state, String zipCode){
        this.customerName = customerName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getStreet(){
        return street;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getZipCode(){
        return zipCode;
    }
    public void setAddress(String customerName, String street, String city, String state, String zipCode){
        this.customerName = customerName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
