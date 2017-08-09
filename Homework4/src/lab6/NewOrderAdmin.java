package lab6;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/NewOrderAdmin" })
public class NewOrderAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDao dao = new OrderDao();
		request.setAttribute("list", dao.list());
		request.getRequestDispatcher("/WEB-INF/jdbc/NewOrderAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderDao dao = new OrderDao();
		List<NOrder> orders = dao.list();
		String[] statuses = request.getParameterValues("statusValue");

		int i = 0;
		for (NOrder nOrder : orders) {

			nOrder.setStatuse(statuses[i]);
			i++;
			dao.update(nOrder);
		}

		response.sendRedirect(request.getContextPath() + "/NewOrder");
	}

}
