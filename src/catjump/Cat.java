package catjump;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import Menu.EscMenu;

public class Cat {
	Keying k;
	EscMenu esc = new EscMenu(null);
	int KatzenPos, movement, KatzePosHoehe, KatzenbewegungHoehe;
	Image catImg;
	ImageIcon i = new ImageIcon("Katze.png");
	public boolean jumping = false;
	public boolean space = false;
	public boolean inAir = false;

	public Cat() {
		catImg = i.getImage();
		KatzenPos = 200;

		KatzePosHoehe = 580;
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

			movement = 2;

		}
		if (key == KeyEvent.VK_A) {


			movement = -1;

		}

		if (key == KeyEvent.VK_ESCAPE) {
			EscMenu.main(null);
		}

		if (key == KeyEvent.VK_SPACE && space == false && inAir == false) {

			if (key == KeyEvent.VK_SPACE && space == false) {
				jumping = true;
				
				KatzenbewegungHoehe = -5;

				if (key == KeyEvent.VK_SPACE && space == false && inAir == false) {
					jumping = true;
					space = true;
					inAir = true;
					new Thread(new thread(this)).start();
				}
				if (key == KeyEvent.VK_ESCAPE) {
					EscMenu.main(null);
				}
			}
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

	public Rectangle getCatBoundingBox() {
		return new Rectangle(getKatzePos() + 200, getKatzePosHoehe(), 150, 80);
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public boolean isInAir() {
		return inAir;
	}

	public void setInAir(boolean inAir) {
		this.inAir = inAir;
	}

	public int getKatzenbewegungHoehe() {
		return KatzenbewegungHoehe;
	}

	public void setKatzenbewegungHoehe(int katzenbewegungHoehe) {
		KatzenbewegungHoehe = katzenbewegungHoehe;
	}
}
