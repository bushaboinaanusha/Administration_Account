package account_Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(req, resp);
	resp.setContentType("text/html");
	PrintWriter pw= resp.getWriter();
String sid = req.getParameter("id");
int id = Integer.parseInt(sid);
AccountantDao.delete(id);
req.getRequestDispatcher("Home.html").include(req, resp);

}
}
