package catjump;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keying extends JPanel implements ActionListener, Runnable {
	Cat c;
	public Image img;
	Timer time;
	Thread animator;
	int v = 588;

	boolean a = false;
	boolean done2 = false;
	boolean collision = false;

	Toolkit tk = Toolkit.getDefaultToolkit();
	int width = 1600;
	int heigth = 768;

	public static Rectangle BottomBox, WallLeft, block1, block2, block3, block4, block5, block6;

	public Keying() {
		WallLeft = new Rectangle(0, 0, 10, 1500);
		BottomBox = new Rectangle(0, heigth - 80, 10000, 50);
		block1 = new Rectangle(1000, heigth - 250, 400, 300);
		block2 = new Rectangle(1650, heigth - 400, 400, 100);
		block3 = new Rectangle(2200, heigth - 500, 300, 80);
		block4 = new Rectangle(2800, heigth - 370, 425, 80);
		block5 = new Rectangle(3450, heigth - 1125, 600, 500);
		block6 = new Rectangle(3525, heigth - 450, 600, 500);

		c = new Cat();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("bg.png");
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		collision();
		if (collision == false)
			c.move();
		repaint();
	}

	boolean k = false;

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		// background
		g2d.drawImage(img, 0, 0, null);
		g2d.drawImage(img, 1485, 0, null);
		g2d.drawImage(img, 3485, 0, null);
		g2d.drawImage(img, 5485, 0, null);
		g2d.drawImage(img, 7485, 0, null);

		g.translate(-c.getKatzePosLinks(), 0);

		if (c.KatzenbewegungHoehe == 1 && done2 == false) {
			done2 = true;
			animator = new Thread(this);
			animator.start();
		}

		// character
		g2d.drawImage(c.getImage(), c.getKatzePosLinks(), c.getKatzePosHoehe(), null);
		Rectangle b = c.getCatBoundingBox();
		g2d.setColor(Color.RED);
		g2d.drawRect(b.x, b.y, b.width, b.height);

		g2d.setColor(Color.BLACK);
		// hintergrund wände
		g.fillRect(WallLeft.x, WallLeft.y, WallLeft.width, WallLeft.height);
		g.fillRect(BottomBox.x, BottomBox.y, BottomBox.width, BottomBox.height);
		g.fillRect(block1.x, block1.y, block1.width, block1.height);
		g.fillRect(block2.x, block2.y, block2.width, block2.height);
		g.fillRect(block3.x, block3.y, block3.width, block3.height);
		g.fillRect(block4.x, block4.y, block4.width, block4.height);
		g.fillRect(block5.x, block5.y, block5.width, block5.height);
		g.fillRect(block6.x, block6.y, block6.width, block6.height);
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			c.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			c.keyPressed(e);
		}
	}

	boolean h = false;
	boolean done = false;

	public void cycle() {

		if (h == false)
			c.KatzePosHoehe -= 4;
		if (c.KatzePosHoehe == 340)
			h = true;
		if (h == true && c.KatzePosHoehe <= 552) {
			c.KatzePosHoehe += 5;
			if (c.KatzePosHoehe == 552) {
				done = true;
			}
		}
	}

	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (done == false) {

			cycle();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 10 - timeDiff;

			if (sleep < 0)
				sleep = 2;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}

			beforeTime = System.currentTimeMillis();
		}
		done = false;
		h = false;
		done2 = false;
	}

	public void collision() {
		Rectangle rectangle1 = block1;
		Rectangle cat = c.getCatBoundingBox();

		if (rectangle1.intersects(cat)) {
			collision = true;
		} else {
			collision = false;
		}
	}

}
