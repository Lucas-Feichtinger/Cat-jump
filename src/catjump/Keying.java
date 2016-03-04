package catjump;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keying extends JPanel{
	
	public Rectangle character;
	public int charW = 24;
	public int charH = 36;
	
	public boolean right = false;
	public boolean left = false;
	
	public Keying(Display f, Images i){
		character = new Rectangle(180, 180, charW, charH);
		
		f.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_D){
					right = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					left = true;
				}
			}
			
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_D){
					right = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					left = false;
				}
			}
		});
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.black);
		g.setColor(Color.WHITE);
		g.fillRect(character.x, character.y, character.width, character.height);
		
		if(right == true){
			character.x += 1;
		}
		if(left == true){
			character.x -= 1;
		}
		repaint();
	}
}
