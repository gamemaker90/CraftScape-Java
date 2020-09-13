package org.craftscape.item;

import static org.lwjgl.opengl.GL11.*;
import org.craftscape.GameObject;
import org.craftscape.sprite.Sprite;
import org.craftscape.texture.Texture;
import org.craftscape.texture.TextureLoader;

public class Item extends GameObject {
	private final int id;
	private final String name;
	protected float x;
	protected float y;
	protected float xspeed;
	protected float yspeed;
	protected Sprite sprite;
	
	protected Texture texture;
	
	public Item(final int id, final String name) {
		this.id = id;
		this.name = name;
		
	}
	
	public void create() {
		this.texture = TextureLoader.getResource("assets/images/" + name + ".png");
		this.texture.bind();
		
		System.out.println(texture.getWidth());
	}
	
	public void update() {
		
	}
	
	public void render() {
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex3f(x, y, 0);
		
		glTexCoord2f(0, 1);
		glVertex3f(x, y + texture.getHeight(), 0);
		
		glTexCoord2f(1, 1);
		glVertex3f(x + texture.getWidth(), y + texture.getHeight(), 0);
		
		glTexCoord2f(1, 0);
		glVertex3f(x + texture.getWidth(), y, 0);
		glEnd();
	}
	
	public void destroy() {
		
	}
	
	public int getID() {
		return (this.id);
	}
	
	public String getName() {
		return (this.name);
	}
}
