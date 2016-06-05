package tests;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.SprintDao;
import model.Sprint;
import model.Zadanie;

public class SprintDaoTest {
	
	@Test
	public void getSprintyAll(){
		System.out.println("***TEST - getSprintyAll ");
		
		SprintDao dao = new SprintDao();
		
		List<Sprint> sprinty = new ArrayList<Sprint>();
		
		sprinty = dao.getSprintAll();
		
		assertNotNull(sprinty);
		
		if(sprinty.isEmpty())
			System.out.println("Nie ma zadnych Sprintow");
		
		for (Sprint sprint : sprinty) {
			System.out.println(sprint);
		}
		
		System.out.println("-----\n");
	}

}
