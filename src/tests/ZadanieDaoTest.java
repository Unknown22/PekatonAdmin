package tests;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.ZadanieDao;
import model.Zadanie;


public class ZadanieDaoTest {

	@Test
	public void getZadaniaByPracownikId() {
		int id = 1;
		System.out.println("***TEST - getZadaniaByPracownikId: " + id);

		ZadanieDao dao = new ZadanieDao();

		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		zadania =  dao.getZadaniaByPracownikId(id);
		
		assertNotNull(zadania);
		
		if(zadania.isEmpty())
			System.out.println("Pracownik id: " + id + " - nie ma zadnych przypisanych zadan");
		
		for (Zadanie zadanie : zadania) {
			System.out.println(zadanie);
		}
		
//		if (pracownik.getId() > 0)
//			System.out.println(pracownik);
//		else
//			System.out.println("Nie ma pracownika o id: " + id);
		System.out.println("-----\n");

	}

	@Test
	public void getZadaniaByPracownikId2() {
		int id = 2;
		System.out.println("***TEST - getZadaniaByPracownikId: " + id);

		ZadanieDao dao = new ZadanieDao();

		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		zadania =  dao.getZadaniaByPracownikId(id);
		
		assertNotNull(zadania);
		
		if(zadania.isEmpty())
			System.out.println("Pracownik id: " + id + " - nie ma zadnych przypisanych zadan");
		
		for (Zadanie zadanie : zadania) {
			System.out.println(zadanie);
		}
		
//		if (pracownik.getId() > 0)
//			System.out.println(pracownik);
//		else
//			System.out.println("Nie ma pracownika o id: " + id);
		System.out.println("-----\n");

	}
	
}
