
public class Product {
	
	//fields:
	private String name;
	private String category;
	private String description;
	private double price;
	private boolean taxable;
	
	//constructors:
	public Product(String name, String category, String description, double price, boolean taxable) {
		setName(name);
		setCategory(category);
		setDescription(description);
		setPrice(price);
		setTaxable(taxable);
	}
	
	//getters/setters:
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getTaxable() {
		return taxable;
	}
	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
}
