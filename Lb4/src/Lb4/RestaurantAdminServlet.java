package Lb4;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RestaurantAdminServlet")
public class RestaurantAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> items = (List<FoodItem>) request.getSession().getAttribute("items");
		if (items == null) {
			items = new ArrayList<>();
			items.add(new FoodItem(items.size(), "Creme Brulee",
					"Dessert consisting of a rich custard base topped with a contrasting layer of hard caramel",
					"http://media.gettyimages.com/photos/creme-brulee-picture-id155416240", 3.00));
			items.add(new FoodItem(items.size(), "Chocolate Brownie",
					"A brownie is a square baked dessert. It is a cross between a cake and a soft cookie in texture and comes in a variety of forms.",
					"http://goodtoknow.media.ipcdigital.co.uk/111/00001366c/13a0/Chocolate-brownies.jpg", 2.50));
			items.add(new FoodItem(items.size(), "Chocolate Chip",
					"A chocolate chip cookie is a drop cookie that originated in the United States and features chocolate chips",
					"https://images-gmi-pmc.edge-generalmills.com/eb52c020-c145-440c-8445-911f133c0096.jpg", 1.50));
		}
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
		request.getRequestDispatcher("WEB-INF/AdminInventory.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/AdminCreateFoodServlet");

	}

	
}