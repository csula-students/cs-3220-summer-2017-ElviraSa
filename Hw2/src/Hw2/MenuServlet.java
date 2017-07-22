package Hw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = { "/menu" })
public class MenuServlet extends HttpServlet {
	public void init() {
		// init the application scope to have pre-set values
		List<FoodItem> entries = new ArrayList<>();
		entries.add(new FoodItem(entries.size(), "Creme Brulee",
				"Dessert consisting of a rich custard base topped with a contrasting layer of hard caramel",
				"http://media.gettyimages.com/photos/creme-brulee-picture-id155416240", 3.00));
		entries.add(new FoodItem(entries.size(), "Chocolate Brownie",
				"A brownie is a square baked dessert. It is a cross between a cake and a soft cookie in texture and comes in a variety of forms.",
				"http://goodtoknow.media.ipcdigital.co.uk/111/00001366c/13a0/Chocolate-brownies.jpg", 2.50));
		entries.add(new FoodItem(entries.size(), "Chocolate Chip",
				"A chocolate chip cookie is a drop cookie that originated in the United States and features chocolate chips",
				"https://images-gmi-pmc.edge-generalmills.com/eb52c020-c145-440c-8445-911f133c0096.jpg", 1.50));
		getServletContext().setAttribute("entries", entries);
	}

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
		// tell browser this is html document
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");

		out.println("<h1> Elvira's Bakery! </h1>");
		out.println("<h2> Menu:</h2>");
		out.println("<table>");
		out.println("<thead>" + "<tr>" + "<th>Image</th>" + "<th>Name</th?>" + "<th>Description</th>" + "<th>Price</th>"
				+ "<th>Add</th>" + "</tr>" + "</thead>");
		out.println("<tbody>");
		for (FoodItem entry : entries) {
			out.println("<tr>" + "<td><img src='" + entry.getImageUrl() + "'width='70' height='70'>" + "</td>" + "<td>"
					+ entry.getName() + "</td>" + "<td>" + entry.getDescription() + "</td>" + "<td>" + entry.getPrice()
					+ "</td>" + "<td><a href='cart?id=" + entry.getId() + "'>Add</a>" + "</td>" + "</tr>");

		}
		out.println("</tbody>");
		out.println("</table>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
		doGet(request, response);

	}

}
