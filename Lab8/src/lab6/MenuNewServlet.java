package lab6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(urlPatterns = { "/MenuNewServlet" })
public class MenuNewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodItemDao dao = new FoodItemDao();
		request.setAttribute("list", dao.list());


        request.getRequestDispatcher("/WEB-INF/jdbc/MenuNew.jsp")
            .forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Food> cartItems = (List<Food>) request.getSession().getAttribute("cartItems");
		FoodItemDao dao = new FoodItemDao();
		int id = Integer.parseInt(request.getParameter("Add"));
		Food item= dao.get(id).get();
		 if(cartItems==null)
			 cartItems=new ArrayList<>();
		 
		 cartItems.add(item);
				
		request.getSession().setAttribute("cartItems", cartItems);
	       
	       response.sendRedirect(request.getContextPath() + "/NewCart");	
}
}