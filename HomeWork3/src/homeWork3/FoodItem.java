package homeWork3;


public class FoodItem {
final int id;
final String name;
final String description;
final String imageUrl;
final double price;
int quantity;

public FoodItem(int id, String name, String description, String imageUrl, double price,int quantity) {

	this.id = id;
	this.name = name;
	this.description = description;
	this.imageUrl = imageUrl;
	this.price = price;
	this.quantity=quantity;
}

public int getId() {
	return id;
}

public String getName() {
	return name;
}

public String getDescription() {
	return description;
}

public String getImageUrl() {
	return imageUrl;
}

public double getPrice() {
	return price;
}
public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}


