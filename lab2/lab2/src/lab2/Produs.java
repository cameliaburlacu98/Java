package lab2;

public class Produs {
   private String denumire;
   private double pret;
   private double cantitate;
   public Produs(String denumire, double pret,double cantitate)
   {
	   this.denumire=denumire;
	   this.pret=pret;
	   this.cantitate=cantitate;
   }
   @Override
   public String toString()
   {
	   return String.format("%-10s %10.1f %10.1f",denumire,pret, cantitate);
	   //return denumire+"   "+pret+"  "+cantitate;
   }
   public double getP()
   {
	   return pret;
   }
   public double getC()
   {
	   return cantitate;
   }
}

