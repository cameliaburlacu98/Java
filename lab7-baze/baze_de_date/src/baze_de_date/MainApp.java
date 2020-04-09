package baze_de_date;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.xml.transform.OutputKeys;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class MainApp extends JFrame{
	static int LastRow;
	private JToolBar mybar;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnUndo;
	private JButton btnFind;
	private JTextField txtAfis;
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;
	public MainApp() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		super("Tabelul MySQL-persoane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,250);
		getContentPane().setLayout(new BorderLayout());

		String url="jdbc:mysql://localhost:3306/test";
		Statement sql;
		ResultSet rs;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=(Connection) DriverManager.getConnection(url,"root","root");
		sql=(Statement)con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=sql.executeQuery("select * from persoane");

		rs.last();
		LastRow=rs.getRow();
		rs.first();

		mybar=new JToolBar();
		btnFirst=new JButton();
		btnPrevious=new JButton();
		btnNext=new JButton();
		btnLast=new JButton();
		btnAdd=new JButton();
		btnEdit=new JButton();
		btnDelete=new JButton();
		btnSave=new JButton();
		btnUndo=new JButton();
		btnFind=new JButton();
		txtAfis=new JTextField();

		btnFirst.setIcon(new ImageIcon("MoveFirst.png"));
		btnPrevious.setIcon(new ImageIcon("MovePrevious.png"));
		btnNext.setIcon(new ImageIcon("MoveNext.png"));
		btnLast.setIcon(new ImageIcon("MoveLast.png"));
		btnAdd.setIcon(new ImageIcon("Add.png"));
		btnEdit.setIcon(new ImageIcon("Edit.png"));
		btnDelete.setIcon(new ImageIcon("Delete.png"));
		btnSave.setIcon(new ImageIcon("save.JPG"));
		btnUndo.setIcon(new ImageIcon("undo.JPG"));
		btnFind.setIcon(new ImageIcon("find.JPG"));
		btnSave.setEnabled(false);
		btnUndo.setEnabled(false);
		mybar.add(btnFirst);
		mybar.add(btnPrevious);
		mybar.add(txtAfis);
		mybar.add(btnNext);
		mybar.add(btnLast);
		mybar.add(btnAdd);
		mybar.add(btnEdit);
		mybar.add(btnDelete);
		mybar.add(btnFind);
		mybar.add(btnSave);
		mybar.add(btnUndo);
		getContentPane().add(mybar,BorderLayout.NORTH);

		JPanel principal=new JPanel();
		principal.setLayout(new BoxLayout(principal,BoxLayout.Y_AXIS));
		JPanel pn1=new JPanel(new FlowLayout());
		JLabel lb1=new JLabel("Id");
		lb1.setPreferredSize(new Dimension(30,20));
		jt1=new JTextField();
		jt1.setEditable(false);
		jt1.setPreferredSize(new Dimension(120,20));
		pn1.add(lb1);
		pn1.add(jt1);
		pn1.setAlignmentX(Component.CENTER_ALIGNMENT);
		principal.add(pn1);
		JPanel pn2=new JPanel(new FlowLayout());
		JLabel lb2=new JLabel("Nume");
		jt2=new JTextField();
		jt2.setEditable(false);
		jt2.setPreferredSize(new Dimension(120,20));
		pn2.add(lb2);
		pn2.add(jt2);
		pn2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JPanel pn3=new JPanel(new FlowLayout());
		JLabel lb3=new JLabel("Varsta");
		jt3=new JTextField();
		jt3.setPreferredSize(new Dimension(120,20));
		jt3.setEditable(false);
		pn3.setAlignmentX(Component.CENTER_ALIGNMENT);
		pn3.add(lb3);
		pn3.add(jt3);
		principal.add(pn1);
		principal.add(pn2);
		principal.add(pn3);
		getContentPane().add(principal);

		UpdateText(rs);
		
		btnFirst.setName("btnFirst");
		btnPrevious.setName("btnPrevious");
		btnNext.setName("btnNext");
		btnLast.setName("btnLast");
		btnAdd.setName("btnAdd");
		btnUndo.setName("btnUndo");
		btnEdit.setName("btnEdit");
		btnDelete.setName("btnDelete");
		btnFind.setName("btnFind");
		btnFirst.addActionListener(new Click(rs));
		btnPrevious.addActionListener(new Click(rs));
		btnNext.addActionListener(new Click(rs));
		btnLast.addActionListener(new Click(rs));
		btnAdd.addActionListener(new Click(rs));
		btnSave.addActionListener(new Click(rs));
		btnUndo.addActionListener(new Click(rs));
		btnEdit.addActionListener(new Click(rs));
		btnDelete.addActionListener(new Click(rs));
		btnFind.addActionListener(new Click(rs));
	}
	void UpdateText(ResultSet rs) throws SQLException
	{
		int curent=rs.getRow();
		txtAfis.setText(String.valueOf(curent)+"/"+String.valueOf(LastRow));
		jt1.setText(String.valueOf(rs.getInt(1)));
		jt2.setText(rs.getString(2));
		jt3.setText(String.valueOf(rs.getInt(3)));
		if(rs.getRow()==1)
		{
			btnFirst.setEnabled(false);
			btnPrevious.setEnabled(false);
			btnLast.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else
		{
			if(rs.getRow()==LastRow)
			{
				btnFirst.setEnabled(true);
				btnPrevious.setEnabled(true);
				btnLast.setEnabled(false);
				btnNext.setEnabled(false);
			}
			else
			{
				btnFirst.setEnabled(true);
				btnPrevious.setEnabled(true);
				btnLast.setEnabled(true);
				btnNext.setEnabled(true);
			}
		}

	}
	class Click implements ActionListener
	{   ResultSet rs;
		public Click(ResultSet rs)
		{
			this.rs=rs;
		}
		public void actionPerformed(ActionEvent e)
		{ 
			JButton source=(JButton)(e.getSource());
			String buton=source.getName();
			switch(buton)
		   {
			case "btnFirst":
			{
				try {
					rs.first();
					UpdateText(rs);
				} catch (SQLException e1) {
					 //TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}break;
			case "btnPrevious":
			{
				try {
					rs.previous();
					UpdateText(rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}break;
			case "btnNext":
			{
				try {
					rs.next();
					UpdateText(rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}break;
			case "btnLast":
			{
				try {
					rs.last();
					UpdateText(rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}break;
			case "btnAdd":
			{

				btnFirst.setEnabled(false);
				btnPrevious.setEnabled(false);
				btnLast.setEnabled(false);
				btnNext.setEnabled(false);
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnFind.setEnabled(false);
				btnSave.setEnabled(true);
				btnUndo.setEnabled(true);
				jt1.setEditable(true);
				jt2.setEditable(true);
				jt3.setEditable(true);
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
				btnSave.setName("btnSave1");
		      }break;
			case "btnSave1":
			{
				try {
					rs.last();
					rs.moveToInsertRow();
					int id=Integer.valueOf(jt1.getText());
					String nume=jt2.getText();
					int varsta=Integer.valueOf(jt3.getText());
					rs.updateInt(1, id);
					rs.updateString(2,nume);
					rs.updateInt(3,varsta);
					System.out.println(String.valueOf(id));
					rs.insertRow();
					rs.last();
					LastRow=rs.getRow();
					rs.first();
			        UpdateText(rs);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Id acesta a mai fost folosit!");
					jt1.setText("");
					jt2.setText("");
					jt3.setText("");
				}
				btnFirst.setEnabled(true);
				btnPrevious.setEnabled(true);
				btnLast.setEnabled(true);
				btnNext.setEnabled(true);
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				btnFind.setEnabled(true);
				btnSave.setEnabled(false);
				btnUndo.setEnabled(false);
		   }break;
			
			case "btnUndo":
			{
				btnFirst.setEnabled(true);
				btnPrevious.setEnabled(true);
				btnLast.setEnabled(true);
				btnNext.setEnabled(true);
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
				btnFind.setEnabled(true);
				btnDelete.setEnabled(true);
				btnSave.setEnabled(false);
				btnUndo.setEnabled(false);
			    try {
					rs.moveToCurrentRow();
					UpdateText(rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}break;
			case "btnEdit":
			{
				btnFirst.setEnabled(false);
				btnFirst.setEnabled(false);
				btnPrevious.setEnabled(false);
				btnLast.setEnabled(false);
				btnNext.setEnabled(false);
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnFind.setEnabled(false);
				btnSave.setEnabled(true);
				btnUndo.setEnabled(true);
				btnSave.setName("btnSave2");
				jt1.setEditable(true);
				jt2.setEditable(true);
				jt3.setEditable(true);
				
			}break;
			case "btnSave2":
			{
				int id,varsta;
				id=Integer.valueOf(jt1.getText());
				varsta=Integer.valueOf(jt3.getText());
				try {
					rs.updateInt(1, id);
					rs.updateString(2,jt2.getText());
					rs.updateInt(3, varsta);
					rs.updateRow();
					UpdateText(rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Acest id exista!");
				}

				btnFirst.setEnabled(true);
				btnFirst.setEnabled(true);
				btnPrevious.setEnabled(true);
				btnLast.setEnabled(true);
				btnNext.setEnabled(true);
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				btnFind.setEnabled(true);
				btnSave.setEnabled(false);
				btnUndo.setEnabled(false);
			}break;
			case "btnDelete":
			{
				int j=JOptionPane.showConfirmDialog(null,"Sunteti sigur ca vreti sa stergeti aceasta persoana?","Confirmare stergere",JOptionPane.OK_CANCEL_OPTION);
				if(j==0)
				{
					try {
						rs.deleteRow();
						rs.last();
						LastRow=rs.getRow();
						rs.first();
						UpdateText(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}break;
			case "btnFind":
			{
				String nume=JOptionPane.showInputDialog(null,"Numele","Input",JOptionPane.OK_CANCEL_OPTION);
			    int ok=0;
				if(nume!=null)
				{
					try {
						rs.first();
						while(rs.next() && ok==0)
						{
							
							if(rs.getString(2).compareTo(nume)==0)
							{
								ok=1;
								UpdateText(rs);
							}
						}
						if(ok==0)
						{
							JOptionPane.showMessageDialog(null,"Nu s-a gasit persoana cautata");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
				
			}
	   }
   }
  
}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		MainApp frame=new MainApp();
		frame.setVisible(true);
	}

}
