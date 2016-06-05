package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Sprint;
import util.DbUtil;

public class SprintDao {
	private Connection connection;
	
	public SprintDao(){
		connection = DbUtil.getConnection();
	}
	
	public List<Sprint> getSprintAll(){
		List<Sprint> sprinty = new ArrayList<Sprint>();
		
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM sprint;");
			
			while (rs.next()) {
				Sprint sprint = new Sprint (rs.getInt("id"),
											rs.getString("poczatek"),
											rs.getString("koniec"));
				sprinty.add(sprint);
			}
			
		} catch (SQLException e){
			System.out.println("Blad przy pobieraniu listy sprintow");
		}
		
		return sprinty;
	}
	
	public boolean deleteSprintByID(int id){
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from sprint where sprint.id = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	System.err.println("Blad przy usuwaniu sprintu id: " +id);
           // e.printStackTrace();
            return false;
        }
        		
		return true;
	}
	
	public boolean addSprint(Sprint sprint){
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO `sprint` (`id`, `poczatek`, `koniec`) "
					+ "VALUES (NULL, ?, ?)");
			
			ps.setString(1, sprint.getPoczatek());			
			
			ps.setString(2, sprint.getKoniec());
			System.out.println(ps + "\n");
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.err.println("Blad przy dodaniu sprintu " + sprint.toString());
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	


}
