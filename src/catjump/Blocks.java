package catjump;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Rectangle;

public class Blocks {
	private static List<Rectangle> Fallen;
	private static List<Block> blocks;
	public Image gras;
	public Image stone;
	public Image lava;

	
	Cat c = new Cat();
	int heigth = 768;
	int width = 1600;

	public Blocks() {
		ImageIcon grass = new ImageIcon("Erde.png");
		ImageIcon stein = new ImageIcon("Stein.png");
		ImageIcon magma = new ImageIcon("Lava.png");

		gras = grass.getImage();
		lava = magma.getImage();
		stone = stein.getImage();
		Fallen = new ArrayList<Rectangle>();
		
		blocks = new ArrayList<Block>();

		// Blöcke
		blocks.add(new Block(0, heigth - 600, 300, 1200, gras));
		blocks.add(new Block(0, heigth - 80, 1400, 50, gras));
		blocks.add(new Block(1020, heigth - 240, 380, 300, gras));
		blocks.add(new Block(1650, heigth - 80, 1600, 50, gras));
		blocks.add(new Block(1660, heigth - 390, 380, 100, gras));
		blocks.add(new Block(3825, heigth - 80, 1505, 50, gras));
		blocks.add(new Block(2190, heigth - 490, 280, 100, gras));
		blocks.add(new Block(2810, heigth - 360, 380, 100, gras));
		blocks.add(new Block(3450, heigth - 1125, 580, 500, gras));
		blocks.add(new Block(3535, heigth - 440, 580, 500, gras));
		blocks.add(new Block(4275, heigth - 280, 280, 100, gras));
		blocks.add(new Block(4700, heigth - 1410, 140, 790, gras));
		blocks.add(new Block(4700, heigth - 365, 140, 450, gras));
		blocks.add(new Block(4950, heigth - 325, 380, 100, gras));
		blocks.add(new Block(5800, heigth - 405, 380, 100, gras));
		blocks.add(new Block(5850, heigth - 80, 5000, 50, gras));
		blocks.add(new Block(6450, heigth - 300, 450, 750, stone));
		blocks.add(new Block(6900, heigth - 200, 1900, 150, stone));
		blocks.add(new Block(7300, heigth - 450, 380, 100, stone));
		blocks.add(new Block(8000, heigth - 500, 380, 100, stone));
		blocks.add(new Block(8800, heigth - 300, 450, 750, stone));


		// Fallen
		Fallen.add(new Rectangle(4700, heigth - 375, 140, 10)); // laser
		Fallen.add(new Rectangle(1400, heigth + 40, 250, 300)); // grube
		Fallen.add(new Rectangle(3225, heigth + 40, 300, 300)); // grube
		Fallen.add(new Rectangle(5850, heigth + 40, 300, 600)); // grube
		Fallen.add(new Rectangle(1980, heigth - 450, 60, 60)); // spike
	
	}
	public static List<Block> getBlocks() {
		return blocks;
	}

	public static List<Rectangle> getFallen() {
		return Fallen;
	}
}
