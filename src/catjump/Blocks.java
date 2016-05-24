package catjump;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class Blocks {
	private static List<Rectangle> blocks;
	private static List<Rectangle> blocksLeft;
	private static List<Rectangle> blocksRight;
	private static List<Rectangle> blocksTop;
	private static List<Rectangle> blocksBot;
	private static List<Rectangle> Fallen;

	Cat c = new Cat();
	int heigth = 768;
	int width = 1600;

	public Rectangle BottomBox, WallLeft, block1, block1Top, block1Right, block1Left, block2, block2Left,
			block2Top, block2Bot, block2Right, block3, block3Top, block3Bot, block3Right, block3Left, block4, block4Top,
			block4Bot, block4Left, block4Right, block5, block5Right, block5Left, block5Bot, block6, block6Top,
			block6Right, block6Left, block7, block7Top, block7Rigth, block7Left, block7Bot, block8, block8Bot,
			block8Rigth, block8Left, block9, block9Top, block9Rigth, block9Left, block10, block10Top, block10Bot,
			block10Right, block10Left, block11, block11Top, block11Bot, block11Rigth, block11Left, block12, block12Top,
			block13, block14, block14Bot, block14Rigth, block14Left, block15, block16, block7Right,	spike1,
			grube1, grube2, boden1, boden2, boden3, Lazer1;

	public Blocks() {
		this.blocksLeft = new ArrayList<Rectangle>();
		this.blocksRight = new ArrayList<Rectangle>();
		this.blocksTop = new ArrayList<Rectangle>();
		this.blocksBot = new ArrayList<Rectangle>();
		this.blocks = new ArrayList<Rectangle>();
		this.Fallen = new ArrayList<Rectangle>();

		// Linke Seite der Bl�cke
		blocksLeft.add(WallLeft = new Rectangle(0, 0, 10, 1500));
		blocksLeft.add(block1Left = new Rectangle(1000, heigth - 240, 10, 300));
		blocksLeft.add(block2Left = new Rectangle(1650, heigth - 390, 10, 90));
		blocksLeft.add(block3Left = new Rectangle(2180, heigth - 490, 10, 70));
		blocksLeft.add(block4Left = new Rectangle(2800, heigth - 360, 10, 70));
		blocksLeft.add(block5Left = new Rectangle(3450, heigth - 1125, 10, 500));
		blocksLeft.add(block6Left = new Rectangle(3525, heigth - 440, 10, 500));
		blocksLeft.add(block7Left = new Rectangle(4265, heigth - 280, 10, 70));
		blocksLeft.add(block8Left = new Rectangle(4690, heigth - 1110, 10, 490));
		blocksLeft.add(block9Left = new Rectangle(4690, heigth - 375, 10, 370));
		blocksLeft.add(block10Left = new Rectangle(4940, heigth - 325, 10, 90));


		// Rechte Seite der Bl�cke
		blocksRight.add(block1Right = new Rectangle(1390, heigth - 240, 10, 290));
		blocksRight.add(block2Right = new Rectangle(2040, heigth - 390, 10, 90));
		blocksRight.add(block3Right = new Rectangle(2480, heigth - 490, 10, 70));
		blocksRight.add(block4Right = new Rectangle(3215, heigth - 360, 10, 70));
		blocksRight.add(block5Right = new Rectangle(4040, heigth - 1125, 10, 500));
		blocksRight.add(block6Right = new Rectangle(4115, heigth - 440, 10, 500));
		blocksRight.add(block7Rigth = new Rectangle(4565, heigth - 280, 10, 70));
		blocksRight.add(block8Rigth = new Rectangle(4840, heigth - 1110, 10, 490));
		blocksRight.add(block9Rigth = new Rectangle(4840, heigth - 375, 10, 370));
		blocksRight.add(block10Right = new Rectangle(5330, heigth - 325, 10, 90));


		// Oberseite der Bl�cke
		blocksTop.add(boden1 = new Rectangle(0, heigth - 80, 1400, 50));
		blocksTop.add(boden2 = new Rectangle(1650, heigth - 80, 1600, 50));
		blocksTop.add(boden3 = new Rectangle(3825, heigth - 80, 7000, 50));	
		blocksTop.add(block2Top = new Rectangle(1650, heigth - 400, 400, 10));
		blocksTop.add(block3Top = new Rectangle(2180, heigth - 500, 300, 10));
		blocksTop.add(block1Top = new Rectangle(1000, heigth - 250, 400, 10));
		blocksTop.add(block7Top = new Rectangle(4265, heigth - 290, 310, 10));
		blocksTop.add(block4Top = new Rectangle(2800, heigth - 370, 425, 10));
		blocksTop.add(block6Top = new Rectangle(3525, heigth - 450, 600, 10));
		blocksTop.add(block10Top = new Rectangle(4950, heigth - 325, 360, 10));



		// Unterseite der Bl�cke
		blocksBot.add(block2Bot = new Rectangle(1650, heigth - 300, 400, 10));
		blocksBot.add(block3Bot = new Rectangle(2180, heigth - 420, 300, 10));
		blocksBot.add(block4Bot = new Rectangle(2800, heigth - 290, 425, 20));
		blocksBot.add(block5Bot = new Rectangle(3450, heigth - 625, 600, 10));
		blocksBot.add(block7Bot = new Rectangle(4265, heigth - 210, 310, 10));
		blocksBot.add(block8Bot = new Rectangle(4690, heigth - 620, 160, 10));
		blocksBot.add(block10Bot = new Rectangle(4950, heigth - 225, 380, 10));



		// Bl�cke
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

	public List<Rectangle> getBlocks() {
		return blocks;
	}

	public static List<Rectangle> getBlocksLeft() {
		return blocksLeft;
	}

	public static List<Rectangle> getBlocksRight() {
		return blocksRight;
	}

	public static List<Rectangle> getBlocksTop() {
		return blocksTop;
	}

	public static List<Rectangle> getBlocksBot() {
		return blocksBot;
	}

	public static List<Rectangle> getFallen() {
		return Fallen;
	}
	
}
