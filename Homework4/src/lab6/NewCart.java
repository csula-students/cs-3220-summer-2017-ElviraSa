package lab6;

import java.io.IOException;
import java.sql.Date;
//import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(urlPatterns = { "/NewCart" })
public class NewCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Food> cartItems = (List<Food>) request.getSession().getAttribute("cartItems");
		String id = request.getParameter("delete");
		if(id != null)
		{
			for (Iterator<Food> iter =cartItems.listIterator(); iter.hasNext(); ) {
			    Food item = iter.next();
			    if (item.getId()==Integer.parseInt(id)) {
			        iter.remove();
			    }
			}
		}
		
		request.getSession().setAttribute("cartItems", cartItems);
		request.getRequestDispatcher("/WEB-INF/jdbc/NewCart.jsp")
        .forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Food> cartItems = (List<Food>) request.getSession().getAttribute("cartItems");
		String customerName = request.getParameter("customerName");
		Date date= new Date(0);
		OrderDao dao=new OrderDao();
		for(int i=0;i<cartItems.size();i++){
			NOrder order= new NOrder(-1,cartItems.get(i).getId(),cartItems.get(i).getImage(),customerName,date,"IN_QUEUE");
			dao.add(order);
		}
		 
		response.sendRedirect(request.getContextPath() + "/NewOrderAdmin");
}
}
