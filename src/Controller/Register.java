package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoImplementation;
import Dao.rdao;
import model.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private rdao lo;
  
    public Register() {
       lo=new DaoImplementation();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	register r = new register();
		r.setUsername( request.getParameter( "username" ) );
        r.setPassword( request.getParameter( "password" ) );
        r.setFname( request.getParameter( "fname" ) );
        r.setLname( request.getParameter("lname"));
        r.setDob( request.getParameter( "dob" ) );
        r.setEmail( request.getParameter( "email" ) );
        r.setCNIC( request.getParameter( "cnic" ) );
        r.setContact( request.getParameter( "contact" ) );
        r.setAddress( request.getParameter( "address" ) );
        r.setGender( request.getParameter( "gender" ) );
        
       lo.addUser(r);
       System.out.println("registration ");
       response.sendRedirect("Reg.jsp");
		
	
	}

}
