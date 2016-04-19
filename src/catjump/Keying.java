package catjump;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keying extends JPanel implements ActionListener {

	// TODO Lucas: Jumping; Florian: Kollision

	Cat c;
	Collisions col;
	public Image img;
	Timer time; //für Repaint
	Thread animator; // für animationen

	boolean falling = false;
	boolean collisionRigth = false;
	boolean collisionLeft = false;

	int width = 1600;
	int heigth = 768;

	public Keying() {
		col = new Collisions();
		c = new Cat();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("bg.png");
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		col.collision();

		if (col.getCollisionRigth == false) {
			c.move();
		} else {
			c.setKatzePosLinks(c.getKatzePosLinks() - 4);
		}

		if (col.getCollisionLeft == false) {
			c.move();
		} else if (collisionLeft == true) {
			c.setKatzePosLinks(c.getKatzePosLinks() + 1);
		}

		col.collision();
		if (col.getFalling == false && !c.jumping) {
			c.KatzePosHoehe += 5;
		} else {
			c.jump();
		}
		repaint();
	}

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

		// character
		g2d.drawImage(c.getImage(), c.getKatzePosLinks(), c.getKatzePosHoehe(), null);
		Rectangle b = c.getCatBoundingBox();
		g2d.setColor(Color.RED);
		g2d.drawRect(b.x, b.y, b.width, b.height);

		g.fillRect(block1Top.x, block1Top.y, block1Top.width, block1Top.height);
		g.fillRect(block2Top.x, block2Top.y, block2Top.width, block2Top.height);
		g.fillRect(block3Top.x, block3Top.y, block3Top.width, block3Top.height);
		g.fillRect(block4Top.x, block4Top.y, block4Top.width, block4Top.height);
		g.fillRect(block6Top.x, block6Top.y, block6Top.width, block6Top.height);
		
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

	public Cat getC() {
		return c;
	}


	
	
	

}
