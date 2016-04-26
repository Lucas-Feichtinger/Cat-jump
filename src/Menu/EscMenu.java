package Menu;

import javax.swing.*;
import catjump.Keying;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscMenu extends JFrame implements ActionListener {

	private JButton restart;
	private JButton einstellung;
	private JButton ende;

	int xSize = 1600;
	int ySize = 768;

	public static void main(String[] args) {
		EscMenu frame = new EscMenu("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 320);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public EscMenu(String title) {
		super(title);

		restart = new JButton("Spiel restarten");
		restart.setBounds(60, 40, 160, 40);
		restart.addActionListener(this);
		add(restart);

		einstellung = new JButton("Einstellungen");
		einstellung.setBounds(60, 120, 160, 40);
		einstellung.addActionListener(this);
		add(einstellung);

		ende = new JButton("Ende");
		ende.setBounds(60, 200, 160, 40);
		ende.addActionListener(this);
		add(ende);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == restart) {
			this.dispose();
			JFrame f = new JFrame();
			f.add(new Keying());
			f.setSize(xSize, ySize);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("Cat Jump");
			f.setLocationRelativeTo(null);
		}

		if (e.getSource() == einstellung) {
		}

		if (e.getSource() == ende) {
			System.exit(0);
		}

	}
}
