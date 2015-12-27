package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.DaoImplementation;
import model.admin;
import util.UserUtil;
@WebServlet("/admincontroller")
public class admincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    String aemail;
    String apass;
    Statement stmt;
    ResultSet rs;
    RequestDispatcher dispatch;
    public admincontroller(){
		con= UserUtil.getConnection();
		
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aemail=request.getParameter("email");        
		apass=request.getParameter("password");
		ServletContext context = getServletContext();
		DaoImplementation dao = new DaoImplementation();
		admin admin;
		admin = dao.checkadmin(aemail, apass);
		if(!admin.getAdminemail().isEmpty()){
			context.setAttribute("admin",request.getParameter("email"));
			dispatch=request.getRequestDispatcher("Admin.jsp");
			dispatch.forward(request,response);
		}
		else{
		 	dispatch=request.getRequestDispatcher("Adminloginerror.jsp");
			dispatch.forward(request,response);
		}
		
		
}
}