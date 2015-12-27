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


import model.cars;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet("/carupload")
public class hirecar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private rdao lo;
  
    public hirecar() {
       lo=new DaoImplementation();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	cars r = new cars();
		r.setFname(request.getParameter("fname"));
		r.setLname(request.getParameter("lname"));
		r.setPickloc( request.getParameter( "pickloc" ) );
        r.setDroploc( request.getParameter( "droploc" ) );
        r.setPickdate( request.getParameter( "pickdate" ) );
        r.setCarbrand( request.getParameter("carbrand"));
        r.setTransmission( request.getParameter( "transmission" ) );

        lo.addcars(r);
       System.out.println("cars insert");
       response.sendRedirect("Confirmation.jsp");
		
	
	}

}
