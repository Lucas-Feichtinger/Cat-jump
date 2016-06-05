package Menu;

import javax.swing.*;
import catjump.Keying;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

	private JButton start;
	private JButton steuerung;
	private JButton info;
	private JButton ende;

	int width = 1600;
	int heigth = 768;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		Main frame = new Main("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 390);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public Main(String title) {
		super(title);

		start = new JButton("Spiel starten");
		start.setBounds(110, 30, 180, 50);
		start.addActionListener(this);
		add(start);

		steuerung = new JButton("Steuerung");
		steuerung.setBounds(110, 110, 180, 50);
		steuerung.addActionListener(this);
		add(steuerung);

		info = new JButton("Credits");
		info.setBounds(110, 190, 180, 50);
		info.addActionListener(this);
		add(info);

		ende = new JButton("Ende");
		ende.setBounds(110, 270, 180, 50);
		ende.addActionListener(this);
		add(ende);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			JFrame f = new JFrame();
			f.add(new Keying());
			f.setSize(width, heigth);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("Cat Jump");
			f.setLocationRelativeTo(null);
			this.dispose();
		}

		if (e.getSource() == info) {
			Object[] options = { "OK" };

			JOptionPane.showOptionDialog(null, "Programmiert von Lucas Feichtinger, Florian Czakoi hat rumgepfuscht!",
					"Credits", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}

		if (e.getSource() == steuerung) {
			SteuerungFrame f = new SteuerungFrame();
		}

		if (e.getSource() == ende) {
			System.exit(0);
		}

	}
}
