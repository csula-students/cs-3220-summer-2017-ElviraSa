package lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewInventory
 */
@WebServlet(urlPatterns = { "/NewInventory" })
public class NewInventory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodItemDao dao = new FoodItemDao();
		request.setAttribute("list", dao.list());

        request.getRequestDispatcher("/WEB-INF/jdbc/NewInventory.jsp")
            .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodItemDao dao = new FoodItemDao();
		 request.setAttribute("list", dao.list());
		int id = Integer.parseInt(request.getParameter("Submit"));
	       dao.delete(id);
	       response.sendRedirect(request.getContextPath() + "/MenuNewServlet");	
	      
		
	}

}
