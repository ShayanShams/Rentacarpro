package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.UserUtil;
import model.register;
import model.admin;
import model.cars;
import model.inscar;

public class DaoImplementation implements rdao {
	
	private Connection conn;
	private ResultSet rs;
	PreparedStatement prep;
	 
    public DaoImplementation() {
        conn = UserUtil.getConnection();
    }
    //Registration
	public void addUser(register r) {
		 try {
	            String query = "insert into register(username,password,fname,lname,dob,email,cnic,contact,address,gender) values (?,?,?,?,?,?,?,?,?,?)";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, r.getUsername() );
	            preparedStatement.setString( 2, r.getPassword() );
	            preparedStatement.setString( 3, r.getFname() );
	            preparedStatement.setString( 4, r.getLname() );
	            preparedStatement.setString( 5, r.getDob() );
	            preparedStatement.setString( 6, r.getEmail() );
	            preparedStatement.setString( 7, r.getCNIC() );
	            preparedStatement.setString( 8, r.getContact() );
	            preparedStatement.setString( 9, r.getAddress() );
	            preparedStatement.setString( 10, r.getGender() );
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }}
	//Login
		 public register checkuser(String user, String pass){
		    	register rl = new register();
		    	rl.setFlag(false);
		    	try {
		            String sql = "select * from car.register where username='"+user+"'and password='"+pass+"'";
		            prep=conn.prepareStatement(sql);
				    rs = prep.executeQuery(sql);
		            
		            if (rs.next()) {
		            	rl.setRid(rs.getInt("rid"));
		            	rl.setUsername(rs.getString("username"));
		            	rl.setFlag(true);
							}
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		            System.out.println(e);
		        }
		    	return rl;
		    }
		public admin checkadmin(String aemail, String apass) {
			admin a = new admin();
	    	try {
	            String query = "select * from admin where email= ? and password = ?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, aemail );
	            preparedStatement.setString( 2, apass );
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	            a.setAdminemail(rs.getString("email"));
				a.setAdminpassword(rs.getString("password"));
						}
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	return a;
		}
		public void addcars(cars c) {
			 try {
		            String query = "insert into car(fname,lname,pickloc,droploc,pickdate,carbrand,transmission) values (?,?,?,?,?,?,?)";
		            PreparedStatement preparedStatement = conn.prepareStatement( query );
		            preparedStatement.setString( 1, c.getFname() );
		            preparedStatement.setString( 2, c.getLname() );		           
		            preparedStatement.setString( 3, c.getPickloc() );
		            preparedStatement.setString( 4, c.getDroploc() );
		            preparedStatement.setString( 5, c.getPickdate() );
		            preparedStatement.setString( 6, c.getCarbrand() );
		            preparedStatement.setString( 7, c.getTransmission());
		            preparedStatement.executeUpdate();
		            preparedStatement.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }}

		public void insertcars(inscar i) {
			 try {
		            String query = "insert into insertcar(brand,price,color,fueltype,decp) values (?,?,?,?,?)";
		            PreparedStatement preparedStatement = conn.prepareStatement( query );
		            preparedStatement.setString( 1, i.getBrand() );
		            preparedStatement.setString( 2, i.getPrice() );
		            preparedStatement.setString( 3, i.getColor() );
		            preparedStatement.setString( 4, i.getFueltype() );
		            preparedStatement.setString( 5, i.getDecp());
		            preparedStatement.executeUpdate();
		            preparedStatement.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }}


		
}
