package lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/CreatMenuServlet" })
public class CreatNewFoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jdbc/CreatNew.jsp")
        .forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        
        Food newFood = new Food(-1,item, description,image,Double.parseDouble(price),Integer.parseInt(quantity));

        FoodItemDao dao = new FoodItemDao();
        dao.add(newFood);
        response.sendRedirect(request.getContextPath() + "/NewInventory");	
	}

}
