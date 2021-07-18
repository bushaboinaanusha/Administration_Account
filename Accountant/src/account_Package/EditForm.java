package account_Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditForm")
public class EditForm extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	PrintWriter pw= resp.getWriter();
	String sid = req.getParameter("id");
	int id = Integer.parseInt(sid);
	AccountantBean bean = AccountantDao.getRecordsById(id);
	pw.print("<html><body><h1>Edit Accountant</h1>");
	pw.print("<form action ='edit' method='post'>");

	pw.print("<table>");
	pw.print("<tr><td><input type='hidden' name='id' value='"+bean.getId()+"' /></td></tr>");
	pw.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+bean.getName()+"'/></td></tr>");
	pw.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+bean.getEmail()+"'/></td></tr>");
	pw.print("<tr><td>Password:</td><td><input type='text' name='password' value='"+bean.getPassword()+"'/></td></tr>");
	pw.print("<tr><td>Address:</td><td><textarea name='address' style='width:300px;height:100px;'>"+bean.getAddress()+"</textarea></td></tr>");
	pw.print("<tr><td>Contact No:</td><td><input type='text' name='contact' value='"+bean.getContact()+"'/></td></tr>");
	pw.print("<tr><td colspan='2' align='center'><input type='submit' value='Update Accountant' class='btn btn-default'/></td></tr>");
	pw.print("</table>");
	pw.print("</form>");
	pw.print("</body></html>");
	pw.println("</div>");

	pw.close();
}
}
