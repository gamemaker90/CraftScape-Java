package org.craftscape.entity;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex3f;

import java.util.Random;
import org.craftscape.GameObject;
import org.craftscape.sprite.Sprite;
import org.craftscape.texture.Texture;
import org.craftscape.texture.TextureLoader;

public class Entity extends GameObject {
	private final int id;
	private final String name;
	protected float x;
	protected float y;
	protected float xspeed;
	protected float yspeed;
	protected Sprite sprite;
	
	private Texture texture;
	
	public Entity(final int id, final String name) {
		this.id = id;
		this.name = name;
		this.xspeed = 0;
		this.yspeed = 0;
		this.solid = false;
	}
	
	public void create() {
		//this.sprite = new Sprite(id, name);
		this.texture = TextureLoader.getResource("assets/images/" + name + ".png");
		this.texture.bind();
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
	
	public void setSpawnPoint() {
		Random r = new Random();
		this.x = r.nextInt();
		this.y = r.nextInt();
	}
	
	public void setSpawnPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getID() {
		return (this.id);
	}
	
	public float getX() {
		return (this.x);
	}
	
	public float getY() {
		return (this.getY());
	}
	
	public float getXspeed() {
		return (this.xspeed);
	}
	
	public float getYspeed() {
		return (this.yspeed);
	}
	
	public boolean getActive() {
		return (this.active);
	}
}
