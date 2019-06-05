package projects.javacore.orders.models;

public class Product {
	private Integer id;
	private String name;
	private Integer quantity;
	private String description;
	private Float price;
	
	public Product() {
		
	}
	
	public Product(Integer id, String name, Integer quantity, String description, Float price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
	}
	
	public Product(String name, Integer quantity, String description, Float price) {
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}
