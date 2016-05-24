package Menu;

import javax.swing.*;
import catjump.Keying;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscMenu extends JFrame implements ActionListener {

	private JButton restart;
	private JButton einstellung;
	private JButton ende;
	public Keying k;

	int xSize = 1600;
	int ySize = 768;

	public EscMenu(String title) {
		super(title);
		
		JLabel jlabel = new JLabel("You Died!");
		
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
			//k.reset();
		}

		if (e.getSource() == einstellung) {
		}

		if (e.getSource() == ende) {
			System.exit(0);
		}

	}
}
