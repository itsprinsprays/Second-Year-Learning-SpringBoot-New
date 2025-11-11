package SpringbootJDBC1.model;

public class Customer {
	
	private String customerName, paymentMethod;
	private int orderNumber;
	
	public Customer(String customerName, int orderNumber, String paymentMethod) {
		this.customerName = customerName;
		this.orderNumber = orderNumber;
		this.paymentMethod = paymentMethod;
	}
	
	public String getCustomerName() { return customerName; }
	public int getOrderNumber() { return orderNumber; }
	public String getPaymentMethod() { return paymentMethod; }
	
	public void setCustomerName(String customerName) { this.customerName = customerName; }
	public void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }
	public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

}
