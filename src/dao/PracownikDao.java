package dao;

import java.sql.Connection;
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

		return pracownik;
	}

	public boolean addPracownik(int id, String login, String haslo, String stanowisko) {

		return true;
	}

	public boolean editPracownik(int id, String login, String haslo, String stanowisko, int doswiadczenie) {

		return true;
	}
}
