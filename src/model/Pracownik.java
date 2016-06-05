package model;

public class Pracownik {

	private int id = 0;
	private String login = "";
	private String haslo = "";
	private String stanowisko = "";
	private int doswiadczenie = 1;
	private String dataZatrudnienia = "";
	
	
	
	public Pracownik() {
		
	}
	
	
	
	



	public Pracownik(int id, String login, String haslo, String stanowisko, int doswiadczenie, String dataZatrudnienia) {
		super();
		this.id = id;
		this.login = login;
		this.haslo = haslo;
		this.stanowisko = stanowisko;
		this.doswiadczenie = doswiadczenie;
		this.dataZatrudnienia = dataZatrudnienia;
	}







	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(String stanowisko) {
		if(stanowisko.length() > 49 )
			stanowisko = stanowisko.substring(0, 49);
		
		this.stanowisko = stanowisko;
	}
	public int getExp() {
		return doswiadczenie;
	}
	public void setExp(int exp) {
		this.doswiadczenie = exp;
	}
	
	



	public int getDoswiadczenie() {
		return doswiadczenie;
	}



	public void setDoswiadczenie(int doswiadczenie) {
		this.doswiadczenie = doswiadczenie;
	}



	public String getDataZatrudnienia() {
		return dataZatrudnienia;
	}



	public void setDataZatrudnienia(String dataZatrudnienia) {
		this.dataZatrudnienia = dataZatrudnienia;
	}



	@Override
	public String toString() {
		return "Pracownik [id=" + id + ", login=" + login + ", haslo=" + haslo + ", stanowisko=" + stanowisko
				+ ", doswiadczenie=" + doswiadczenie + ", dataZatrudnienia=" + dataZatrudnienia + "]";
	}
	
	
	
}
