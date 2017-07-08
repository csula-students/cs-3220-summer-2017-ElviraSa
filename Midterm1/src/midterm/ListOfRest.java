package midterm;



public class ListOfRest {
	final int ID;
	final String Name;
	final String URL;
	int[] designRatings = {1,2,3,4,5};
	int[] tasteRatings ={1,2,3,4,5};
	public ListOfRest(int iD, String name, String uRL,int[]designRatings,int [] tasteRatings ) {
		
		this.ID = iD;
		this.Name = name;
		this.URL = uRL;
		this.designRatings =tasteRatings;
		this.tasteRatings =tasteRatings;
	
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
	public String getURL() {
		return URL;
	}
	public int[] getDesignRatings() {
		return designRatings;
	}
	public int[] getTasteRatings() {
		return tasteRatings;
	}
	
	




}
