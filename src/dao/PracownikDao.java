package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pracownik;
import util.DbUtil;

public class PracownikDao {
	private Connection connection;

	public PracownikDao() {
		connection = DbUtil.getConnection();
	}

	public List<Pracownik> getAllPracownik() {

		List<Pracownik> pracownicy = new ArrayList<Pracownik>();

		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from pracownik");

			while (rs.next()) {

				Pracownik pracownik = new Pracownik(rs.getInt("id"), 
													rs.getString("login"), 
													rs.getString("haslo"),
													rs.getString("stanowisko"),
													rs.getInt("doswiadczenie")
													);

				pracownicy.add(pracownik);

			}

		} catch (SQLException e) {
			System.out.println("Blad przy pobieraniu listy pracownikow");
//			e.printStackTrace();
			return pracownicy;
		}

		return pracownicy;
	}

	public Pracownik getPracownikByID(int id) {

		Pracownik pracownik = new Pracownik();
		
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from pracownik where pracownik.id =" + id);

			while (rs.next()) {

				pracownik = new Pracownik(rs.getInt("id"), 
											rs.getString("login"), 
											rs.getString("haslo"),
											rs.getString("stanowisko"),
											rs.getInt("doswiadczenie")
													);

			}

		} catch (SQLException e) {
			System.out.println("Blad przy pobieraniu pracownika o id: " + id );
//			e.printStackTrace();
			return pracownik;
		}

		return pracownik;
	}

	public boolean addPracownik(Pracownik pracownik) {
		/*INSERT INTO `pracownik` (`id`, `login`, `haslo`, `stanowisko`, `doswiadczenie`)
		VALUES (NULL, 'Yasiu', 'yasiu', 'Java Full Stack Developer with A lot of Money', '99');
		*/
		
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO `pracownik` "
					+ "(`id`, `login`, `haslo`, `stanowisko`, `doswiadczenie`)"
					+ " VALUES "
					+ "(NULL, ?, ?, ?, ?);");
			
			
			ps.setString(1, pracownik.getLogin());
			ps.setString(2, pracownik.getHaslo());
			ps.setString(3, pracownik.getStanowisko());
			ps.setInt(4, pracownik.getExp());
						
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("Blad przy dodaniu " + pracownik.toString());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean editPracownik(int id, String login, String haslo, String stanowisko, int doswiadczenie) {

		return true;
	}
}
