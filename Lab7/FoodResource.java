package edu.csula.jaxrs;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("fooditems")

public class FoodResource {
	
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public List<FoodItem> getMenu() {
		FoodItemDao dao = new FoodItemDao();
		return dao.list();
	}
	
	@GET
	@Path("fooditem/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FoodItem getItem(@PathParam("id") int id) {
		FoodItemDao dao = new FoodItemDao();
		return dao.get(id).get();
	}
	@POST
    @Path("fooditem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addFood(FoodItem newFood) {
		FoodItemDao dao = new FoodItemDao();
        dao.add(newFood);
        return true;
}
	@PUT
	     @Path("fooditem/{id}")
	     @Produces(MediaType.APPLICATION_JSON)
	     public boolean updateFood(FoodItem item, @PathParam("id") int id) {
		FoodItemDao dao = new FoodItemDao();
        dao.update(item);;
	         return true;
	     }
	@DELETE
    @Path("fooditem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteFoodItem(@PathParam("id") int id){
        FoodItemDao dao = new FoodItemDao();
        dao.delete(id);
        return true;
}
}