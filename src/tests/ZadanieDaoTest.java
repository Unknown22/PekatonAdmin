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
		
		System.out.println("-----\n");

	}
	
	@Test
	public void getZadaniaAll() {
		System.out.println("***TEST - getZadaniaAll" );

		ZadanieDao dao = new ZadanieDao();

		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		zadania =  dao.getZadaniaAll();
		
		assertNotNull(zadania);
		
		if(zadania.isEmpty())
			System.out.println( "nie ma zadnych  zadan");
		
		for (Zadanie zadanie : zadania) {
			System.out.println(zadanie);
		}
		
		System.out.println("-----\n");

	}
	
	
	@Test
	public void getZadaniaByStatus0() {
		int status = 0;
		System.out.println("***TEST - getZadaniaByStatus: " + status);

		ZadanieDao dao = new ZadanieDao();

		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		zadania =  dao.getZadaniaByStatus(status);
		
		assertNotNull(zadania);
		
		if(zadania.isEmpty())
			System.out.println("Nie ma zadnych zadan o statusie: " + status);
		
		for (Zadanie zadanie : zadania) {
			System.out.println(zadanie);
		}
		
		System.out.println("-----\n");

	}
	
	@Test
	public void getZadaniaByStatus1() {
		int status = 1;
		System.out.println("***TEST - getZadaniaByStatus: " + status);

		ZadanieDao dao = new ZadanieDao();

		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		zadania =  dao.getZadaniaByStatus(status);
		
		assertNotNull(zadania);
		
		if(zadania.isEmpty())
			System.out.println("Nie ma zadnych zadan o statusie: " + status);
		
		for (Zadanie zadanie : zadania) {
			System.out.println(zadanie);
		}
		
		System.out.println("-----\n");

	}
	
	
	@Test
	public void deleteZadanie() {
		int id = 2;
		System.out.println("***TEST - deleteZadanie: " + id);

		ZadanieDao dao = new ZadanieDao();

		boolean result = dao.deleteZadanieByID(id);
		
		assert(result);
		
		if(result)
			System.out.println("Usunieto zadanie id: " + id);
		else
			System.out.println("Usunieto zadania id: " + id);
		System.out.println("-----\n");

	}
	
	@Test
	public void addZadanie(){
		System.out.println("***TEST - addZadanie ");

		ZadanieDao dao = new ZadanieDao();
		Zadanie zadanie = new Zadanie(0, "Opis Testowy", 2, "Krzyzszof", 0, "", 0, 1, "", "");

		boolean result = dao.addZadanie(zadanie);

		assert (result);

		if (result)
			System.out.println("Dodano zadanie " + zadanie);
		else
			System.out.println("Nie dodano zadania " + zadanie);
		System.out.println("-----\n");
		
	}
	
	@Test
	public void editZadanie(){
		System.out.println("***TEST - editZadanie ");

		ZadanieDao dao = new ZadanieDao();
		Zadanie zadanie = new Zadanie(4, "Opis Testow2222y", 2, "Krzyz123123szof", 0, "", 0, 3, "", "");

		boolean result = dao.editZadanie(zadanie);

		assert (result);

		if (result)
			System.out.println("edytowano zadanie " + zadanie);
		else
			System.out.println("Nie edytowano zadania " + zadanie);
		System.out.println("-----\n");
		
	}
	
	@Test
	public void przypiszZadaniePracownikowi(){
		int zadanieID = 14;
		int pracownikID = 6;
		System.out.println("***TEST - przypiszZadaniePracownikowi: id zadania: " + zadanieID + ", pracownik id: " + pracownikID);

		ZadanieDao dao = new ZadanieDao();
		

		boolean result = dao.przypiszZadaniePracownikowi(pracownikID, zadanieID);

		assert (result);

		if (result)
			System.out.println("Przypisano zadanie: " + zadanieID + " pracownikowi:" + pracownikID);
		else
			System.out.println("Blad przypisania zadania: " + zadanieID + " pracownikowi:" + pracownikID);
		System.out.println("-----\n");
		
	}
	
}
