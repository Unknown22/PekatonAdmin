package tests;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.PracownikDao;
import model.Pracownik;


public class PracownikDaoTests {

	
	
	@Test
	public void getPracownikAll(){
		
		PracownikDao dao = new PracownikDao();
		
		List<Pracownik> lista = new ArrayList<Pracownik>();
		
		lista.addAll(dao.getAllPracownik());
		
		for (Pracownik pracownik : lista) {
			System.out.println(pracownik);
		}
		
	}
	
}
