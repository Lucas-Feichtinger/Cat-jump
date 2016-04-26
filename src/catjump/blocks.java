package catjump;

import java.awt.Rectangle;

public class blocks {

	Cat c = new Cat();
	int heigth = 768;
	int width = 1600;

	public static Rectangle BottomBox, WallLeft, block1, block1Top, block1Right, block1Left, block2, block2Left, block2Top, block2Bot, block2Right, block3, block3Top, block3Bot, block3Right, block3Left, block4, block4Top, block4Bot, block4Left, block4Right, block5, block5Right, block5Left, block5Bot, block6, block6Top, block6Right, block6Left,  block7, block7Top, block7Rigth, block7Left, block7Bot, block8, block8Bot, block8Rigth, block8Left, block9, block9Top, block9Rigtht, block9Left, block10, block10Top, block10Bot, block10Rigth, block10Left, block11, block11Top, block11Bot, block11Rigth, block11Left, block12, block12Top, block12Bot, block12Rigth, block12Left, block13, block13Top, block13Rigth, block13Left, block14, block14Bot, block14Rigth, block14Left;

	public static Rectangle spike1, grube1, grube2, boden1, boden2, boden3;

	public blocks() {
		WallLeft = new Rectangle(0, 0, 10, 1500);
		block1 = new Rectangle(1010, heigth - 240, 380, 300);
		block1Top = new Rectangle(1000, heigth - 250, 400, 10);
		block1Right = new Rectangle(1390, heigth - 240, 10, 290);
		block1Left = new Rectangle(1000, heigth - 240, 10, 300);
		block2 = new Rectangle(1660, heigth - 390, 380, 90);
		block2Left = new Rectangle(1650, heigth - 390, 10, 90);
		block2Top = new Rectangle(1650, heigth - 400, 400, 10);
		block2Right = new Rectangle(2040, heigth - 390, 10, 90);
		block2Bot = new Rectangle(1650, heigth - 300, 400, 10);
		block3 = new Rectangle(2190, heigth - 490, 280, 70);
		block3Left = new Rectangle(2180, heigth - 490, 10, 70);
		block3Top = new Rectangle(2180, heigth - 500, 300, 10);
		block3Bot = new Rectangle(2180, heigth - 420, 300, 10);
		block3Right = new Rectangle(2480, heigth - 490, 10, 70);
		block4 = new Rectangle(2810, heigth - 360, 405, 70);
		block4Top = new Rectangle(2800, heigth - 370, 425, 10);
		block4Right = new Rectangle(3215, heigth - 360, 10, 70);
		block4Left = new Rectangle(2800, heigth - 360, 10, 70);
		block4Bot = new Rectangle(2800, heigth - 290, 425, 10);
		block5 = new Rectangle(34560, heigth - 1125, 580, 500);
		block5Right = new Rectangle(4040, heigth - 1125, 10, 500);
		block5Left = new Rectangle(3450, heigth - 1125, 10, 500);
		block5Bot = new Rectangle(3450, heigth - 625, 600, 10);
		block6 = new Rectangle(3535, heigth - 440, 580, 500);
		block6Left = new Rectangle(3525, heigth - 440, 10, 500);
		block6Top = new Rectangle(3525, heigth - 450, 600, 10);
		block6Right = new Rectangle(4115, heigth - 440, 10, 500);
		block7 = new Rectangle(4275, heigth - 280, 290, 70);
		block8 = new Rectangle(4800, heigth - 1175, 140, 790);
		block9 = new Rectangle(4800, heigth - 200, 140, 150);
		grube1 = new Rectangle(1400, heigth - 40, 250, 300);
		grube2 = new Rectangle(3225, heigth - 40, 300, 300);
		spike1 = new Rectangle(1990, heigth - 460, 60, 60);
		block7 = new Rectangle (4275, heigth - 280, 290, 70);
		block7Left = new Rectangle(4265, heigth - 280, 10, 10);
		block7Top = new Rectangle(4265, heigth - 290,10,10);
		block7Rigth = new Rectangle (4545, heigth - 280,10,10);
		block7Bot = new Rectangle (4265, heigth -210,310,10);
		block8 = new Rectangle (4800, heigth - 1175, 140,790);
		block9 = new Rectangle (4800, heigth - 200,140,150);
		block10 = new Rectangle (5150, heigth - 325, 270, 65);
		block11 = new Rectangle (5700, heigth - 375, 135, 65);
		block12 = new Rectangle (6050, heigth - 405, 200, 65);
		block13 = new Rectangle (6450, heigth - 300, 465, 750);	
		grube1 = new Rectangle (1400, heigth - 40, 250, 300);
		grube2 = new Rectangle (3225, heigth - 40, 300, 300);
		spike1 = new Rectangle (1990, heigth - 460, 60, 60);
		boden1 = new Rectangle(0, heigth - 80, 1400, 50);
		boden2 = new Rectangle(1650, heigth - 80, 1600, 50);
		boden3 = new Rectangle(3825, heigth - 80, 7000, 50);
	}
}
