package lab2;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Parabola par1=new Parabola(1,2,3);
        Parabola par2=new Parabola(2,4,5);
        par1.afisare();
        par2.afisare();
        Parabola.mijloc(par1, par2);
	}

}
