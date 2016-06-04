package catjump;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Menu.EscFrame;

public class Cat {
	public Keying k;
	public EscFrame frame;
	
	int KatzenPos, movement, KatzePosHoehe, KatzenbewegungHoehe;
	Image catImg;
	ImageIcon i = new ImageIcon("Katze.png");
	public boolean jumping = false;
	public boolean space = false;

	public Cat() {
		catImg = i.getImage();
		KatzenPos = 200;
		KatzePosHoehe = 580;
	}
	
	
	public void reset(){
		KatzePosHoehe = 580;
		KatzenPos = 200;
		jumping = false;
		space = false;
		movement = 0;
		KatzenbewegungHoehe = 0;
	}

	public void move() {
		KatzenPos = KatzenPos + movement;
	}

	public void jump() {
		KatzePosHoehe = KatzePosHoehe + KatzenbewegungHoehe;
	}

	public int getX() {
		return KatzenPos;
	}

	public int getY() {
		return KatzePosHoehe;
	}

	public Image getImage() {
		return catImg;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_D) {
			movement = 3;  
		}
		if (key == KeyEvent.VK_A) {
			movement = -3; 
		}

		if (key == KeyEvent.VK_ESCAPE) {
			frame = new EscFrame();
		}

		if (key == KeyEvent.VK_SPACE && jumping == false && k.isFalling() == false) {
			KatzenbewegungHoehe = -8;
			jumping = true;
			space = true;
			new Thread(new ThreadCat(this)).start();
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_D) {
			movement = 0;
		}
		if (key == KeyEvent.VK_A) {
			movement = 0;
		}

		if (key == KeyEvent.VK_SPACE) {
			space = false;
			KatzenbewegungHoehe = 0;
		}
	}

	public int getKatzePos() {
		return KatzenPos;
	}

	public void setKatzePos(int katzePosLinks) {
		KatzenPos = katzePosLinks;
	}

	public int getKatzePosHoehe() {
		return KatzePosHoehe;
	}

	public void setKatzePosHoehe(int katzePosHoehe) {
		KatzePosHoehe = katzePosHoehe;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public int getKatzenbewegungHoehe() {
		return KatzenbewegungHoehe;
	}

	public void setKatzenbewegungHoehe(int katzenbewegungHoehe) {
		KatzenbewegungHoehe = katzenbewegungHoehe;
	}

	public void setCatBoundingBox() {
		new Rectangle(getKatzePos() + 200, getKatzePosHoehe(), 150, 80);
	}

	public Rectangle getCatBoundingBox() {
		return new Rectangle(getKatzePos() + 225, getKatzePosHoehe(), 95, 80);
	}
}
