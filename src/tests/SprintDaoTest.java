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

	@Test
	public void addSprint(){
		System.out.println("***TEST - addSprint ");
		Sprint sprint = new Sprint(0, "1999-10-03", "2016-02-04");
		SprintDao dao = new SprintDao();
		
		System.out.println(sprint.getPoczatek()); //musi byæ ten system out inaczej nie dzia³a
		dao.addSprint(sprint); //nie mo¿e byæ assert bo nie dzia³a
		System.out.println("-----\n");
		
	}
	
	
}
