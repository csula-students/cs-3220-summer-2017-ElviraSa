package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RandomRestaurantServlet
 */
@WebServlet("/RandomRestaurantServlet")
public class RandomRestaurantServlet extends HttpServlet {
	public void init() {
		int[] designRatings = {1,2,3,4,5};
		int[] tasteRatings ={1,2,3,4,5};
		// init the application scope to have pre-set values
		List <ListOfRest> restaurants = new ArrayList<>();
		restaurants.add(new ListOfRest(restaurants.size(),"xstu01" , "http://cs3.calstatela.edu:8080/cs3220xstu01/menu",designRatings,tasteRatings ));
		restaurants.add(new ListOfRest(restaurants.size(),"xstu01" , "http://cs3.calstatela.edu:8080/cs3220xstu01/menu",designRatings,tasteRatings ));
		restaurants.add(new ListOfRest(restaurants.size(),"xstu01" , "http://cs3.calstatela.edu:8080/cs3220xstu01/menu",designRatings,tasteRatings ));
		getServletContext().setAttribute("restaurants", restaurants);
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
	
		response.setContentType("text/html");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> What's for launch? </h1>");
		out.println("<img > What's for launch? </h1>");
		
		
		
		out.println("<a href='Lucky'>Filling lucky</a>"+ "</br>" + "<a href='RandomRestaurantListServlet'>See the list</a>");
		

	}
}
