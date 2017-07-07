package Lab3;

public class CreatFoodItem {
	final int id;
	final String name;
	final String description;
	final String imageUrl;
	final String price;
	 


	public CreatFoodItem(int id, String name, String description, String imageUrl, String price) {
	
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
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



	public String getPrice() {
		return price;
	}
	

}
