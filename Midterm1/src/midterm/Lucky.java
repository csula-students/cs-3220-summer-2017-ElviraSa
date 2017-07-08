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
 * Servlet implementation class Lucky
 */
@WebServlet("/Lucky")
public class Lucky extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<ListOfRest> restauratns = (List<ListOfRest>) getServletContext().getAttribute("restaurants");
		// tell browser this is html document
		response.setContentType("text/html");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");

		out.println("<h1> What's for launch? </h1>");
		out.println("<h3>You shoud go to</h3>");
		out.println("<img src='https://images-gmi-pmc.edge-generalmills.com/eb52c020-c145-440c-8445-911f133c0096.jpg' width='70' height='70'>");
		out.println("<a href='http://cs3.calstatela.edu:8080/cs3220xstu22/menu''>Restaurant link</a>");
		out.println("<form method=\"post\">");
		out.print("<h2>Desing</2");
		out.println("<input name='designRate' id='design_rate_1' type='radio' value='1' checked>");
		out.println("<label for='design_rate_1'>1</label>");
		out.println("<input name='designRate' id='design_rate_2' type='radio' value='2' checked>");
		out.println("<label for='design_rate_2'>2</label>");
		out.println("<input name='designRate' id='design_rate_3' type='radio' value='3' checked>");
		out.println("<label for='design_rate_3'>3</label>");
		out.println("<input name='designRate' id='design_rate_4' type='radio' value='4' checked>");
		out.println("<label for='design_rate_4'>4</label>");
		out.println("<input name='designRate' id='design_rate_5' type='radio' value='5' checked>");
		out.println("<label for='design_rate_5'>5</label>")	;	
        out.println("</form>");
        out.print("<h2>Food Taste</2");
		out.println("<input name='designRate' id='design_rate_1' type='radio' value='1' checked>");
		out.println("<label for='design_rate_1'>1</label>");
		out.println("<input name='designRate' id='design_rate_2' type='radio' value='2' checked>");
		out.println("<label for='design_rate_2'>2</label>");
		out.println("<input name='designRate' id='design_rate_3' type='radio' value='3' checked>");
		out.println("<label for='design_rate_3'>3</label>");
		out.println("<input name='designRate' id='design_rate_4' type='radio' value='4' checked>");
		out.println("<label for='design_rate_4'>4</label>");
		out.println("<input name='designRate' id='design_rate_5' type='radio' value='5' checked>");
		out.println("<label for='design_rate_5'>5</label>")	;	
        out.println("</form>");
        out.println("</br>");
		out.println("<a href='RandomRestaurantListServlet'>See the list</a>");
		
	}

}