package catjump;

import java.awt.Rectangle;

public class blocks {
	
	Cat c = new Cat();
	int heigth = 768;
	public static Rectangle BottomBox, WallLeft, block1, block1Top, block1Right, block2, block2Top, block2Bot, block2Right, block3, block3Top, block3Bot, block3Right, block4, block4Top, block4Bot, block4Right, block5, block5Right, block5Bot, block6, block6Top, block6Right, block7, block8, block9;
	
	public blocks() {
		WallLeft = new Rectangle(0, 0, 10, 1500);
		BottomBox = new Rectangle(0, heigth - 80, 10000, 50);
		block1 = new Rectangle(1000, heigth - 240, 390, 300);
		block1Top = new Rectangle(1000, heigth - 250, 400, 10);
		block1Right = new Rectangle(1390, heigth - 240, 10, 290);
		block2 = new Rectangle(1650, heigth - 390, 390, 90);
		block2Top = new Rectangle(1650, heigth - 400, 400, 10);
		block2Right = new Rectangle(2040, heigth - 390, 10, 90);
		block2Bot = new Rectangle (1650, heigth -300, 400, 10);
		block3 = new Rectangle(2200, heigth - 490, 290, 70);
		block3Top  = new Rectangle(2200, heigth - 500, 300, 10);
		block3Bot = new Rectangle(2200,heigth - 420, 300, 10);
		block3Right = new Rectangle(2490, heigth - 490, 10, 70);
		block4 = new Rectangle(2800, heigth - 360, 415, 70);
		block4Top = new Rectangle(2800, heigth - 370, 425, 10);
		block4Right = new Rectangle(3215, heigth - 360, 10, 70);
		block4Bot = new Rectangle(2800, heigth -290, 425, 10);
		block5 = new Rectangle(3450, heigth - 1125, 590, 500);
		block5Right = new Rectangle(4040, heigth - 1125, 10, 500);
		block5Bot =  new Rectangle(3450, heigth - 625, 600, 10);
		block6 = new Rectangle(3525, heigth - 440, 590, 500);
		block6Top = new Rectangle(3525, heigth - 450, 600, 10);
		block6Right = new Rectangle(4115, heigth - 440, 10, 500);
		block7 = new Rectangle (4275, heigth - 280, 290, 70);
		block8 = new Rectangle (4800, heigth - 1175, 140,790);
		block9 = new Rectangle (4800, heigth - 200,140,150);
	}
}
