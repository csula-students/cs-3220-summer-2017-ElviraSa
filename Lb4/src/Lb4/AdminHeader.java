package Lb4;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdminHeader extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<h1>Elvira's Bakery!</h1>");
		out.println(
				"<img src='http://www.alessibakeries.com/wp-content/uploads/2016/03/bakery-deli-Button-1.jpg' 'width='70' height='70>");
		out.println(
				"<a href='http://localhost:8080/Lb4/RestuarantAdminServlet'> AdminInventory </a>|<a href='http://localhost:8080/Lab4/AdminCreatFoodServlet'> Admin Creat Food </a>|<a href='http://localhost:8080/Lb4/AdminStatusesServlet'>Admin Statuses</a>");
		
	}
}
