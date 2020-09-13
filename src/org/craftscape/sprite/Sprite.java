package org.craftscape.sprite;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.craftscape.texture.Texture;
import org.craftscape.texture.TextureLoader;

public class Sprite {
	private final int id;
	private Texture texture;
	protected String name;
	protected float x;
	protected float y;
	
	public Sprite(final int id, final String name) {
		this.id = id;
		this.name = name;
	}
	
	public void create() {
		this.texture = TextureLoader.getResource("assets/images/" + name + ".png");
		this.texture.bind();
	}
	
	public void setPos(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void render() {
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex3f(x, y, 0);
		
		glTexCoord2f(0, 1);
		glVertex3f(x, y + 32, 0);
		
		glTexCoord2f(1, 1);
		glVertex3f(x + 32, y + 32, 0);
		
		glTexCoord2f(1, 0);
		glVertex3f(x + 32, y, 0);
		glEnd();
	}
	
	public int getID() {
		return (this.id);
	}
	
	public String getPath() {
		return (this.name);
	}
}
