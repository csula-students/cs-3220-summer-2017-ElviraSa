package homeWork3;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(urlPatterns = { "/InventoryA" })
public class InventoryA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> items = (List<FoodItem>) request.getSession().getAttribute("items");
		String deletedRecipeName=request.getParameter("Submit");
		if(deletedRecipeName!=null)
		{
			for (Iterator<FoodItem> iter =items.listIterator(); iter.hasNext(); ) {
			    FoodItem item = iter.next();
			    if (item.getName().equals(deletedRecipeName)) {
			        iter.remove();
			    }
			}
		}
		
		request.getSession(true).setAttribute("items", items);
		request.getSession().setAttribute("date", new Date());
		request.getRequestDispatcher("WEB-INF/InventoryA.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/CreatFoodA");
	}

}
