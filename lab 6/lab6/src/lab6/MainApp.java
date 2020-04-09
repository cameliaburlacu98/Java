package lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainApp {
	static  JTextField tf1;
	static  JTextField tf2;
	static  JLabel rez;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,250);
        frame.setLocation(400,400);
        frame.getContentPane().setLayout(new FlowLayout());
        JLabel oplabel1=new JLabel("Operand 1");
        oplabel1.setPreferredSize(new Dimension(120,20));
        tf1=new JTextField();
        tf1.setPreferredSize(new Dimension(120,20));
        JLabel oplabel2=new JLabel("Operand 2");
        oplabel2.setPreferredSize(new Dimension(120,20));
        tf2=new JTextField();
        tf2.setPreferredSize(new Dimension(120,20));
        
        JButton adbtn=new JButton("adunare");
        adbtn.setPreferredSize(new Dimension(120,20));
        adbtn.addActionListener(new Adunare());
        
        JButton scdbtn=new JButton("scadere");
        scdbtn.setPreferredSize(new Dimension(120,20));
        scdbtn.addActionListener(new Scadere());
        
        JButton mulbtn= new JButton("inmultire");
        mulbtn.setPreferredSize(new Dimension(120,20));
        mulbtn.addActionListener(new Inmultire());
        
        JButton impbtn= new JButton("inmultire");
        impbtn.setPreferredSize(new Dimension(120,20));
        impbtn.addActionListener(new Impartire());
        
        rez=new JLabel();
        rez.setOpaque(true);
        rez.setBackground(Color.WHITE);
        rez.setPreferredSize(new Dimension(220,30));
        
        JButton clear=new JButton("Clear");
        clear.setPreferredSize(new Dimension(220,30));
        clear.addActionListener(new Clear());
        
        frame.getContentPane().add(oplabel1);
        frame.getContentPane().add(tf1);
        frame.getContentPane().add(oplabel2);
        frame.getContentPane().add(tf2);
        frame.getContentPane().add(adbtn);
        frame.getContentPane().add(scdbtn);
        frame.getContentPane().add(mulbtn);
        frame.getContentPane().add(impbtn);
        frame.getContentPane().add(rez);
        frame.getContentPane().add(clear);
        frame.setVisible(true);
	}

}
