package Lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/foods/edit" })
public class EditFoodAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreatFoodItem> entries = (List<CreatFoodItem>) getServletContext().getAttribute("entries");

		CreatFoodItem leEntry = null;
		for (CreatFoodItem entry : entries) {
			if (entry.getId() == id) {
				leEntry = entry;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");

		out.println("<h1> Order </h1>");
		out.println("<table>");
		out.println("<thead>" + "<tr>" + "<th>Image</th>" + "<th>Name</th?>" + "<th>Description</th>" + "<th>Price</th>"
				+ "<th>Delete</th>" + "</tr>" + "</thead>");

		out.println("<tr>" + "<td><img src='" + leEntry.getImageUrl() + "'width='70' height='70'>" + "</td>" + "<td>"
				+ leEntry.getName() + "</td>" + "<td>" + leEntry.getDescription() + "</td>" + "<td>"
				+ leEntry.getPrice() + "</td>" + "<td><a href='delete?id=" + leEntry.getId() + "'>Delete</a> " + "</td>"
				+ "</tr>");

		out.println("</table>");
		out.println("<a href='menu'>back to menu</a>");

	}

}
