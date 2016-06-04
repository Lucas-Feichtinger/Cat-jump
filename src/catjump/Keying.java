package catjump;

import javax.swing.*;

import Menu.EscMenu;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class Keying extends JPanel implements ActionListener {

	private EscMenu esc;
	Cat c;
	Blocks block;

	public boolean collisionBot = false;
	public boolean collisionRight = false;
	public boolean collisionLeft = false;
	public boolean dead = false;
	private static boolean falling = false;
	public static boolean escape = false;

	public int width = 1600;
	public int heigth = 768;
	public int deadTime;

	public Image img;
	public Image gras;

	Timer time; // für Repaint
	Thread animator; // für animationen

	public Keying() {
		block = new Blocks();
		c = new Cat();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("bg.png");
		ImageIcon grass = new ImageIcon("grass.png");
		gras = grass.getImage();
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
		deadTime = 0;
	}

	public void reset() {
		collisionBot = false;
		falling = false;
		collisionRight = false;
		collisionLeft = false;
		dead = false;
		escape = false;
		width = 1600;
		heigth = 768;
		deadTime = 0;
	}

	public void actionPerformed(ActionEvent e) {
		collision();

		ShowEscMenu();

		if (dead != true) {
			if (collisionRight == false) {
				c.move();
			} else {
				c.setKatzePos(c.getKatzePos() + 6); // auf meinem laptop 4
			}

			if (collisionLeft == false) {
				c.move();
			} else if (collisionLeft == true) {
				c.setKatzePos(c.getKatzePos() - 6); // auf meinem laptop 4
			}

			collision();
			if (falling == true && !c.jumping) {
				c.KatzePosHoehe += 9; // auf meinem laptop 6
			} else {
				c.jump();
			}

			if (collisionBot == false) {
				c.move();
			} else if (collisionBot == true) {
				c.setKatzenbewegungHoehe(0);
				falling = true;
			}
			repaint();
		}
	}

	private void ShowEscMenu() {
		if (dead) {
			if (deadTime <= 100) {
				deadTime += 1;
			} else {
				if (esc == null) {
					esc = new EscMenu("Menü");
					esc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					esc.setSize(300, 320);
					esc.setLocationRelativeTo(null);
					esc.setLayout(null);
					esc.setVisible(true);
				}
			}
		}
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

		g.translate(-c.getKatzePos(), 0);

		// character
		g2d.drawImage(c.getImage(), c.getKatzePos() + 200, c.getKatzePosHoehe(), null);
		Rectangle b = c.getCatBoundingBox();
		g2d.setColor(Color.RED);
		g2d.drawRect(b.x, b.y, b.width, b.height);

		g2d.setColor(Color.BLUE);

		for (Rectangle falle : Blocks.getFallen()) {
			g2d.fillRect(falle.x, falle.y, falle.width, falle.height);
		}

		g2d.setColor(Color.BLACK);
		// hintergrund wände

		for (Block block : Blocks.getBlocks()) {
			g2d.drawImage(block.getTexture(), block.x, block.y, block.width, block.height, null);
		}

		// TODO: image zu block dazuspeichern, damit wir wissen was wir anzeigen
		// muessen
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
		Rectangle cat = c.getCatBoundingBox();

		collisionLeft = false;
		collisionRight = false;
		falling = true;
		collisionBot = false;
		for (Block block : Blocks.getBlocks()) {

			CollisionDirection collision = testCollision(cat, block);

			if (collision == null) {
				continue;
			}

			switch (collision) {
			case LEFT:
				collisionLeft = true;
				break;
			case RIGHT:
				collisionRight = true;
				break;
			case TOP:
				falling = false;
				break;
			case BOT:
				collisionBot = true;
				break;
			}

		}

		dead = false;
		for (Rectangle falle : Blocks.getFallen()) {
			if (testCollision(cat, falle) != null) {
				dead = true;
				break;
			}
		}
	}

	enum CollisionDirection {
		LEFT, RIGHT, TOP, BOT
	}

	private CollisionDirection testCollision(Rectangle cat, Rectangle falle) {

		Rectangle2D intersection = cat.createIntersection(falle);

		if (intersection.isEmpty()) {
			return null;
		}

		CollisionDirection direction = null;

		if (intersection.getY() == falle.getY()) {
			direction = CollisionDirection.TOP;
		}

		if (intersection.getMaxY() == falle.getMaxY()) {
			direction = CollisionDirection.BOT;
		}

		if (direction == null || intersection.getHeight() > intersection.getWidth()) {
			if (intersection.getX() == falle.getX()) {
				direction = CollisionDirection.LEFT;
			}

			if (intersection.getMaxX() == falle.getMaxX()) {
				direction = CollisionDirection.RIGHT;
			}
		}

		return direction;
	}

	public Cat getC() {
		return c;
	}

	public static boolean isEscape() {
		return escape;
	}

	public void setEscape(boolean escape) {
		Keying.escape = escape;
	}

	public static boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
}
