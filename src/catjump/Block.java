package catjump;

import java.awt.Image;
import java.awt.Rectangle;

public class Block extends Rectangle {
	private Rectangle bounds;
	private Image texture;

	/**
	 * @param bounds
	 * @param texture
	 */
	public Block(int x, int y, int width, int height, Image texture) {
		super(x, y, width, height);
		this.texture = texture;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public Image getTexture() {
		return texture;
	}

}
