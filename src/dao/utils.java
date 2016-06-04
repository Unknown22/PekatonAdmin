package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import model.Pracownik;
import util.DbUtil;

public class utils {
	private Connection connection;

	public utils(){
		connection = DbUtil.getConnection();
	}
	
	public int getLiczbaPracownikow(){
		/*
		 * select COUNT(*) from pracownik
		 */
		
		int value = 0;
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select COUNT(*) from pracownik");
			while (rs.next()) {
				value = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Blad przy pobieraniu liczby pracownikow");
//			e.printStackTrace();
			return value;
		}
		return value;
	}
	
	public int getLiczbaZadan(){
		/*
		 * select COUNT(*) from zadanie
		 */
		int value = 0;
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select COUNT(*) from zadanie");
			while (rs.next()) {
				value = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Blad przy pobieraniu liczby zadan");
//			e.printStackTrace();
			return value;
		}
		return value;

	}
	
	public int getLiczbaZadanByStatus(int status){
		/*
		 * select COUNT(*) from zadanie where STATUS = 2
		 */
		
		int value = 0;
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select COUNT(*) from zadanie where STATUS = " + status);
			while (rs.next()) {
				value = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Blad przy pobieraniu liczby zadan status :" + status);
//			e.printStackTrace();
			return value;
		}
		return value;
	}
	
	public int getLiczbaSprintow(){
		/*
		 * select COUNT(*) from sprint
		 */
		return 2;
	}
	
}
