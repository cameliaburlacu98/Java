package lab5;

import java.util.Calendar;

public class ContBancar implements Operatiuni {
	private String numarCont;
	private float suma;
	private String moneda;
	private Calendar data_deschiderii;
	private Calendar data_ultimei_operatiuni;
	public ContBancar(String numarCont,float suma, String moneda,Calendar data_deschiderii,Calendar data_ultimei_operatiuni)
	{
		this.numarCont=numarCont;
		this.suma=suma;
		this.moneda=moneda;
		this.data_deschiderii=data_deschiderii;
		this.data_ultimei_operatiuni=data_ultimei_operatiuni;
	}
	public float calculeaza_dobanda()
	{
		Calendar c=Calendar.getInstance();
		long n=c.getTimeInMillis()-data_ultimei_operatiuni.getTimeInMillis();
		long zi=n/(60*60*24*1000);
		if(moneda.compareTo("RON")==0)
		{
			if(suma<500)
				return zi*0.3f;
			else
				return zi*0.8f;
		}
		else
			return zi*0.1f;
	}
	public float actualizare_suma()
	{
		suma=suma+calculeaza_dobanda();
		data_ultimei_operatiuni=Calendar.getInstance();
		return suma;
	}
	public void depunere(float suma)
	{
		this.suma=actualizare_suma();
		data_ultimei_operatiuni=Calendar.getInstance();
		this.suma=this.suma+suma;
	}
	public void extragere (float suma)
	{
		this.suma=actualizare_suma();
		data_ultimei_operatiuni=Calendar.getInstance();
		this.suma=this.suma-suma;
	}
	public String getNumarCont() {
		return numarCont;
	}
	public void setNumarCont(String numarCont) {
		this.numarCont = numarCont;
	}
	public float getSuma() {
		return suma;
	}
	public void setSuma(float suma) {
		this.suma = suma;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Calendar getData_deschiderii() {
		return data_deschiderii;
	}
	public void setData_deschiderii(Calendar data_deschiderii) {
		this.data_deschiderii = data_deschiderii;
	}
	public Calendar getData_ultimei_operatiuni() {
		return data_ultimei_operatiuni;
	}
	public void setData_ultimei_operatiuni(Calendar data_ultimei_operatiuni) {
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}
	public String AfisareData(Calendar c)
	{
		return c.get(Calendar.DAY_OF_MONTH)+"."+c.get(Calendar.MONTH)+"."+c.get(Calendar.YEAR);
	}
	@Override
	public String toString()
	{
		return  numarCont+" "+suma+" "+moneda+" "+"data deschiderii:"+AfisareData(data_deschiderii)+" "+"data ultimei operatiuni:"+AfisareData(data_ultimei_operatiuni);
	}
}
