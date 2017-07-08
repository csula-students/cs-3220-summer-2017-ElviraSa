package Lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/foods/list" })
public class FoodItemListAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<CreatFoodItem> entries = (List<CreatFoodItem>) getServletContext().getAttribute("entries");
		// tell browser this is html document
		response.setContentType("text/html");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");

		out.println("<h1> Inventory </h1>");
		out.println("<table>");
		out.println("<thead>" + "<tr>" + "<th>Image</th>" + "<th>Name</th?>" + "<th>Description</th>" + "<th>Price</th>"
				+ "<th>Delete</th>" + "</tr>" + "</thead>");
		for (CreatFoodItem entry : entries) {

			out.println("<tr>" + "<td><img src='" + entry.getImageUrl() + "'width='70' height='70'>" + "</td>" + "<td>"
					+ entry.getName() + "</td>" + "<td>" + entry.getDescription() + "</td>" + "<td>" + entry.getPrice()
					+ "</td>" + "<td><a href='delete?id=" + entry.getId() + "'>Delete</a> " + "</td>" + "</tr>");
		}
		out.println("</table>");
		out.println("<a href='creat" + "'>Creat Food</a> ");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}