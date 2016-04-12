package catjump;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

	private JButton start;
	private JButton einstellung;
	private JButton info;
	private JButton ende;

	int width = 1600;
	int heigth = 768;

	public static void main(String[] args) {

		Main frame = new Main("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	

	public Main(String title) {
		super(title);

		start = new JButton("Spiel starten");
		start.setBounds(120, 40, 160, 40);
		start.addActionListener(this);
		add(start);

		einstellung = new JButton("Einstellungen");
		einstellung.setBounds(120, 120, 160, 40);
		einstellung.addActionListener(this);
		add(einstellung);

		info = new JButton("Credits");
		info.setBounds(120, 200, 160, 40);
		info.addActionListener(this);
		add(info);

		ende = new JButton("Ende");
		ende.setBounds(120, 280, 160, 40);
		ende.addActionListener(this);
		add(ende);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			JFrame f= new JFrame();
			f.add(new Keying());
			f.setSize(width , heigth);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("Cat Jump");
			f.setLocationRelativeTo(null);
			this.dispose();
		}

		if (e.getSource() == info) {
			Object[] options = { "OK" };

			JOptionPane.showOptionDialog(null, "Programmiert von Lucas Feichtinger und Florian Czakoi !", "Information", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}

		if (e.getSource() == einstellung) {
		}

		if (e.getSource() == ende) {
			System.exit(0);
		}

	}
}
