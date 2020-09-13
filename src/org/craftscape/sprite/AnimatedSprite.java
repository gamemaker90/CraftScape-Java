package org.craftscape.sprite;

import org.craftscape.texture.Texture;
import org.craftscape.texture.TextureLoader;

public class AnimatedSprite extends Sprite {
	protected int frames;
	protected float animSpeed;
	protected Texture[] texture;
	private Texture currentTexture;
	
	public AnimatedSprite(int id, String name, int frames) {
		super(id, name);
		this.frames = frames;
	}
	
	public void create() {
		for (int i = 0; i < this.frames; i++) {
			this.texture[i] = TextureLoader.getResource("assets/images/" + name + "_" + i + ".png");
		}
		this.currentTexture = this.texture[0];
		this.currentTexture.bind();
	}
	
	public void update() {
		
	}
	
	public void setAnimationSpeed(float animSpeed) {
		this.animSpeed = animSpeed;
	}
	
	public void setCurrentFrame(int frame) {
		this.currentTexture = this.texture[frame];
		this.currentTexture.bind();
	}
}
