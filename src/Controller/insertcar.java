package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoImplementation;
import Dao.rdao;
import model.inscar;

@WebServlet("/insertcar")
public class insertcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private rdao lo;   
    
	public insertcar() {
    	 lo=new DaoImplementation();
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			inscar i = new inscar();
			i.setBrand(request.getParameter( "brand" ));
			i.setPrice(request.getParameter( "price" ));
			i.setColor(request.getParameter( "color" ));
			i.setFueltype(request.getParameter( "fueltype" ));
			i.setDecp(request.getParameter( "decp" ));
			lo.insertcars(i);
	       System.out.println("cars insert in admin");
	       response.sendRedirect("carinserted.jsp");

		}

}
