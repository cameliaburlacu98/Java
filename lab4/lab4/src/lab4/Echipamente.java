package lab4;
enum Stare{
	achizitionat,
	expus,
	vandut
}

public class Echipamente {
	private String denumire;
	private int nr_inv;
	private double pret;
	private String zona_mag;
	private Stare s;
	public Echipamente(String denumire, int nr_inv, double pret, String zona, Stare s) {
		this.denumire=denumire;
		this.nr_inv=nr_inv;
		this.pret=pret;
		this.zona_mag=zona;
		this.s=s;
	}
	
	public void setS(Stare se) {
		s=se;
	}
	public Stare getS()
	{
		return s;
	}
	public String getDenumire(){
		return denumire;
	}
	@Override
	public String toString(){
		return denumire + " " + nr_inv + " " + pret + " " + zona_mag + " " + s;
	}

}
