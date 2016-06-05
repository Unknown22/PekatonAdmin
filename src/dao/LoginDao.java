package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Login;
import util.DbUtil;

public class LoginDao {
private Connection connection;
	
	public LoginDao(){
		connection = DbUtil.getConnection();
	}
	
	public boolean validate(Login login){  
		boolean status=false; 
		
		try{  		              
		PreparedStatement ps=connection.prepareStatement(  
		    "select * from admin where login = '" + login.getLogin() + "' and haslo = '" + login.getPassword() + "'");  
		 
//		ps.setInt(1, login.getId());  
//		ps.setString(2, login.getLogin());
//		ps.setString(3, login.getPassword());  
		
		              
		ResultSet rs=ps.executeQuery();  		
		status=rs.next();  
		              
		}catch(Exception e){
			System.out.println("Blad przy logowaniu");
			e.printStackTrace();
		}  
		
		System.out.println("LoginDao: status: " + status);
		return status;  
		  
	}

}