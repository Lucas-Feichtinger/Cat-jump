package catjump;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keying extends JPanel implements ActionListener {

	// TODO Lucas: Jumping; Florian: Kollision

	Cat c;
	blocks block;
	public Image img;
	Timer time; // für Repaint
	Thread animator; // für animationen

	boolean collisionBot = false;
	boolean falling = false;
	boolean collisionRigth = false;
	boolean collisionLeft = false;

	int width = 1600;
	int heigth = 768;

	public Keying() {
		block = new blocks();
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
			c.setKatzePosLinks(c.getKatzePosLinks() + 3);
		}

		if (collisionLeft == false) {
			c.move();
		} else if (collisionLeft == true) {
			c.setKatzePosLinks(c.getKatzePosLinks() - 3);
		}

		collision();
		if (falling == false && !c.jumping) {
			c.KatzePosHoehe += 5;
		} else {
			c.jump();
		}
		
		if (collisionBot == false) {
			c.move();
		}	else if (collisionBot == true) {
			c.setKatzenbewegungHoehe(0);
			falling = false;
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


		g.fillRect(block.block1Top.x, block.block1Top.y, block.block1Top.width, block.block1Top.height);
		g.fillRect(block.block2Top.x, block.block2Top.y, block.block2Top.width, block.block2Top.height);
		g.fillRect(block.block3Top.x, block.block3Top.y, block.block3Top.width, block.block3Top.height);
		g.fillRect(block.block4Top.x, block.block4Top.y, block.block4Top.width, block.block4Top.height);
		g.fillRect(block.block6Top.x, block.block6Top.y, block.block6Top.width, block.block6Top.height);
		g.fillRect(block.block1Right.x, block.block1Right.y, block.block1Right.width, block.block1Right.height);
		g.fillRect(block.block2Right.x, block.block2Right.y, block.block2Right.width, block.block2Right.height);
		g.fillRect(block.block3Right.x, block.block3Right.y, block.block3Right.width, block.block3Right.height);
		g.fillRect(block.block4Right.x, block.block4Right.y, block.block4Right.width, block.block4Right.height);
		g.fillRect(block.block6Right.x, block.block6Right.y, block.block6Right.width, block.block6Right.height);
		g.fillRect(block.block5Right.x, block.block5Right.y, block.block5Right.width, block.block5Right.height);
		g.fillRect(block.block2Bot.x, block.block2Bot.y, block.block2Bot.width, block.block2Bot.height);
		g.fillRect(block.block3Bot.x, block.block3Bot.y, block.block3Bot.width, block.block3Bot.height);
		g.fillRect(block.block4Bot.x, block.block4Bot.y, block.block4Bot.width, block.block4Bot.height);
		g.fillRect(block.block5Bot.x, block.block5Bot.y, block.block5Bot.width, block.block5Bot.height);

		g2d.setColor(Color.BLACK);
		// hintergrund wände
		g.fillRect(block.WallLeft.x, block.WallLeft.y, block.WallLeft.width, block.WallLeft.height);
		g.fillRect(block.BottomBox.x, block.BottomBox.y, block.BottomBox.width, block.BottomBox.height);
		g.fillRect(block.block1.x, block.block1.y, block.block1.width, block.block1.height);
		g.fillRect(block.block2.x, block.block2.y, block.block2.width, block.block2.height);
		g.fillRect(block.block3.x, block.block3.y, block.block3.width, block.block3.height);
		g.fillRect(block.block4.x, block.block4.y, block.block4.width, block.block4.height);
		g.fillRect(block.block5.x, block.block5.y, block.block5.width, block.block5.height);
		g.fillRect(block.block6.x, block.block6.y, block.block6.width, block.block6.height);
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

		Rectangle bottomBox = block.BottomBox;
		Rectangle wallLeft = block.WallLeft;
		Rectangle rect1 = block.block1;
		Rectangle rect1Top = block.block1Top;
		Rectangle rect1Right = block.block1Right;
		Rectangle rect2 = block.block2;
		Rectangle rect2Top = block.block2Top;
		Rectangle rect2Right = block.block2Right;
		Rectangle rect3 = block.block3;
		Rectangle rect3Top = block.block3Top;
		Rectangle rect3Right = block.block3Right;
		Rectangle rect4 = block.block4;
		Rectangle rect4Top = block.block4Top;
		Rectangle rect4Right = block.block4Right;
		Rectangle rect5 = block.block5;
		Rectangle rect5Right = block.block5Right;
		Rectangle rect5Bot = block.block5Bot;
		Rectangle rect6 = block.block6;
		Rectangle rect6Top = block.block6Top;
		Rectangle rect6Right = block.block6Right;
		Rectangle cat = c.getCatBoundingBox();

		if (rect1.intersects(cat)|| rect2.intersects(cat)|| rect3.intersects(cat) || rect4.intersects(cat)|| rect5.intersects(cat) || rect6.intersects(cat)) {
			collisionLeft = true;
		} else {
			collisionLeft = false;
		}

		if (rect1Right.intersects(cat) || rect2Right.intersects(cat) || rect3Right.intersects(cat)
				|| rect4Right.intersects(cat) || rect5Right.intersects(cat) || rect6Right.intersects(cat)) {

			collisionRigth = true;
		} else {
			collisionRigth = false;
		}
		


		if (bottomBox.intersects(cat) || rect1Top.intersects(cat) || rect2Top.intersects(cat)
				|| rect3Top.intersects(cat) || rect4Top.intersects(cat) || rect6Top.intersects(cat)) {
			falling = true;
			c.setInAir(false);
		} else {
			falling = false;
		}

		if (rect5Bot.intersects(cat)) {
			collisionBot = true;
		} else {
			collisionBot = false;
		}
	}

	public Cat getC() {
		return c;
	}


	
	
	

}
