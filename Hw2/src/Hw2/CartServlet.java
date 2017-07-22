package Hw2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/cart" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");

		List<FoodItem> cartItem = new ArrayList<>();
		for (int i = 0; i < entries.size(); i++) {
			FoodItem item = entries.get(i);
			if (item.getId() == id) {
				cartItem.add(item);
			}
		}

		getServletContext().setAttribute("cartItem", cartItem);

		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");

		out.println("<h1> Elvira's Bakery! </h1>");
		out.println("<h2> Shoping Cart:</h2>");
		out.println("<table>");
		out.println("<thead>" + "<tr>" + "<th>Item</th>" + "<th>Price</th?>" + "<th>Quantity</th>" + "<th>Action</th>"
				+ "</tr>" + "</thead>");
		out.println("<tbody>");
		for (FoodItem entry : cartItem) {
			out.println("<tr>" + "<td><img src='" + entry.getImageUrl() + "'width='70' height='70'> </br>"
					+ entry.getName() + "</td>" + "<td>" + entry.getPrice() + "</td>" + "<td>"
					+ "<input name='quantiry' type='text'>" + "</td>" + "<td><a href='deleteServlet?id=" + entry.getId()
					+ "'>Detele</a> " + "</td>" + "</tr>");

		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("<a href='menu" + "'>back to menu</a> </br>");

		out.println("<form method=\"post\">");
		out.println("<label>Please enter your name:</label><br>");
		out.println("<input name='name' type='text'/></br><br>");
		out.println("<input type='submit'/>");
		out.println("</form>");
		out.println("<a href='orderStatus'>Place your order</a> ");
		out.println("</br>");
		out.println("<a href='addStatus'>For Admin to add status</a> ");
	
		List<Order> order = new ArrayList<>();

		order.add(new Order(order.size(), cartItem, request.getParameter("name"), new Date(), Order.Statuses.IN_QUEUE));
		getServletContext().setAttribute("order", order);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> order = (List<Order>) getServletContext().getAttribute("order");
		doGet(request, response);
		


		
	}
}