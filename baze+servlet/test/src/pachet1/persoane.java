package pachet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class persoane
 */
@WebServlet("/persoane")
public class persoane extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public persoane() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/test";
		Statement sql=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con=(Connection) DriverManager.getConnection(url,"root","root");
			sql=(Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=sql.executeQuery("select *from persoane");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><head><title>Persoane</title></head><body>");
		pw.println("<form method='GET' action='persoane'>");
		pw.println("<p>Id<input type='text' name='id'></p>");
		pw.println("<p>Nume<input type='text' name='nume'></p>");
		pw.println("<p>Varsta<input type='text' name='varsta'></p>");
		pw.println("<table border='1'>");
		pw.println("<tr><th>Id</th><th>Nume</th><th>Varsta</th><tr>");
		pw.println("<input type='submit' value='adauga' name='adauga'>");
		pw.println("<input type='submit' value='modifica' name='modifica'>");
		pw.println("<input type='submit' value='sterge' name='sterge'>");
		if(request.getParameter("adauga")!=null)
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String nume=request.getParameter("nume");
			int varsta=Integer.parseInt(request.getParameter("varsta"));
			String comanda="insert into persoane values ("+id+",'"+nume+"',"+varsta+")";
			try {
				sql.executeUpdate(comanda);
				rs=sql.executeQuery("select *from persoane");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("modifica")!=null)
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String nume=request.getParameter("nume");
			int varsta=Integer.parseInt(request.getParameter("varsta"));
			String comanda="update persoane set nume='"+nume+"', varsta="+varsta+" where id="+id;
			try {
				sql.executeUpdate(comanda);
				rs=sql.executeQuery("select *from persoane");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(request.getParameter("sterge")!=null)
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String comanda="delete from persoane where id="+id;
			try {
				sql.executeUpdate(comanda);
				rs=sql.executeQuery("select *from persoane");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			while(rs.next())
			{   
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td>");
				pw.println("</tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("</table>");
		pw.println("</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
