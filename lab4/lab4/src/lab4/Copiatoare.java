package lab4;
enum Format{
	A4,
	A3
}
public class Copiatoare extends Echipamente{
	private Format f;
	private int ppm;
	private int p_ton;
	public Copiatoare(String denumire, int nr_inv, double pret, String zona, Stare s,Format f,int ppm,int p_ton)
	{
		super(denumire, nr_inv,pret,zona,s);
		this.f=f;
		this.ppm=ppm;
		this.p_ton=p_ton;
	}
	public void setFormat(Format fo)
	{
		f=fo;
	}
	@Override
	public String toString()
	{
		return super.toString()+" copiator "+ppm+" "+p_ton+" "+f;
	}

}
