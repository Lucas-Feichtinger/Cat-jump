package catjump;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class Blocks {
	private static List<Rectangle> blocks;
	private static List<Rectangle> Fallen;

	Cat c = new Cat();
	int heigth = 768;
	int width = 1600;

	public Rectangle  WallLeft, block1,  block2, 
			block3, block4, block5, block6,  block7, block8,  block9, block10, block11, block11Top, block12, 
			block13, block14,  block15, block16, spike1,
			grube1, grube2, boden1, boden2, boden3, Lazer1;

	public Blocks() {

		blocks = new ArrayList<Rectangle>();
		Fallen = new ArrayList<Rectangle>();




		// Blöcke
		blocks.add(WallLeft = new Rectangle(0, 0, 10, 1500));
		blocks.add(boden1 = new Rectangle(0, heigth - 80, 1400, 50));
		blocks.add(boden2 = new Rectangle(1650, heigth - 80, 1600, 50));
		blocks.add(boden3 = new Rectangle(3825, heigth - 80, 7000, 50));	
		blocks.add(block1 = new Rectangle(1010, heigth - 240, 380, 300));
		blocks.add(block2 = new Rectangle(1660, heigth - 390, 380, 90));
		blocks.add(block3 = new Rectangle(2190, heigth - 490, 280, 70));
		blocks.add(block4 = new Rectangle(2810, heigth - 360, 380, 90));
		blocks.add(block5 = new Rectangle(34560, heigth - 1125, 580, 500));
		blocks.add(block6 = new Rectangle(3535, heigth - 440, 580, 500));	
		blocks.add(block7 = new Rectangle(4275, heigth - 280, 290, 70));
		blocks.add(block8 = new Rectangle(4700, heigth - 1410, 140, 790));
		blocks.add(block9 = new Rectangle(4700, heigth - 365, 140, 150));
		blocks.add(block10 = new Rectangle(4950, heigth - 325, 380, 90));
		blocks.add(block11 = new Rectangle(5700, heigth - 370, 135, 65));
		blocks.add(block12 = new Rectangle(6050, heigth - 405, 200, 65));
		blocks.add(block13 = new Rectangle(6450, heigth - 300, 465, 750));


		// Fallen
		Fallen.add(Lazer1 = new Rectangle(4690, heigth - 375, 160, 10));
		Fallen.add(grube1 = new Rectangle(1400, heigth - 40, 250, 300));
		Fallen.add(grube2 = new Rectangle(3225, heigth - 40, 300, 300));
		Fallen.add(spike1 = new Rectangle(1990, heigth - 460, 60, 60));
		Fallen.add(grube1 = new Rectangle(1400, heigth - 40, 250, 300));
		Fallen.add(grube2 = new Rectangle(3225, heigth - 40, 300, 300));
		Fallen.add(spike1 = new Rectangle(1990, heigth - 460, 60, 60));
	}

	public static List<Rectangle> getBlocks() {
		return blocks;
	}

	public static List<Rectangle> getFallen() {
		return Fallen;
	}
	
}
