package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.PracownikDao;
import model.Pracownik;

public class PracownikDaoTests {

	@Test
	public void getPracownikAll() {

		System.out.println("***TEST - getPracownikAll");
		PracownikDao dao = new PracownikDao();

		List<Pracownik> lista = new ArrayList<Pracownik>();

		lista.addAll(dao.getAllPracownik());
		assertNotNull(lista.size() > 0);

		for (Pracownik pracownik : lista) {
			System.out.println(pracownik);
		}

		System.out.println("-----\n");
	}

	@Test
	public void getPracownikById() {
		int id = 1;
		System.out.println("***TEST - getPracownikById: " + id);

		PracownikDao dao = new PracownikDao();

		Pracownik pracownik = new Pracownik();
		pracownik = dao.getPracownikByID(id);
		assertNotNull(pracownik);
		if (pracownik.getId() > 0)
			System.out.println(pracownik);
		else
			System.out.println("Nie ma pracownika o id: " + id);
		System.out.println("-----\n");

	}

	@Test
	public void addPracownik() {
		System.out.println("***TEST - addPracownik");

		PracownikDao dao = new PracownikDao();

		Pracownik pracownik = new Pracownik(991, "Mateosz1", "mateosz1", "tester1", 918, " ");

		boolean result = dao.addPracownik(pracownik);

		assert (result);

		if (result)
			System.out.println("Dodano poprawnie " + pracownik);
		else
			System.out.println("Nie mozna dodac: " + pracownik);
		System.out.println("-----\n");
	}

	@Test
	public void deletePracownikByID() {
		int id = 1;
		System.out.println("***TEST - deletePracownikById: " + id);

		PracownikDao dao = new PracownikDao();

		boolean result = dao.deletePracownik(id);

		assert (result);

		if (result)
			System.out.println("Usunieto pracownika o id: " + id);
		else
			System.out.println("Nie mozna usunac pracownika o id: " + id);
		System.out.println("-----\n");

	}
	
	@Test
	public void editPracownik(){
		
		int id = 2;
		System.out.println("***TEST - editPracownik id: " + id);

		PracownikDao dao = new PracownikDao();

		Pracownik pracownik = new Pracownik();
		pracownik = dao.getPracownikByID(id);

		pracownik.setLogin(pracownik.getLogin() + "EDIT");
		pracownik.setStanowisko(pracownik.getStanowisko() + "EDIT");
		
		boolean result = dao.editPracownik(pracownik);

		assert (result);

		if (result)
			System.out.println("Edytowano poprawnie " + pracownik);
		else
			System.out.println("Nie mozna edytowac: " + pracownik);
		System.out.println("-----\n");
		
		
	}

}
