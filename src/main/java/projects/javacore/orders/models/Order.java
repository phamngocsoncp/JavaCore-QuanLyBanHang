package projects.javacore.orders.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Integer id;
	private String customerName;
	private String phone;
	private String email;
	
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	
	public Order(Integer id, String customerName, String phone, String email) {
		this.id = id;
		this.customerName = customerName;
		this.phone = phone;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
