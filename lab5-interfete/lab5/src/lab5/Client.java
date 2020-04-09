package lab5;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String nume;
	private String adresa;
	private List<ContBancar> conturi;
	public Client(String nume,String adresa)
	{
		this.nume=nume;
		this.adresa=adresa;
		this.conturi=new ArrayList<ContBancar>();
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public List<ContBancar> getConturi() {
		return conturi;
	}
	public void setConturi(List<ContBancar> conturi) {
		this.conturi = conturi;
	}
	public void addContBancar(ContBancar cb)
	{
		this.conturi.add(cb);
	}
	@Override
	public String toString()
	{
		return nume+" "+adresa+" "+conturi+" ";
	}
}
