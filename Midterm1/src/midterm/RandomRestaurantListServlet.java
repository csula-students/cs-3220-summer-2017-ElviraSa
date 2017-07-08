package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class RandomRestaurantListServlet
 */
@WebServlet("/RandomRestaurantListServlet")
public class RandomRestaurantListServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<ListOfRest> restauratns = (List<ListOfRest>) getServletContext().getAttribute("entries");
		// tell browser this is html document
		response.setContentType("text/html");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");

		out.println("<h1> What's for launch? </h1>");
		out.println("<table>");
		out.println("<thead>" + "<tr>" + "<th>Name</th>" + "<th>URL</th>" + "<th>Desing</th>" + "<th>Test</th>"
				+ "<th>Reviewers</th>" + "</tr>" + "</thead>");
		for (ListOfRest restaurant : restauratns) {
			out.println("<tr>" + "<td>" + restaurant.getName()  + "</td>" + "<td>"
					+ restaurant.getURL() + "</td>" + "<td>" + restaurant.getDesignRatings() + "</td>" + "<td>" + restaurant.getTasteRatings()
					+ "</td>" + "<td>" + "</td>" + "</tr>");
		}
		
		out.println("</table>");
		out.println("<a href='Lucky'>Filling lucky</a>"+ "</br>");

	}
	
}

