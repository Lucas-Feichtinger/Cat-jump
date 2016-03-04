package catjump;

import javax.swing.JFrame;

public class Main {
	public static Display f = new Display();
	public static int h = 1000;
	public static int w = 1500;
	
	public static void main(String[] args) {
		f.setSize(w , h);
		f.setResizable(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Cat Jump");
		f.setLocationRelativeTo(null);
		f.setAlwaysOnTop(true);
	}

}
