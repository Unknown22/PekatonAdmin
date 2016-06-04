package model;

public class Zadanie {

	private int id = 0;
	private String opis;
	private int doswiadczenie = 0;
	private String zleceniodawca;
	private int ipPracownika = 0;
	private String pracownik = "";
	private int status = 0;
	/*
	 * status
	 * 0 - niewykonane/przypisane
	 * 1 - do weryfikacji
	 * 2 - zakonczone
	 */
	private int idSprintu = 0;
	



	public Zadanie(int id, String opis, int doswiadczenie, String zleceniodawca, int ipPracownika, String pracownik,
			int status, int idSprintu, String poczatekSprintu, String koniecSprintu) {
		super();
		this.id = id;
		this.opis = opis;
		this.doswiadczenie = doswiadczenie;
		this.zleceniodawca = zleceniodawca;
		this.ipPracownika = ipPracownika;
		this.pracownik = pracownik;
		this.status = status;
		this.idSprintu = idSprintu;
		this.poczatekSprintu = poczatekSprintu;
		this.koniecSprintu = koniecSprintu;
	}




	private String poczatekSprintu = "";
	private String koniecSprintu = "";
	
	public String getOpis() {
		return opis;
	}
	
	
	
	
	public Zadanie() {
	}






	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getDoswiadczenie() {
		return doswiadczenie;
	}
	public void setDoswiadczenie(int doswiadczenie) {
		this.doswiadczenie = doswiadczenie;
	}
	public String getZleceniodawca() {
		return zleceniodawca;
	}
	public void setZleceniodawca(String zleceniodawca) {
		this.zleceniodawca = zleceniodawca;
	}
	public int getIpPracownika() {
		return ipPracownika;
	}
	public void setIpPracownika(int ipPracownika) {
		this.ipPracownika = ipPracownika;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Zadanie [id=" + id + ", opis=" + opis + ", doswiadczenie=" + doswiadczenie + ", zleceniodawca="
				+ zleceniodawca + ", ipPracownika=" + ipPracownika + ", pracownik=" + pracownik + ", status=" + status
				+ ", idSprintu=" + idSprintu + ", poczatekSprintu=" + poczatekSprintu + ", koniecSprintu="
				+ koniecSprintu + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}




	public String getPoczatekSprintu() {
		return poczatekSprintu;
	}




	public void setPoczatekSprintu(String poczatekSprintu) {
		this.poczatekSprintu = poczatekSprintu;
	}




	public String getKoniecSprintu() {
		return koniecSprintu;
	}




	public void setKoniecSprintu(String koniecSprintu) {
		this.koniecSprintu = koniecSprintu;
	}




	public int getIdSprintu() {
		return idSprintu;
	}




	public void setIdSprintu(int idSprintu) {
		this.idSprintu = idSprintu;
	}




	public String getPracownik() {
		return pracownik;
	}




	public void setPracownik(String pracownik) {
		this.pracownik = pracownik;
	}
	
	
	
	
	
	
}
