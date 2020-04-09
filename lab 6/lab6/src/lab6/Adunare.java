package lab6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Adunare implements ActionListener{
   public void actionPerformed(ActionEvent e)
   {
	   int op1,op2;
	   op1=Integer.parseInt(MainApp.tf1.getText());
	   op2=Integer.parseInt(MainApp.tf2.getText());
	   MainApp.rez.setText(String.valueOf(op1+op2));
   }
}
