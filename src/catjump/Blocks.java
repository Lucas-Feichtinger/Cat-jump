package catjump;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Rectangle;

public class Blocks {
	private static List<Block> fallen;
	private static List<Block> blocks;
	public Image gras;
	public Image stone;
	public Image lava;
	public Image spike;

	
	Cat c = new Cat();
	int heigth = 768;
	int width = 1600;

	public Blocks() {
		ImageIcon grass = new ImageIcon("Erde.png");
		ImageIcon stein = new ImageIcon("Stein.png");
		ImageIcon magma = new ImageIcon("Lava.png");
		ImageIcon spikes = new ImageIcon("Spikes.png");


		gras = grass.getImage();
		lava = magma.getImage();
		stone = stein.getImage();
		spike = spikes.getImage();
		fallen = new ArrayList<Block>();
		
		blocks = new ArrayList<Block>();

		// Blöcke
		blocks.add(new Block(0, heigth - 600, 300, 1200, gras));
		blocks.add(new Block(1020, heigth - 240, 380, 300, gras));
		blocks.add(new Block(1660, heigth - 390, 380, 100, gras));
		blocks.add(new Block(2190, heigth - 490, 280, 100, gras));
		blocks.add(new Block(2810, heigth - 360, 380, 100, gras));
		blocks.add(new Block(3450, heigth - 1125, 580, 500, gras));
		blocks.add(new Block(3535, heigth - 440, 580, 500, gras));
		blocks.add(new Block(4275, heigth - 280, 280, 100, gras));
		blocks.add(new Block(4700, heigth - 900, 140, 300, gras));
		blocks.add(new Block(4700, heigth - 365, 140, 290, gras));
		blocks.add(new Block(4950, heigth - 325, 380, 100, gras));
		blocks.add(new Block(5800, heigth - 405, 380, 100, gras));
		blocks.add(new Block(6450, heigth - 300, 450, 750, stone));
		blocks.add(new Block(6900, heigth - 200, 1900, 400, stone));
		blocks.add(new Block(7300, heigth - 450, 380, 100, stone));
		blocks.add(new Block(8000, heigth - 500, 380, 100, stone));
		blocks.add(new Block(8800, heigth - 300, 450, 750, stone));
		
		blocks.add(new Block(300, heigth - 80, 720, 500, gras));
		blocks.add(new Block(1650, heigth - 80, 1600, 500, gras));
		blocks.add(new Block(4115, heigth - 80, 1195, 500, gras));
		blocks.add(new Block(5850, heigth - 80, 600, 700, gras));
		blocks.add(new Block(9250, heigth - 80, 4400, 700, stone));

		
		
		// Fallen
		fallen.add(new Block(6900, heigth - 280, 1900, 80, lava));
		fallen.add(new Block(1400, heigth + 50, 250, 300, spike)); // grube
		fallen.add(new Block(3235, heigth + 50, 300, 300, spike)); // grube
		fallen.add(new Block(5310, heigth + 50, 540, 400, lava)); // grube
		fallen.add(new Block(1980, heigth - 450, 60, 60, spike)); // Spike
		fallen.add(new Block(4700, heigth - 375, 140, 10, spike)); // Laser
	
	}
	public static List<Block> getBlocks() {
		return blocks;
	}

	public static List<Block> getFallen() {
		return fallen;
	}
}
