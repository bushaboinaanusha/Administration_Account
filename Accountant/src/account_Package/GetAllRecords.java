package account_Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetAllRecords")

public class GetAllRecords extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		List<AccountantBean> list = AccountantDao.getAllRecords();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>View Accountant</title>");
		pw.println("<table class='table table-bordered table-striped'>");
		pw.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>address</th><th>contact</th><th>Edit</th><th>Delete</th>");
		for(AccountantBean bean:list){
			pw.print("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a href='EditAccountantForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteAccountant?id="+bean.getId()+"'>Delete</a></td></tr>");
		}
		pw.println("</table>");
		pw.println("</html>");
		
		pw.close();
		req.getRequestDispatcher("Home.html").include(req, resp);
		

	}

}
