package homeWork3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeWork3.Order.Statuses;



@WebServlet(urlPatterns = { "/CartServlet" })
public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FoodItem> food = (List<FoodItem>) request.getSession().getAttribute("food");
		if(food!=null){
		String deletedRecipeName=request.getParameter("delete");
		if(deletedRecipeName!=null)
		{
			for (Iterator<FoodItem> iter =food.listIterator(); iter.hasNext(); ) {
			    FoodItem item = iter.next();
			    if (item.getName().equals(deletedRecipeName)) {
			        iter.remove();
			    }
			}
		}
		
		request.getSession().setAttribute("food", food);
		request.getRequestDispatcher("/WEB-INF/Cart.jsp").forward(request, response);

	       
		
	}
	}
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Order> orderList = (List<Order>)request.getSession().getAttribute("orderList");
		if(orderList==null)
		orderList= new ArrayList<Order>();
		List<FoodItem> food = (List<FoodItem>) request.getSession().getAttribute("food");
		String customerName = request.getParameter("customerName");
		Order order=new Order(1,food,customerName,new Date(),Statuses.IN_QUEUE);
		if(!orderList.contains(order))
			orderList.add(order);
	
	request.getSession().setAttribute("orders", orderList);

	
	request.getSession().setAttribute("customerName", customerName);
	
	response.sendRedirect(request.getContextPath() + "/OrderStatusesAdminServlet");		
	}

}