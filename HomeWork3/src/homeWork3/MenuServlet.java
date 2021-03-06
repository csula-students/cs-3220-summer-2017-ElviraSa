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

@WebServlet(urlPatterns = { "/MenuServlet" })
public class MenuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> items = (List<FoodItem>) request.getSession().getAttribute("items");
		if (items == null) {
			items = new ArrayList<>();
			items.add(new FoodItem(items.size(), "Creme Brulee",
					"Dessert consisting of a rich custard base topped with a contrasting layer of hard caramel",
					"http://media.gettyimages.com/photos/creme-brulee-picture-id155416240", 3.00,0));
			items.add(new FoodItem(items.size(), "Chocolate Brownie",
					"A brownie is a square baked dessert. It is a cross between a cake and a soft cookie in texture and comes in a variety of forms.",
					"http://goodtoknow.media.ipcdigital.co.uk/111/00001366c/13a0/Chocolate-brownies.jpg", 2.50,0));
			items.add(new FoodItem(items.size(), "Chocolate Chip",
					"A chocolate chip cookie is a drop cookie that originated in the United States and features chocolate chips",
					"https://images-gmi-pmc.edge-generalmills.com/eb52c020-c145-440c-8445-911f133c0096.jpg", 1.50,0));
		}
		request.getSession(true).setAttribute("items", items);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Menu.jsp");

		dispatcher.forward(request, response);

	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<FoodItem> food = (List<FoodItem>) request.getSession().getAttribute("food");
		if (food == null)
			food = new ArrayList<FoodItem>();
		List<FoodItem> items = (List<FoodItem>) request.getSession().getAttribute("items");
		String foodName = request.getParameter("Add");

		request.setAttribute("foodName", foodName);

		for (int i = 0; i < items.size(); i++) {
			FoodItem item = items.get(i);
			if (item.getName().equals(foodName)) {
				
				item.setQuantity(item.getQuantity()+1);
				if(!food.contains(item))
				food.add(item);
				else
				{
					int currentQuantity=item.getQuantity();
				items.get(i).setQuantity(currentQuantity+1);
				}
				
			}
		}
		request.getSession().setAttribute("food", food);

		response.sendRedirect(request.getContextPath() + "/CartServlet");

	}

}
