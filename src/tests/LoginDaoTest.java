package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.LoginDao;
import model.Login;

public class LoginDaoTest {

	

	@Test
	public void testTrue() {
		System.out.println("***TEST - login true");

		LoginDao dao = new LoginDao();
		Login login = new Login(1, "admin", "admin");
		
//		login.setId(1);
//		login.setLogin("admin");
//		login.setPassword("admin");
		
		assertTrue(dao.validate(login));
		System.out.println(login);
		
		System.out.println("----\n");
		
	}
	
	@Test
	public void testFalse(){
		
		System.out.println("***TEST - login false");
		LoginDao dao = new LoginDao();
		Login login = new Login();
		
		login.setId(1);
		login.setLogin("zaq1");
		login.setPassword("aaaa");
		
		assertFalse(dao.validate(login));
		System.out.println("----\n");

		
	}
	
}
