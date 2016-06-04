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

}
