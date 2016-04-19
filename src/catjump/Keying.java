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
		collision();

		if (collisionRigth == false) {
			c.move();
		} else {
			c.setKatzePosLinks(c.getKatzePosLinks() - 4);
		}

		if (collisionLeft == false) {
			c.move();
		} else if (collisionLeft == true) {
			c.setKatzePosLinks(c.getKatzePosLinks() + 1);
		}

		collision();
		if (falling == false && !c.jumping) {
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

		g.fillRect(col.block1Top.x, col.block1Top.y, col.block1Top.width, col.block1Top.height);
		g.fillRect(col.block2Top.x, col.block2Top.y, col.block2Top.width, col.block2Top.height);
		g.fillRect(col.block3Top.x, col.block3Top.y, col.block3Top.width, col.block3Top.height);
		g.fillRect(col.block4Top.x, col.block4Top.y, col.block4Top.width, col.block4Top.height);
		g.fillRect(col.block6Top.x, col.block6Top.y, col.block6Top.width, col.block6Top.height);
		
		g2d.setColor(Color.BLACK);
		// hintergrund wände
		g.fillRect(col.WallLeft.x, col.WallLeft.y, col.WallLeft.width, col.WallLeft.height);
		g.fillRect(col.BottomBox.x, col.BottomBox.y, col.BottomBox.width, col.BottomBox.height);
		g.fillRect(col.block1.x, col.block1.y, col.block1.width, col.block1.height);
		g.fillRect(col.block2.x, col.block2.y, col.block2.width, col.block2.height);
		g.fillRect(col.block3.x, col.block3.y, col.block3.width, col.block3.height);
		g.fillRect(col.block4.x, col.block4.y, col.block4.width, col.block4.height);
		g.fillRect(col.block5.x, col.block5.y, col.block5.width, col.block5.height);
		g.fillRect(col.block6.x, col.block6.y, col.block6.width, col.block6.height);
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			c.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			c.keyPressed(e);
		}
	}
	
	public void collision() {
		Rectangle bottomBox = col.BottomBox;
		Rectangle wallLeft = col.WallLeft;
		Rectangle rect1 = col.block1;
		Rectangle rect1Top = col.block1Top;
		Rectangle rect2Top = col.block2Top;
		Rectangle rect3Top = col.block3Top;
		Rectangle rect4Top = col.block4Top;
		Rectangle rect6Top = col.block6Top;
		Rectangle cat = c.getCatBoundingBox();

		if (rect1.intersects(cat)) {
			collisionRigth = true;

		} else {
			collisionRigth = false;
		}

		if (bottomBox.intersects(cat) || rect1Top.intersects(cat) || rect2Top.intersects(cat) ||  rect3Top.intersects(cat) || rect4Top.intersects(cat) || rect6Top.intersects(cat)){                          
			falling = true;
			c.setInAir(false);
		} else {
			falling = false;
		}
	}
	
	public Cat getC() {
		return c;
	}

}
