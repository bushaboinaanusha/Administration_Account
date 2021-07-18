package account_Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Edit")
public class Edit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String contact = req.getParameter("contact");
		AccountantBean bean = new AccountantBean(id,name,email,password,address,contact);
	int status = AccountantDao.update(bean);
	req.getRequestDispatcher("GetAllRecords").include(req, resp);
	}

}
