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

@Path("orders")
public class OrderResource {
@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrders() {
		OrderDao dao = new OrderDao();
		return dao.list();
	}
	
	@GET
	@Path("order/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("id") int id) {
		OrderDao dao = new OrderDao();
		return dao.get(id).get();
	}
	@POST
    @Path("order")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addOrder(Order newOrder) {
		OrderDao dao = new OrderDao();
        dao.add(newOrder);
        return true;
}
	@PUT
	     @Path("order/{id}")
	     @Produces(MediaType.APPLICATION_JSON)
	     public boolean updateOrder(Order order) {
		OrderDao dao = new OrderDao();
        dao.update(order);;
	         return true;
	     }
	@DELETE
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteFoodItem(@PathParam("id") int id){
		OrderDao dao = new OrderDao();
        dao.delete(id);
        return true;
}
}


