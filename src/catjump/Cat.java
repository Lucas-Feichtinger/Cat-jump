package catjump;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import Menu.EscMenu;

public class Cat {
	Keying k;
	int KatzePosLinks, Katzenbewegung, KatzePosHoehe, KatzenbewegungHoehe;
	Image catImg;
	ImageIcon i = new ImageIcon("Katze.png");
	public boolean jumping = false;
	public boolean space = false;
	public boolean inAir = false;

	public Cat() {
		catImg = i.getImage();
		KatzePosLinks = 0;

		KatzePosHoehe = 580;
	}

	public void move() {
		KatzePosLinks = KatzePosLinks + Katzenbewegung;
	}

	public void jump() {
		KatzePosHoehe = KatzePosHoehe + KatzenbewegungHoehe;
	}

	public int getX() {
		return KatzePosLinks;
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
			Katzenbewegung = 2;
		}
		if (key == KeyEvent.VK_A) {
			Katzenbewegung = -2;
		}

		if (key == KeyEvent.VK_SPACE && space == false && inAir == false) {

			if (key == KeyEvent.VK_SPACE && space == false) {
				jumping = true;
				KatzenbewegungHoehe = -10;

				if (key == KeyEvent.VK_SPACE && space == false && inAir == false) {
					jumping = true;
					space = true;
					KatzenbewegungHoehe = -5;
					inAir = true;
					KatzenbewegungHoehe = -4;
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
			Katzenbewegung = 0;
		}
		if (key == KeyEvent.VK_A) {
			Katzenbewegung = 0;
		}

		if (key == KeyEvent.VK_SPACE) {
			space = false;
			KatzenbewegungHoehe = 0;
		}
	}

	public int getKatzePosLinks() {
		return KatzePosLinks;
	}

	public void setKatzePosLinks(int katzePosLinks) {
		KatzePosLinks = katzePosLinks;
	}

	public int getKatzePosHoehe() {
		return KatzePosHoehe;
	}

	public void setKatzePosHoehe(int katzePosHoehe) {
		KatzePosHoehe = katzePosHoehe;
	}

	public Rectangle getCatBoundingBox() {
		return new Rectangle(getKatzePosLinks(), getKatzePosHoehe(), 182, 100);
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
