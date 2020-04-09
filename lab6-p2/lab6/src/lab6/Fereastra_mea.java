package lab6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class Fereastra_mea extends JFrame {
     private JTextField tf;
	 private DefaultListModel model=new DefaultListModel();
	 private JList lista=new JList(model);
	 public Fereastra_mea()
	 {
		 super("Muzica");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(350,350);
		 setLocation(400,400);
		 getContentPane().setLayout(new BorderLayout());
		 tf=new JTextField();
		 tf.addActionListener(new Adauga());
		 JButton sterg=new JButton("Stergere");
		 sterg.addActionListener(new Stergere());
		 getContentPane().add(BorderLayout.NORTH,tf);
		 getContentPane().add(BorderLayout.CENTER,lista);
		 getContentPane().add(BorderLayout.SOUTH,sterg);
	 }
	public class Adauga implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.addElement(tf.getText());
		}
	}
	public class Stergere implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int n[]=lista.getSelectedIndices();
			for(int i=n.length-1;i>=0;i--)
			{
				model.removeElementAt(n[i]);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame=new Fereastra_mea();
        frame.setVisible(true);
	}

}
