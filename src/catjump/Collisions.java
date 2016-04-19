package catjump;

import java.awt.Rectangle;

public class Collisions {
	
	Cat c = new Cat();
	boolean falling = false;
	boolean collisionRigth = false;
	boolean collisionLeft = false;
	
	int heigth = 768;
	public static Rectangle BottomBox, WallLeft, block1, block1Top, block2, block2Top, block3, block3Top, block4, block4Top, block5, block6, block6Top;
	
	public Collisions() {
		WallLeft = new Rectangle(0, 0, 10, 1500);
		BottomBox = new Rectangle(0, heigth - 80, 10000, 50);
		block1 = new Rectangle(1000, heigth - 240, 400, 300);
		block1Top = new Rectangle(1000, heigth - 250, 400, 10);
		block2 = new Rectangle(1650, heigth - 390, 400, 90);
		block2Top = new Rectangle(1650, heigth - 400, 400, 10);
		block3 = new Rectangle(2200, heigth - 490, 300, 70);
		block3Top  = new Rectangle(2200, heigth - 500, 300, 10);
		block4 = new Rectangle(2800, heigth - 360, 425, 70);
		block4Top = new Rectangle(2800, heigth - 370, 425, 10);
		block5 = new Rectangle(3450, heigth - 1125, 600, 500);
		block6 = new Rectangle(3525, heigth - 440, 600, 500);
		block6Top = new Rectangle(3525, heigth - 450, 600, 10);
	}
	
	public void collision() {
		Rectangle bottomBox = BottomBox;
		Rectangle wallLeft = WallLeft;
		Rectangle rect1 = block1;
		Rectangle rect1Top = block1Top;
		Rectangle rect2Top = block2Top;
		Rectangle rect3Top = block3Top;
		Rectangle rect4Top = block4Top;
		Rectangle rect6Top = block6Top;
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

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isCollisionRigth() {
		return collisionRigth;
	}

	public void setCollisionRigth(boolean collisionRigth) {
		this.collisionRigth = collisionRigth;
	}

	public boolean isCollisionLeft() {
		return collisionLeft;
	}

	public void setCollisionLeft(boolean collisionLeft) {
		this.collisionLeft = collisionLeft;
	}
}
