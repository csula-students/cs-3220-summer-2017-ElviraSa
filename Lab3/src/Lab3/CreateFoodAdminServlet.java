package Lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet(urlPatterns={"/admin/foods/creat"})

public class CreateFoodAdminServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Creat Food Item</h1>");
		out.println("<form method=\"post\">");
		out.println("Name: <input name='name' type='text'/></br>");
		out.println("Description:</br>");
		out.println("<textarea name='description'></textarea></br>");
		out.println("Image URL:<input name = 'url' type='url'></input> </br>");
		out.println("Price<input name='price' type='number'/></br>");
		out.println("<a href='list'>Add</a> ");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CreatFoodItem> entries = (List<CreatFoodItem>) getServletContext().getAttribute("entries");
		entries.add(new CreatFoodItem(entries.size(), request.getParameter("name"), request.getParameter("description"),request.getParameter("url"),request.getParameter("price")));
		getServletContext().setAttribute("entries", entries);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<a location.href='list'> go to Inventory</a>");
			
		
	}
	
}