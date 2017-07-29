package homeWork3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeWork3.Order.Statuses;



@WebServlet(urlPatterns = { "/OrderStatusesAdminServlet" })
public class OrderStatusesAdminServlet extends HttpServlet {

	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			List<Order> orders = (List<Order>) request.getSession().getAttribute("orders");
			request.getSession().setAttribute("orders", orders);
		
			request.getRequestDispatcher("/WEB-INF/orderStatusAdmin.jsp").forward(request, response);
			}
		
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Order> orders=(List<Order>) request.getSession().getAttribute("orders");
		String statuses="COMPLETED";
		if(request.getParameter("statusValue")!=null)
		 statuses= request.getParameter("statusValue");
		Statuses newStatus=Statuses.valueOf(statuses);
		
		String name = request.getParameter("customerName");
		for(int i=0;i< orders.size();i++){
			Order odr=orders.get(i);
			if(odr.getCustomName().equalsIgnoreCase(name)){
				
				odr.setStatuses(newStatus);
				orders.remove(i);
				orders.add(odr);
			}
				
		}
		request.getSession().setAttribute("orders", orders);
		
		response.sendRedirect(request.getContextPath() + "/OrderStatusesServlet");	
		
	}

}
