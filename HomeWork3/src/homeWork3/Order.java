package homeWork3;
import java.util.ArrayList;
import java.util.List;



import java.util.Date;


public class Order {
	enum Statuses {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}
	int id;
	List <FoodItem> items = new ArrayList<>();
	 String customName;
	 Date created;
	 Statuses statuses; 
	public Order(int id,List<FoodItem> items,String customName,Date created,Statuses status) {
		
		this.id = id;
		this.items = items;
		this.customName = customName;
		this.created = created;
		this.statuses=status;
		
		
		
	
	}
	public int getId() {
		return id;
	}
	
	public List<FoodItem> getItems() {
		return items;
	}
	
	public String getCustomName() {
		return customName;
	}
	
	public Date getCreated() {
		return created;
	}
	public Statuses getStatuses() {
		return statuses;
	}
	public void setStatuses(Statuses status){
	this.statuses=status;
	}
	
}