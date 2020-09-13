package org.craftscape.solid;

import static org.lwjgl.opengl.GL11.*;
import org.craftscape.GameObject;
import org.craftscape.sprite.Sprite;
import org.craftscape.texture.Texture;
import org.craftscape.texture.TextureLoader;

public class Solid extends GameObject {
	private final int id;
	private final String name;
	private float x;
	private float y;
	private Sprite sprite;
	
	private Texture texture;
	
	public Solid(final int id, final String name) {
		this.id = id;
		this.name = name;
	}
	
	public void create() {
		this.texture = TextureLoader.getResource("assets/images/" + name + ".png");
		this.texture.bind();
	}
	
	public void setPos(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public void updatePos(final int x, final int y) {
		this.x += x;
		this.y += y;
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
	
	public int getID() {
		return (this.id);
	}
	
	public String getName() {
		return (this.name);
	}
	
	public float getX() {
		return (this.x);
	}
	
	public float getY() {
		return (this.y);
	}
	
	public Sprite getSprite() {
		return (this.sprite);
	}
}
