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

	public Blocks() {

		blocks = new ArrayList<Rectangle>();
		Fallen = new ArrayList<Rectangle>();

		// Blöcke
		blocks.add(new Rectangle(0, 0, 10, 1500));
		blocks.add(new Rectangle(0, heigth - 80, 1400, 50));
		blocks.add(new Rectangle(1650, heigth - 80, 1600, 50));
		blocks.add(new Rectangle(3825, heigth - 80, 7000, 50));
		blocks.add(new Rectangle(1010, heigth - 240, 380, 300));
		blocks.add(new Rectangle(1660, heigth - 390, 380, 90));
		blocks.add(new Rectangle(2190, heigth - 490, 280, 70));
		blocks.add(new Rectangle(2810, heigth - 360, 380, 90));
		blocks.add(new Rectangle(34560, heigth - 1125, 580, 500));
		blocks.add(new Rectangle(3535, heigth - 440, 580, 500));
		blocks.add(new Rectangle(4275, heigth - 280, 290, 70));
		blocks.add(new Rectangle(4700, heigth - 1410, 140, 790));
		blocks.add(new Rectangle(4700, heigth - 365, 140, 150));
		blocks.add(new Rectangle(4950, heigth - 325, 380, 90));
		blocks.add(new Rectangle(5700, heigth - 370, 135, 65));
		blocks.add(new Rectangle(6050, heigth - 405, 200, 65));
		blocks.add(new Rectangle(6450, heigth - 300, 465, 750));

		// Fallen
		Fallen.add(new Rectangle(4690, heigth - 375, 160, 10)); // laser
		Fallen.add(new Rectangle(1400, heigth - 40, 250, 300)); // grube
		Fallen.add(new Rectangle(3225, heigth - 40, 300, 300)); // grube
		Fallen.add(new Rectangle(1990, heigth - 460, 60, 60)); // spike
	}

	public static List<Rectangle> getBlocks() {
		return blocks;
	}

	public static List<Rectangle> getFallen() {
		return Fallen;
	}

}
