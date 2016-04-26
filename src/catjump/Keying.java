package catjump;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keying extends JPanel implements ActionListener {

	// TODO Lucas: Jumping; Florian: Kollision

	Cat c;
	blocks block;
	public Image img;
	public Image gras;
	public Image gras1;
	public Image gras2;
	public Image gras0;
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
		ImageIcon grass = new ImageIcon("grass.png");
		ImageIcon grass0 = new ImageIcon("grass0.png");
		ImageIcon grass1 = new ImageIcon("grass1.png");
		ImageIcon grass2 = new ImageIcon("grass2.png");
		gras = grass.getImage();
		gras0 = grass0.getImage();
		gras1 = grass1.getImage();
		gras2 = grass2.getImage();
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

		g.fillRect(block.block4Top.x, block.block4Top.y, block.block4Top.width, block.block4Top.height);
		g.fillRect(block.block6Top.x, block.block6Top.y, block.block6Top.width, block.block6Top.height);
		g.fillRect(block.block4Right.x, block.block4Right.y, block.block4Right.width, block.block4Right.height);
		g.fillRect(block.block6Right.x, block.block6Right.y, block.block6Right.width, block.block6Right.height);
		g.fillRect(block.block5Right.x, block.block5Right.y, block.block5Right.width, block.block5Right.height);
		g.fillRect(block.block3Bot.x, block.block3Bot.y, block.block3Bot.width, block.block3Bot.height);
		g.fillRect(block.block5Bot.x, block.block5Bot.y, block.block5Bot.width, block.block5Bot.height);
		g.fillRect(block.block4Left.x, block.block4Left.y, block.block4Left.width, block.block4Left.height);
		g.fillRect(block.block3Left.x, block.block3Left.y, block.block3Left.width, block.block3Left.height);
		g.fillRect(block.block3Right.x, block.block3Right.y, block.block3Right.width, block.block3Right.height);
		g.fillRect(block.block2Left.x, block.block2Left.y, block.block2Left.width, block.block2Left.height);
		g.fillRect(block.block1Left.x, block.block1Left.y, block.block1Left.width, block.block1Left.height);
		g.fillRect(block.block5Left.x, block.block5Left.y, block.block5Left.width, block.block5Left.height);
		g.fillRect(block.block6Left.x, block.block6Left.y, block.block6Left.width, block.block6Left.height);
		g.fillRect(block.block7Left.x, block.block7Left.y, block.block7Left.width, block.block7Left.height);
		g.fillRect(block.block7Top.x, block.block7Top.y, block.block7Top.width, block.block7Top.height);
		g.fillRect(block.block7Rigth.x, block.block7Rigth.y, block.block7Rigth.width, block.block7Rigth.height);
		g.fillRect(block.block7Bot.x, block.block7Bot.y, block.block7Bot.width, block.block7Bot.height);

		g2d.setColor(Color.BLACK);
		// hintergrund wände
		g.fillRect(block.WallLeft.x, block.WallLeft.y, block.WallLeft.width, block.WallLeft.height);
		g.fillRect(block.BottomBox.x, block.BottomBox.y, block.BottomBox.width, block.BottomBox.height);
		g.fillRect(block.block4.x, block.block4.y, block.block4.width, block.block4.height);
		g.fillRect(block.block5.x, block.block5.y, block.block5.width, block.block5.height);
		g.fillRect(block.block6.x, block.block6.y, block.block6.width, block.block6.height);
		g2d.drawImage(gras, block.block1.x -10, block.block1.y - 10, null);
		g2d.drawImage(gras2, block.block2.x -10, block.block2.y - 10 , null);
		g2d.drawImage(gras1, block.block3.x -10, block.block3.y - 10 , null);
		g2d.drawImage(gras0, block.BottomBox.x -10, block.BottomBox.y, null);
		g.fillRect(block.block7.x, block.block7.y, block.block7.width, block.block7.height);
		g.fillRect(block.block8.x, block.block8.y, block.block8.width, block.block8.height);
		g.fillRect(block.block9.x, block.block9.y, block.block9.width, block.block9.height);
		g.fillRect(block.block10.x, block.block10.y, block.block10.width, block.block10.height);
		g.fillRect(block.block11.x, block.block11.y, block.block11.width, block.block11.height);
		g.fillRect(block.block12.x, block.block12.y, block.block12.width, block.block12.height);
		g.fillRect(block.block13.x, block.block13.y, block.block13.width, block.block13.height);
		
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
		Rectangle rect1Left = block.block1Left;
		Rectangle rect1Top = block.block1Top;
		Rectangle rect1Right = block.block1Right;
		Rectangle rect2Left = block.block2;
		Rectangle rect2Top = block.block2Top;
		Rectangle rect2Right = block.block2Right;
		Rectangle rect2Bot = block.block2Bot;
		Rectangle rect3Left = block.block3Left;
		Rectangle rect3Top = block.block3Top;
		Rectangle rect3Right = block.block3Right;
		Rectangle rect3Bot = block.block3Bot;
		Rectangle rect4Left = block.block4Left;
		Rectangle rect4Top = block.block4Top;
		Rectangle rect4Right = block.block4Right;
		Rectangle rect4Bot = block.block4Bot;
		Rectangle rect5Left = block.block5Left;
		Rectangle rect5Right = block.block5Right;
		Rectangle rect5Bot = block.block5Bot;
		Rectangle rect6Left = block.block6Left;
		Rectangle rect6Top = block.block6Top;
		Rectangle rect6Right = block.block6Right;
		Rectangle cat = c.getCatBoundingBox();

		if (rect1Left.intersects(cat)|| rect2Left.intersects(cat)|| rect3Left.intersects(cat) || rect4Left.intersects(cat)|| rect5Left.intersects(cat) || rect6Left.intersects(cat)) {
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

		if (rect5Bot.intersects(cat) || rect2Bot.intersects(cat) || rect3Bot.intersects(cat) || rect4Bot.intersects(cat)) {
			collisionBot = true;
		} else {
			collisionBot = false;
		}
	}

	public Cat getC() {
		return c;
	}


	
	
	

}
