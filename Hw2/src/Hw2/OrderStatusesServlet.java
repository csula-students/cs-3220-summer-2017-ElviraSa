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


@WebServlet(urlPatterns = { "/orderStatus" })
public class OrderStatusesServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		List<Order> order = (List<Order>) getServletContext().getAttribute("order");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");

		out.println("<h1> Elvira's Bakery! </h1>");
		out.println("<h2> Order:</h2>");
		out.println("<table>");
		out.println("<thead>" + "<tr>" + "<th>Created</th>" + "<th>Items</th?>" + "<th>Customer</th>" + "<th>Status</th>"
				+ "</tr>" + "</thead>");
		out.println("<tbody>");
		for (Order od : order) {
			out.println("<tr>" + "<td> " + od.getCreated() +
					"</td>"+"<td> <img src='" + od.getItems().get(0).getImageUrl() + "'width='70' height='70'> "+ "</td>"+
					"<td>" + od.getCustomName() + "</td>" + "<td>" + od.getStatuses() + "</td>" + "<td>");

		}
		out.println("</tbody>");
		out.println("</table>");
	


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Order> order = (List<Order>) getServletContext().getAttribute("order");
		doGet(request, response);
	}

}
