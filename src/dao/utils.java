package dao;

public class utils {

	public int getLiczbaPracownikow(){
		/*
		 * select COUNT(*) from pracownik
		 */
		return 1;
	}
	
	public int getLiczbaZadan(){
		/*
		 * select COUNT(*) from zadanie
		 */
		return 5;
	}
	
	public int getLiczbaZadanByStatus(int status){
		/*
		 * select COUNT(*) from zadanie where STATUS = 2
		 */
		return 1;
	}
	
	public int getLiczbaSprintow(){
		/*
		 * select COUNT(*) from sprint
		 */
		return 2;
	}
	
}
