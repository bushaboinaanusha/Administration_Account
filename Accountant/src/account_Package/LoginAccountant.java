package account_Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAccountant extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		boolean status = AccountantDao.validate(email, password);
		if (status) {
			HttpSession session = req.getSession();

			req.getRequestDispatcher("Home.html").include(req, resp);
		} else {

			pw.println("<p>Sorry, username or password error!</p>");
			req.getRequestDispatcher("index.html").include(req, resp);
			pw.close();
		}
	}

}

