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
import model.register;
import util.UserUtil;

@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    String user;
    String pass;
    Statement stmt;
    ResultSet rs;
    RequestDispatcher dispatch;
    
    public User(){
		con= UserUtil.getConnection();
		
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user=request.getParameter("username");        
		pass=request.getParameter("password");
		DaoImplementation dao = new DaoImplementation();
		register Register;
		Register = dao.checkuser(user, pass);
		
		
		if (Register.isFlag()) {
			int rid = Register.getRid();
			request.setAttribute("rid", rid);
			dispatch = request.getRequestDispatcher("User.jsp");
			dispatch.forward(request, response);
		} 
		else {
			dispatch = request.getRequestDispatcher("Logerror.jsp");
			dispatch.forward(request, response);
			System.out.println("first register ");
		}
}
}