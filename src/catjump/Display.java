package catjump;

import javax.swing.*;
import java.awt.*;
public class Display extends JFrame{
		public JPanel gp = (JPanel) getGlassPane();
		public Images i;
		public Keying k;
		public Display(){
			i = new Images();
			gp.setVisible(true);
			k = new Keying(this, i);
			
			gp.setLayout(new GridLayout(1,1,0,0));
			this.setLayout(new GridLayout(1,1,0,0));
			
			gp.add(k);
			this.add(i);
	}
	
}
