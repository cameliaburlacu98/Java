package pachet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serv_persoana
 */
@WebServlet("/serv_persoana")
public class serv_persoana extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Vector<Persoana>pers=new Vector<Persoana>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serv_persoana() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   PrintWriter pw=response.getWriter();
	   pw.println("<html><head><title>Rezultatul</title></head><body>");
  		pw.println("<h1 align='center'><b>Persoanele introduse</b></h1>");
  		pw.println("<table border='1'>");
  		pw.println("<tr><th>Nume si prenume</th>");
  		pw.println("<th>Data nasterii</th>");
  		pw.println("<th>Adresa</th>");
  		pw.println("<th>Telefon</th></tr>");
	   pw.println("<form action='' method='post'>");
	   pw.println("<select name='luni'>");
       pw.println("<option value='Ianuarie'>Ianuarie</option>");
       pw.println("<option value='Februarie'>Februarie</option>");
       pw.println("<option value='Martie'>Martie</option>");
       pw.println("<option value='Aprilie'>Aprilie</option>");
       pw.println("<option value='Mai'>Mai</option>");
       pw.println("<option value='Iunie'>Iunie</option>");
       pw.println("<option value='Iulie'>Iulie</option>");
       pw.println("<option value='August'>August</option>");
       pw.println("<option value='Septembrie'>Septembrie</option>");
       pw.println("<option value='Octombrie'>Octombrie</option>");
       pw.println("<option value='Noiembrie'>Noiembrie</option>");
       pw.println("<option value='Decembrie'>Decembrie</option></select><input type='submit' value='Vizualizare' name='Vizualizare'></form>");
       if(request.getParameter("Vizualizare")!=null)
       {
    	   String lun=request.getParameter("luni");
		   int i=0;
		   if(lun.compareTo("Ianuarie")==0)
			  i=1;
		   if(lun.compareTo("Februarie")==0)
				  i=2;
		   if(lun.compareTo("Martie")==0)
				  i=3;
		   if(lun.compareTo("Aprilie")==0)
				  i=4;
		   if(lun.compareTo("Mai")==0)
				  i=5;
		   if(lun.compareTo("Iunie")==0)
				  i=6;
		   if(lun.compareTo("Iulie")==0)
				  i=7;
		   if(lun.compareTo("August")==0)
				  i=8;
		   if(lun.compareTo("Septembrie")==0)
				  i=9;
		   if(lun.compareTo("Octombrie")==0)
				  i=10;
		   if(lun.compareTo("Noiembrie")==0)
				  i=11;
		   if(lun.compareTo("Decembrie")==0)
				  i=12;
    	   for(Persoana pe:pers)
    		{
    			   if(i==pe.getLuna())
    			   {  
    				    pw.println("<tr>");
    				    pw.println(pe);
    		           	pw.println("</tr>");
    			   }
    		}
    	   
       }
       else
       {
    	   String nume=request.getParameter("nume");
   		int zi=Integer.parseInt(request.getParameter("zi"));
   		int luna=Integer.parseInt(request.getParameter("luna"));
   		int an=Integer.parseInt(request.getParameter("an"));
   		String adresa=request.getParameter("adresa");
   		String telefon=request.getParameter("telefon");
   		Persoana p=new Persoana(nume,zi,luna,an,adresa,telefon);
   		pers.add(p);
           for(Persoana pe:pers)
           {
        	   pw.println("<tr>");
			    pw.println(pe);
	           	pw.println("</tr>");
          }
       }
       pw.println("</body></html>");
      
		
	}

}
