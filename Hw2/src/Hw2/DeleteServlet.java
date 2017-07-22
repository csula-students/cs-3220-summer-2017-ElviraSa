package Hw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/deleteServlet" })
public class DeleteServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		List<FoodItem> cartItem = (List<FoodItem>) getServletContext().getAttribute("cartItem");
		int index = -1;
		for (int i = 0; i < cartItem.size(); i++) {
			if (cartItem.get(i).getId() == id) {
				index = i;
			}
		}
		cartItem.remove(index);
		getServletContext().setAttribute("cartItem", cartItem);

		response.setContentType("text/html");
		out.println("<h1>Your item was delete</h1>");
		out.println("<a href='menu'>go back to menu</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FoodItem> cartItem = (List<FoodItem>) getServletContext().getAttribute("cartItem");
		doGet(request, response);
	}

}
