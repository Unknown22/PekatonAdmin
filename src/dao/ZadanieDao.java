package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Sprint;
import model.Zadanie;
import util.DbUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class ZadanieDao {

	private Connection connection;

	public ZadanieDao() {
		connection = DbUtil.getConnection();
	}
	
	


	
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
	
	public boolean przypiszZadaniePracownikowi(int pracownikId, int zadanieId){
		/*
		 * UPDATE `zadanie` SET `id_pracownika` = '2' WHERE `zadanie`.`id` = 5
		 */
		
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE `zadanie` SET `id_pracownika` = " + pracownikId + " WHERE `zadanie`.`id` = " + zadanieId
					);

						
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.err.println("Blad przy przypisaniu zadania id:" + zadanieId + "pracownikowi id: " + pracownikId);
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	public boolean addZadanie(Zadanie zadanie){
		
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO `zadanie` (`id`, `opis`, `doswiadczenie`, `zleceniodawca`, `id_pracownika`, `status`, `id_sprint`) "
					+ "VALUES "
					+ "(NULL, ?, ?, ?, ?, ?, ?)"
					);
			
			
			ps.setString(1, zadanie.getOpis());
			ps.setInt(2, zadanie.getDoswiadczenie());
			ps.setString(3, zadanie.getZleceniodawca());
			ps.setInt(4, zadanie.getIpPracownika());
			ps.setInt(5, zadanie.getStatus());
			ps.setInt(6, zadanie.getIdSprintu());
						
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.err.println("Blad przy dodaniu " + zadanie.toString());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean editZadanie(Zadanie zadanie){
		
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE `zadanie` "
					+ "SET `opis` = ?, `doswiadczenie` = ?, "
					+ "`zleceniodawca` = ?, `id_pracownika` = NULL, `status` = ? "
					+ "WHERE `zadanie`.`id` = ?"
					);
			
			
			ps.setString(1, zadanie.getOpis());
			ps.setInt(2, zadanie.getDoswiadczenie());
			ps.setString(3, zadanie.getZleceniodawca());
			ps.setInt(4, zadanie.getStatus());
			ps.setInt(5, zadanie.getId());
						
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.err.println("Blad przy dodaniu " + zadanie.toString());
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
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
												"",
												rs.getInt("status"),
												rs.getInt("id_sprint"),
												"",
												""
												);
				Statement statement2 = connection.createStatement();
				ResultSet rs2 = statement2.executeQuery("SELECT * FROM sprint WHERE id =" + rs.getInt("id_sprint") + ";");
				
				while(rs2.next()){
					zadanie.setPoczatekSprintu(new SimpleDateFormat("yyyy-MM-dd").format(rs2.getTimestamp("poczatek")));
					zadanie.setKoniecSprintu(new SimpleDateFormat("yyyy-MM-dd").format(rs2.getTimestamp("koniec")));
				}
				
				rs2 = statement2.executeQuery("SELECT * FROM pracownik WHERE id =" + rs.getInt("id_pracownika") + ";");
				while(rs2.next()){
					zadanie.setPracownik(rs2.getString("login"));
				}
				
				
				zadania.add(zadanie);
			}
			
		} catch (SQLException e){
			System.err.println("Blad przy pobieraniu zadan dla pracownika o id: " + id);
			return zadania;
		}
		return zadania;
	}
	
	public List<Zadanie> getZadaniaAll(){
	
		List<Zadanie> zadania = new ArrayList<Zadanie>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM zadanie");

			while (rs.next()) {
				Zadanie zadanie = new Zadanie(rs.getInt("id"), 
												rs.getString("opis"), 
												rs.getInt("doswiadczenie"),
												rs.getString("zleceniodawca"), 
												rs.getInt("id_pracownika"), 
												"",
												rs.getInt("status"),
												rs.getInt("id_sprint"),
												"",
												""
												);
				Statement statement2 = connection.createStatement();
				ResultSet rs2 = statement2.executeQuery("SELECT * FROM sprint WHERE id =" + rs.getInt("id_sprint") + ";");
				
				while(rs2.next()){
					zadanie.setPoczatekSprintu(new SimpleDateFormat("yyyy-MM-dd").format(rs2.getTimestamp("poczatek")));
					zadanie.setKoniecSprintu(new SimpleDateFormat("yyyy-MM-dd").format(rs2.getTimestamp("koniec")));
				}
				rs2 = statement2.executeQuery("SELECT * FROM pracownik WHERE id =" + rs.getInt("id_pracownika") + ";");
				while(rs2.next()){
					zadanie.setPracownik(rs2.getString("login"));
				}
				zadania.add(zadanie);
			}

		} catch (SQLException e) {
			System.err.println("Blad przy pobieraniu wszystkich zadan");
			return zadania;
		}
		return zadania;

	}
	
	public List<Zadanie> getZadaniaByStatus(int status) {
		
		List<Zadanie> zadania = new ArrayList<Zadanie>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM zadanie where status = " + status  );

			while (rs.next()) {
				Zadanie zadanie = new Zadanie(rs.getInt("id"), 
												rs.getString("opis"), 
												rs.getInt("doswiadczenie"),
												rs.getString("zleceniodawca"), 
												rs.getInt("id_pracownika"), 
												"",
												rs.getInt("status"),
												rs.getInt("id_sprint"),
												"",
												""
												);
				Statement statement2 = connection.createStatement();
				ResultSet rs2 = statement2.executeQuery("SELECT * FROM sprint WHERE id =" + rs.getInt("id_sprint") + ";");
				
				while(rs2.next()){
					zadanie.setPoczatekSprintu(new SimpleDateFormat("yyyy-MM-dd").format(rs2.getTimestamp("poczatek")));
					zadanie.setKoniecSprintu(new SimpleDateFormat("yyyy-MM-dd").format(rs2.getTimestamp("koniec")));
				}
				rs2 = statement2.executeQuery("SELECT * FROM pracownik WHERE id =" + rs.getInt("id_pracownika") + ";");
				while(rs2.next()){
					zadanie.setPracownik(rs2.getString("login"));
				}
				
				zadania.add(zadanie);
			}

		} catch (SQLException e) {
			System.err.println("Blad przy pobieraniu zadan o statusie " + status);
			return zadania;
		}
		return zadania;


	}
	
	
public List<Zadanie> getZadaniaBySprint(int id) {
		
		List<Zadanie> zadania = new ArrayList<Zadanie>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM zadanie where id_sprint = " + id  );

			while (rs.next()) {
				Zadanie zadanie = new Zadanie(rs.getInt("id"), 
												rs.getString("opis"), 
												rs.getInt("doswiadczenie"),
												rs.getString("zleceniodawca"), 
												rs.getInt("id_pracownika"), 
												"",
												rs.getInt("status"),
												rs.getInt("id_sprint"),
												"",
												""
												);
				Statement statement2 = connection.createStatement();
				ResultSet rs2 = statement2.executeQuery("SELECT * FROM sprint WHERE id =" + rs.getInt("id_sprint") + ";");
				
				while(rs2.next()){
					zadanie.setPoczatekSprintu(new SimpleDateFormat("yyyy-MM-dd").format(rs2.getTimestamp("poczatek")));
					zadanie.setKoniecSprintu(new SimpleDateFormat("yyyy-MM-dd").format(rs2.getTimestamp("koniec")));
				}
				rs2 = statement2.executeQuery("SELECT * FROM pracownik WHERE id =" + rs.getInt("id_pracownika") + ";");
				while(rs2.next()){
					zadanie.setPracownik(rs2.getString("login"));
				}
				
				zadania.add(zadanie);
			}

		} catch (SQLException e) {
			System.err.println("Blad przy pobieraniu zadan sprintu " + id);
			return zadania;
		}
		return zadania;


	}
	
	
	public boolean verifyZadanie(int id){
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE `zadanie` SET `status`='2' WHERE `id`='"+id+"';");
			
			System.out.println(ps + "\n");
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.err.println("Blad przy zmianie statusu zadania id: " + id);
			e.printStackTrace();
			return false;
		}		
		
		
		
		int idPracownika = getPracownikIDByZadanie(id);
		System.out.println("ID PRACOWNIKA DO AWANSU " + idPracownika);
		updatePracownikExpByZadanie(idPracownika, id);
		
		return true;
		
	}
	
	public int getPracownikIDByZadanie(int idZadania){
		/*
		 * SELECT id_pracownika from zadanie where id = 33
		 */
		int pracID = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT id_pracownika from zadanie where id = " + idZadania );
			
			while (rs.next()) {
				pracID = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.err.println("Blad przy zmianie statusu pobieraniu id Pracownika");
			e.printStackTrace();
			return 0;
		}		
		return pracID;
	}

	public void updatePracownikExpByZadanie(int id_pracownika, int id_zadania){
		int exp_zadanie = 0;
		int obecny_exp_pracownika = -1;
		
		try{
			Statement s=connection.createStatement();  
			ResultSet rs = s.executeQuery("SELECT doswiadczenie FROM zadanie WHERE id ="+id_zadania+";");
			while(rs.next())
			{
				exp_zadanie=rs.getInt("doswiadczenie");
			}
		} catch(SQLException e){
			System.out.println("Blad przy pobieraniu doswiadczenia za zadanie");
		}
		System.out.println(exp_zadanie);
		
		try{
			Statement s=connection.createStatement();  
			ResultSet rs = s.executeQuery("SELECT doswiadczenie FROM pracownik WHERE id ="+id_pracownika+";");
			while(rs.next())
			{
				obecny_exp_pracownika=rs.getInt("doswiadczenie");
			}
			System.out.println(obecny_exp_pracownika);
			
			if(obecny_exp_pracownika>0){
				int suma = exp_zadanie + obecny_exp_pracownika;
				s.executeUpdate("UPDATE `pracownik` SET `doswiadczenie`='"+suma+"' WHERE `id`='"+id_pracownika+"';");
			}
		} catch(SQLException e){
			System.out.println("Blad przy aktualizacji expa pracownika");
		}
	}
	
}
