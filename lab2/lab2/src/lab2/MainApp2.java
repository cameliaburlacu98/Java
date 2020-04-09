package lab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class MainApp2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf= new BufferedReader(new InputStreamReader(new FileInputStream("src/lab2/in.txt")));
		BufferedReader bf1=new BufferedReader(new InputStreamReader(System.in));
		PrintStream iesire= new PrintStream("src/lab2/out.txt");
		Produs [] p=new Produs[30];
		int i=0;
		double min=Double.MAX_VALUE,max=Double.MIN_VALUE;
		String a=bf.readLine();
		while(a!=null)
		{
			StringTokenizer st = new StringTokenizer(a,";");
			while (st.hasMoreTokens())
			{
				String denumire=st.nextToken();
				double pret=Double.parseDouble(st.nextToken());
				double cantitate=Double.parseDouble(st.nextToken());
				p[i]=new Produs(denumire,pret,cantitate);
				i++;
			}
			a=bf.readLine();
		}
		for(int j=0;j<i;j++)
		{  
			iesire.println(p[j]);
			if(p[j].getP()<min)
				min=p[j].getP();
			if(p[j].getP()>max)
				max=p[j].getP();
		}

		for(int j=0;j<i;j++)
		{
			if(p[j].getP()==min)
				iesire.println("Produsul cu cel mai mic pret:"+p[j]);
			if(p[j].getP()==max)
				iesire.println("Produsul cu cel mai mare pret:"+p[j]);
		}

		System.out.println("Cantitatea citita este:");
		String c=bf1.readLine();
		double cantitate=Double.parseDouble(c);
		for(int j=0;j<i;j++)
		{
			if(p[j].getC()<cantitate)
				System.out.println(p[j]);
		}
	}

}
