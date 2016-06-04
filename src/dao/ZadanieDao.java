package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Zadanie;
import util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ZadanieDao {

	private Connection connection;

	public ZadanieDao() {
		connection = DbUtil.getConnection();
	}
	
	
//	public List<Zadanie> getZadaniaAll(){
//		
//	}
//	
//	public List<Zadanie> getZadaniaByStatus(){
//		
//	}
//	
//	public boolean addZadanie(Zadanie zadanie){
//		
//	}
	
	public boolean deleteZadanieByID(int id){
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from zadanie where zadanie.id = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	System.err.println("Blad przy usuwaniu zadania id: " +id);
           // e.printStackTrace();
            return false;
        }
        		
		return true;
		
	}
	
//	public boolean editZadanie(Zadanie zadanie){
//		
//	}
	
	
	public List<Zadanie> getZadaniaByPracownikId(int id){
		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM zadanie WHERE id_pracownika =" + id + ";");
			
			while (rs.next()) {
				Zadanie zadanie = new Zadanie(rs.getInt("id"),
												rs.getString("opis"),
												rs.getInt("doswiadczenie"),
												rs.getString("zleceniodawca"),
												rs.getInt("id_pracownika"),
												rs.getInt("status"));
				zadania.add(zadanie);
			}
			
		} catch (SQLException e){
			System.out.println("Blad przy pobieraniu zadan dla pracownika o id: " + id);
			return zadania;
		}
		return zadania;
	}


	
}
