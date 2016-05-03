package catjump;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class blocks {
	private List<Rectangle> blocks;
	Cat c = new Cat();
	int heigth = 768;
	int width = 1600;

	public static Rectangle BottomBox, WallLeft, block1, block1Top, block1Right, block1Left, block2, block2Left,
			block2Top, block2Bot, block2Right, block3, block3Top, block3Bot, block3Right, block3Left, block4, block4Top,
			block4Bot, block4Left, block4Right, block5, block5Right, block5Left, block5Bot, block6, block6Top,
			block6Right, block6Left, block7, block7Top, block7Rigth, block7Left, block7Bot, block8, block8Bot,
			block8Rigth, block8Left, block9, block9Top, block9Rigth, block9Left, block10, block10Top, block10Bot,
			block10Rigth, block10Left, block11, block11Top, block11Bot, block11Rigth, block11Left, block12, block12Top
			,block13, block14, block14Bot, block14Rigth, block14Left, block15, block16, block7Right;

	public static Rectangle spike1, grube1, grube2, boden1, boden2, boden3, Lazer1;

	public blocks() {
		blocks.add(WallLeft = new Rectangle(0, 0, 10, 1500));
		blocks.add(block1 = new Rectangle(1010, heigth - 240, 380, 300));
		blocks.add(block1Top = new Rectangle(1000, heigth - 250, 400, 10));
		blocks.add(block1Left = new Rectangle(1000, heigth - 240, 10, 300));
		blocks.add(block1Right = new Rectangle(1390, heigth - 240, 10, 290));
		blocks.add(block2 = new Rectangle(1660, heigth - 390, 380, 90));
		blocks.add(block2Right = new Rectangle(2040, heigth - 390, 10, 90));
		blocks.add(block2Left = new Rectangle(1650, heigth - 390, 10, 90));
		blocks.add(block2Top = new Rectangle(1650, heigth - 400, 400, 10));
		blocks.add(block2Bot = new Rectangle(1650, heigth - 300, 400, 10));
		blocks.add(block3 = new Rectangle(2190, heigth - 490, 280, 70));
		blocks.add(block3Left = new Rectangle(2180, heigth - 490, 10, 70));
		blocks.add(block3Top = new Rectangle(2180, heigth - 500, 300, 10));
		blocks.add(block3Bot = new Rectangle(2180, heigth - 420, 300, 10));
		blocks.add(block3Right = new Rectangle(2480, heigth - 490, 10, 70));
		blocks.add(block4 = new Rectangle(2810, heigth - 360, 405, 70));
		blocks.add(block4Top = new Rectangle(2800, heigth - 370, 425, 10));
		blocks.add(block4Right = new Rectangle(3215, heigth - 360, 10, 70));
		blocks.add(block4Left = new Rectangle(2800, heigth - 360, 10, 70));
		blocks.add(block4Bot = new Rectangle(2800, heigth - 290, 425, 20));
		blocks.add(block5 = new Rectangle(34560, heigth - 1125, 580, 500));
		blocks.add(block7Left = new Rectangle(4275, heigth - 280, 290, 70));
		blocks.add(block7Top = new Rectangle(4275, heigth - 280, 290, 70));
		blocks.add(block7 = new Rectangle(4275, heigth - 280, 290, 70));
		blocks.add(block6Right = new Rectangle(4115, heigth - 440, 10, 500));
		blocks.add(block6Top = new Rectangle(3525, heigth - 450, 600, 10));
		blocks.add(block6Left = new Rectangle(3525, heigth - 440, 10, 500));
		blocks.add(block6 = new Rectangle(3535, heigth - 440, 580, 500));
		blocks.add(block5Bot = new Rectangle(3450, heigth - 625, 600, 10));
		blocks.add(block5Right = new Rectangle(4040, heigth - 1125, 10, 500));
		blocks.add(block5Left = new Rectangle(3450, heigth - 1125, 10, 500));
		
		block7Bot = new Rectangle(4275, heigth - 280, 290, 70);
		block7Rigth = new Rectangle(4275, heigth - 280, 290, 70);
		block8 = new Rectangle(4800, heigth - 1175, 140, 790);
		block9 = new Rectangle(4800, heigth - 200, 140, 150);
		block8Left = new Rectangle(4790, heigth - 1175, 10, 790);
		block8Bot = new Rectangle(4790, heigth - 385, 160, 10);
		block8Rigth = new Rectangle(4940, heigth - 1175, 10, 790);
		block9 = new Rectangle(4800, heigth - 200, 140, 150);
		block9Top = new Rectangle(4790, heigth - 210, 10, 150);
		block9Left = new Rectangle(4790, heigth - 200, 10, 170);
		block9Rigth = new Rectangle(4940, heigth - 200, 10, 170);
		block9 = new Rectangle(4800, heigth - 200, 140, 150);
		block7Bot = new Rectangle(4275, heigth - 200, 300, 10);
		block8 = new Rectangle(4700, heigth - 1110, 140, 490);
		block8Left = new Rectangle(4690, heigth - 1110, 10, 490);
		block8Bot = new Rectangle(4690, heigth - 620, 160, 10);
		block8Rigth = new Rectangle(4840, heigth - 1110, 10, 490);
		block9 = new Rectangle(4700, heigth - 370, 140, 370);
		block9Top = new Rectangle(4690, heigth - 380, 160, 10);
		block9Left = new Rectangle(4690, heigth - 370, 10, 370);
		block9Rigth = new Rectangle(4840, heigth - 370, 10, 370);
		
		block10 = new Rectangle(5150, heigth - 325, 270, 65);
		block11 = new Rectangle(5700, heigth - 375, 135, 65);
		block12 = new Rectangle(6050, heigth - 405, 200, 65);
		block13 = new Rectangle(6450, heigth - 300, 465, 750);

		Lazer1 = new Rectangle(4690, heigth - 390, 160, 10);
		grube1 = new Rectangle(1400, heigth - 40, 250, 300);
		grube2 = new Rectangle(3225, heigth - 40, 300, 300);
		spike1 = new Rectangle(1990, heigth - 460, 60, 60);
		grube1 = new Rectangle(1400, heigth - 40, 250, 300);
		grube2 = new Rectangle(3225, heigth - 40, 300, 300);
		spike1 = new Rectangle(1990, heigth - 460, 60, 60);
		boden1 = new Rectangle(0, heigth - 80, 1400, 50);
		boden2 = new Rectangle(1650, heigth - 80, 1600, 50);
		boden3 = new Rectangle(3825, heigth - 80, 7000, 50);
	}
}
