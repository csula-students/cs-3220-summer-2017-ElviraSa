package lab6;
public class Food {
final int id;
final String item;
final String description;
final String image;
final double price;
int quantity;

public Food(int id, String item, String description, String image, double price,int quantity) {

	this.id = id;
	this.item = item;
	this.description = description;
	this.image = image;
	this.price = price;
	this.quantity=quantity;
}

public int getId() {
	return id;
}

public String getName() {
	return item;
}

public String getDescription() {
	return description;
}
public String getItem(){
	
	return item;
}

public String getImage() {
	return image;
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
