package lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class ClientiiBancilor {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
      BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
      BufferedReader bf1=new BufferedReader(new InputStreamReader(System.in));
      List<Banca> banci=new ArrayList<Banca>();
      int opt=0;
      do
      {
    	  System.out.println("------------Meniu----------");
    	  System.out.println("1.Adaugare banci,clienti,conturi");
    	  System.out.println("2.Afisare date introduse");
    	  System.out.println("3.Depunerea unei sume intr-un cont");
    	  System.out.println("4.Extragerea unei sume dintr-un cont");
    	  System.out.println("5.Transfer de bani intre doua conturi\n");
    	  System.out.println("Optiunea ta este:");
    	  opt=Integer.parseInt(bf1.readLine());
    	  switch(opt)
    	  {
    	     case 1:
    	    	 String a=bf.readLine();
    	    	 while(a!=null)
    	    	 {
    	    		 StringTokenizer st=new StringTokenizer(a,";");
    	    		 while(st.hasMoreTokens())
    	    		 {
    	    			 String denumire_banca=st.nextToken();
    	    			 String nume=st.nextToken();
    	    			 String adresa=st.nextToken();
    	    			 String numarCont=st.nextToken();
    	    			 float suma=Float.parseFloat(st.nextToken());
    	    			 String moneda=st.nextToken();
    	    			 SimpleDateFormat s= new SimpleDateFormat("dd.MM.yyyy");
    	    			 Date data=s.parse(st.nextToken());
    	    			 Calendar c=Calendar.getInstance();
    	    			 c.setTime(data);
    	    			 SimpleDateFormat s1=new SimpleDateFormat("dd.MM.yyyy");
    	    			 Date dat=s1.parse(st.nextToken());
    	    			 Calendar c1=Calendar.getInstance();
    	    			 c1.setTime(dat);
    	    			 banci.add(new Banca(denumire_banca));
    	    			 Client cl=new Client(nume,adresa);
    	    			 for(Banca b:banci)
    	    			 {
    	    				 if(b.getDenumire_banca().compareTo(denumire_banca)==0)
    	    				    b.addClient(cl);
    	    			 }
    	    			 ContBancar cb=new ContBancar(numarCont,suma,moneda,c,c1);
    	    			 for(Banca b:banci)
    	    			 {
    	    				 if(denumire_banca.compareTo(b.getDenumire_banca())==0)
    	    				 {
    	    					 for(Client cl2:b.clienti )
    	    					 {
    	    						 if(cl2.getNume().compareTo(nume)==0)
    	    						 {
    	    							cl2.addContBancar(cb);
    	    						 }
    	    					 }
    	    				 }
    	    			 }
    	    		 }
    	    		 a=bf.readLine();
    	    	 }
    	    	 break;
    	     case 2:
    	    	 for(Banca b:banci)
    	    	  System.out.println(b);
    	  }
      }while(opt!=0);
	}

}
