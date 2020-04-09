package pachet1;

public class Persoana {
	private String nume;
	private int zi;
	private int luna;
	private int an;
	private String adresa;
	private String telefon;
	public Persoana(String nume,int zi ,int luna,int an,String adresa,String telefon)
	{
		this.nume=nume;
		this.zi=zi;
		this.luna=luna;
		this.an=an;
		this.adresa=adresa;
		this.telefon=telefon;
	}
	@Override
	public String toString() {
		return "<td>"+nume+"</td>"+"<td>"+zi+"-"+luna+"-"+an+"</td>"+"<td>"+adresa+"</td>"+"<td>"+telefon+"</td>";
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getZi() {
		return zi;
	}
	public void setZi(int zi) {
		this.zi = zi;
	}
	public int getLuna() {
		return luna;
	}
	public void setLuna(int luna) {
		this.luna = luna;
	}
	public int getAn() {
		return an;
	}
	public void setAn(int an) {
		this.an = an;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}
