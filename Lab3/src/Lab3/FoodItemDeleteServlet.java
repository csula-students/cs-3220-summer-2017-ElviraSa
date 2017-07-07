package Lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = { "/admin/foods/delete" })
public class FoodItemDeleteServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			List<CreatFoodItem> entries = (List<CreatFoodItem>) getServletContext().getAttribute("entries");
			int index = -1;
			for (int i = 0; i < entries.size(); i ++) {
				if (entries.get(i).getId() == id) {
					index = i;
				}
			}
			entries.remove(index);
			getServletContext().setAttribute("entries", entries);

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<a href='menu'>go back to inventory</a>");
		}
	}
