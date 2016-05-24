package catjump;

import javax.swing.*;

import Menu.EscMenu;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;

public class Keying extends JPanel implements ActionListener {

	// TODO Lucas: Jumping; Florian: Kollision
	public int deadTime;
	private EscMenu esc;
	Cat c;
	Blocks block;
	public Image img;
	public Image gras;
	public Image gras1;
	public Image gras2;
	public Image gras3;
	public Image gras4;
	public Image bot1;
	public Image bot2;
	Timer time; // für Repaint
	Thread animator; // für animationen

	public boolean collisionBot = false;
	private static boolean falling = false;
	public boolean collisionRigth = false;
	public boolean collisionLeft = false;
	public boolean dead = false;
	public static boolean escape = false;
	
	int width = 1600;
	int heigth = 768;

	public Keying() {
		block = new Blocks();
		c = new Cat();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("bg.png");
		ImageIcon grass = new ImageIcon("grass.png");
		ImageIcon grass1 = new ImageIcon("grass1.png");
		ImageIcon grass2 = new ImageIcon("grass2.png");
		ImageIcon grass3 = new ImageIcon("grass3.png");
		ImageIcon grass4 = new ImageIcon("grass4.png");
		ImageIcon boden1 = new ImageIcon("bot1.png");
		ImageIcon boden2 = new ImageIcon("bot2.png");
		gras = grass.getImage();
		bot1 = boden1.getImage();
		bot2 = boden2.getImage();
		gras1 = grass1.getImage();
		gras2 = grass2.getImage();
		gras3 = grass3.getImage();
		gras4 = grass4.getImage();
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
		deadTime = 0;
	}

	public void actionPerformed(ActionEvent e) {
		collision();
		
		ShowEscMenu();
		
		if (dead != true) {
			if (collisionRigth == false) {
				c.move();
			} else {
				c.setKatzePos(c.getKatzePos() + 4);
			}

			if (collisionLeft == false) {
				c.move();
			} else if (collisionLeft == true) {
				c.setKatzePos(c.getKatzePos() - 4);
			}

			collision();
			if (falling == true && !c.jumping) {
				c.KatzePosHoehe += 7;
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
	
	
	/*public void reset(){
		*collisionBot = false;
		*falling = false;
		*collisionRigth = false;
		*collisionLeft = false;
		*dead = false;
		*escape = false;
		*c.jumping = false;
		*c.space = false;
		*c.setKatzePos(200);
		*c.setKatzePosHoehe(580);
		*c.setCatBoundingBox();
	}*/

	private void ShowEscMenu() {
		if(dead) {
			if(deadTime <= 100){
				deadTime += 1;
			}
			else{
				if(esc == null){
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
		
		//g.fillRect(block.block6Top.x, block.block6Top.y, block.block6Top.width, block.block6Top.height);
		g.fillRect(block.block6Right.x, block.block6Right.y, block.block6Right.width, block.block6Right.height);
		g.fillRect(block.block5Right.x, block.block5Right.y, block.block5Right.width, block.block5Right.height);
		g.fillRect(block.block5Bot.x, block.block5Bot.y, block.block5Bot.width, block.block5Bot.height);
		g.fillRect(block.block5Left.x, block.block5Left.y, block.block5Left.width, block.block5Left.height);
		g.fillRect(block.block6Left.x, block.block6Left.y, block.block6Left.width, block.block6Left.height);
		g.fillRect(block.block7Left.x, block.block7Left.y, block.block7Left.width, block.block7Left.height);
		g.fillRect(block.block7Top.x, block.block7Top.y, block.block7Top.width, block.block7Top.height);
		g.fillRect(block.block7Rigth.x, block.block7Rigth.y, block.block7Rigth.width, block.block7Rigth.height);
		g.fillRect(block.block7Bot.x, block.block7Bot.y, block.block7Bot.width, block.block7Bot.height);
		g.fillRect(block.block8Bot.x, block.block8Bot.y, block.block8Bot.width, block.block8Bot.height);
		g.fillRect(block.block8Rigth.x, block.block8Rigth.y, block.block8Rigth.width, block.block8Rigth.height);
		g.fillRect(block.block8Left.x, block.block8Left.y, block.block8Left.width, block.block8Left.height);
		g.fillRect(block.block9Left.x, block.block9Left.y, block.block9Left.width, block.block9Left.height);
		g.fillRect(block.block9Rigth.x, block.block9Rigth.y, block.block9Rigth.width, block.block9Rigth.height);
		
		g2d.setColor(Color.BLUE);
		g.fillRect(block.spike1.x,block.spike1.y, block.spike1.width, block.spike1.height);
		g.fillRect(block.Lazer1.x,block.Lazer1.y, block.Lazer1.width, block.Lazer1.height);


		g2d.setColor(Color.BLACK);
		// hintergrund wände
		g2d.drawImage(gras, block.block1.x - 10, block.block1.y - 10, null);
		g2d.drawImage(gras2, block.block2.x - 10, block.block2.y - 10, null);
		g2d.drawImage(gras1, block.block3.x - 10, block.block3.y - 10, null);
		g2d.drawImage(bot1, block.boden1.x, block.boden1.y, null);
		g2d.drawImage(bot2, block.boden2.x, block.boden2.y, null);
		g2d.drawImage(gras2, block.block4.x - 10, block.block4.y - 10, null);
		g2d.drawImage(gras4, block.WallLeft.x - 390, block.WallLeft.y + 130, null);
		g2d.drawImage(gras2, block.block10.x - 10, block.block10.y - 10, null);
		g.fillRect(block.boden3.x, block.boden3.y, block.boden3.width, block.boden3.height);
		g.fillRect(block.block5.x, block.block5.y, block.block5.width, block.block5.height);
		g.fillRect(block.block6.x, block.block6.y, block.block6.width, block.block6.height);
		g.fillRect(block.block7.x, block.block7.y, block.block7.width, block.block7.height);
		g.fillRect(block.block8.x, block.block8.y, block.block8.width, block.block8.height);
		g.fillRect(block.block9.x, block.block9.y, block.block9.width, block.block9.height);
		g.fillRect(block.block10.x, block.block10.y, block.block10.width, block.block10.height);
		g.fillRect(block.block11.x, block.block11.y, block.block11.width, block.block11.height);
		g.fillRect(block.block12.x, block.block12.y, block.block12.width, block.block12.height);
		g.fillRect(block.block13.x, block.block13.y, block.block13.width, block.block13.height);
		g.fillRect(block.block9.x, block.block9.y, block.block9.width, block.block9.height);


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

		collisionLeft = testForCollision(cat, Blocks.getBlocksLeft());

		collisionRigth = testForCollision(cat, Blocks.getBlocksRight());

		falling = !testForCollision(cat, Blocks.getBlocksTop());

		collisionBot = testForCollision(cat, Blocks.getBlocksBot());

		dead = testForCollision(cat, Blocks.getFallen());
	}

	private boolean testForCollision(Rectangle cat, Collection<Rectangle> collisionBoxes) {
		for(Rectangle b : collisionBoxes) {
			if(b.intersects(cat)) {
				return true;
			}
		}
		return false;
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
}
