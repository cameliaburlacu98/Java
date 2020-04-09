package lab5;

import java.util.ArrayList;
import java.util.List;

public class Banca {
   private String denumire_banca;
   List <Client> clienti;
   public Banca(String denumire_banca)
   {
	   this.denumire_banca=denumire_banca;
	   this.clienti=new ArrayList<Client>();
   }
public String getDenumire_banca() {
	return denumire_banca;
}
public void setDenumire_banca(String denumire_banca) {
	this.denumire_banca = denumire_banca;
}
public List<Client> getClienti() {
	return clienti;
}
public void setClienti(List<Client> clienti) {
	this.clienti = clienti;
}
public void addClient(Client c)
{
   this.clienti.add(c);
}
   @Override
   public String toString()
   {
	   return denumire_banca+" "+clienti+" ";
   }
}
