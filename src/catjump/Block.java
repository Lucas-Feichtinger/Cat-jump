package catjump;

import java.awt.Image;
import java.awt.Rectangle;

public class Block {
	private Rectangle bounds;
	private Image texture;

	/**
	 * @param bounds
	 * @param texture
	 */
	public Block(Rectangle bounds, Image texture) {
		super();
		this.bounds = bounds;
		this.texture = texture;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public Image getTexture() {
		return texture;
	}

}
