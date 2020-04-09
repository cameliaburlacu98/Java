package lab6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clear implements ActionListener{
   public void actionPerformed(ActionEvent e)
   {
	   MainApp.rez.setText(null);
   }
}
