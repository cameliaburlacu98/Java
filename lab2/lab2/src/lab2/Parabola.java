package lab2;

public class Parabola {
   public double a,b,c;
   public Parabola(double a, double b,double c)
   {
	   this.a=a;
	   this.b=b;
	   this.c=c;
   }
   public Parabola(Parabola p)
   {
	   this(p.a,p.b,p.c);
   }
   public void afisare()
   {
	   System.out.println("F(x)="+a+"x^2+"+b+"x+"+c);
   }
   public Punct varf()
   {
	   Punct p =new Punct();
	   p.setX(-b/(2*a));
	   p.setY((-b*b+4*a*c)/(4*a));
	   System.out.println("(x,y)="+"("+p.getX()+","+p.getY()+")");
	   return p;
   }
   public static void mijloc(Parabola p1,Parabola p2)
   {
	   Punct pun1=p1.varf();
	   Punct pun2=p2.varf();
	   double x,y;
	   x=(pun1.getX()+pun2.getX())/2;
	   y=(pun1.getY()+pun2.getY())/2;
	   System.out.println("(x,y)="+"("+x+","+y+")");
   }
}
