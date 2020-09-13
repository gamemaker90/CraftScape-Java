package org.craftscape.texture;

import static org.lwjgl.opengl.GL11.*;

/**
 * 
 * Texture class defines all of the properties of a texture in the engine. 
 * 
 * ================================================================================================
 * 
 * This class and engine may only be used by licensed personnel only. It is a proprietary class for 
 * use in all games made with Psionix Softworks (C) in java.
 * 
 * @author Vincent C
 * @version 1.1.2
 * 
 */

public class Texture {
	private int target;
	private int textureID;
	private int width;
	private int height;
	private int texWidth;
	private int texHeight;
	private float widthRatio;
	private float heightRatio;
	
	/**
	 * 
	 * Creates a texture and id for binding.
	 * 
	 * @param target The target to render to, usually GL_Texture_2D.
	 * @param textureID The id or index of this texture on the texture page.
	 */
	public Texture(int target, int textureID) {
		this.target = target;
		this.textureID = textureID;
	}
	
	/**
	 * 
	 * Sets the width to the loaded image's size.
	 * 
	 * @param width The width of the image.
	 */
	public void setWidth(int width) {
		this.width = width;
		setWidth();
	}
	
	/**
	 * 
	 * Sets the height to the loaded image's size.
	 * 
	 * @param height The height of the image.
	 */
	public void setHeight(int height) {
		this.height = height;
		setHeight();
	}
	
	/**
	 * 
	 * Sets the width to the loaded image's texture size.
	 * 
	 * @param texWidth The width of the texture.
	 */
	public void setTextureWidth(int texWidth) {
		this.texWidth = texWidth;
		setWidth();
	}
	
	/**
	 * 
	 * Sets the height to the loaded image's texture size.
	 * 
	 * @param texHeight The height of the texture.
	 */
	public void setTextureHeight(int texHeight) {
		this.texHeight = texHeight;
		setHeight();
	}
	
	/**
	 * Binds the target to the texture id.
	 */
	public void bind() {
		glEnable(GL_TEXTURE_2D);
		glBindTexture(target, textureID);
	}
	
	/**
	 * Unbinds the target from the texture id.
	 */
	public void unbind() {
		glBindTexture(target, 0);
	}
	
	/**
	 * 
	 * Gets the target of this texture.
	 * 
	 * @return The texture target.
	 */
	public int getTarget() {
		return (this.target);
	}
	
	/**
	 * 
	 * Gets the texture id.
	 * 
	 * @return The id of the texture binded in use.
	 */
	public int getTextureID() {
		return (this.textureID);
	}
	
	/**
	 * 
	 * Gets the width of the image.
	 * 
	 * @return The image width.
	 */
	public int getWidth() {
		return (this.width);
	}
	
	/**
	 * 
	 * Gets the height of the image.
	 * 
	 * @return The image height.
	 */
	public int getHeight() {
		return (this.height);
	}
	
	/**
	 * 
	 * Gets the width of the texture.
	 * 
	 * @return The texture width.
	 */
	public int getTextureWidth() {
		return (this.texWidth);
	}
	
	/**
	 * 
	 * Gets the height of the texture.
	 * 
	 * @return The texture height.
	 */
	public int getTextureHeight() {
		return (this.texHeight);
	}
	
	/**
	 * 
	 * Gets the ratio of the width of the texture.
	 * 
	 * @return The width ratio.
	 */
	public float getWidthRatio() {
		return (this.widthRatio);
	}
	
	/**
	 * 
	 * Gets the ratio of the height of the texture.
	 * 
	 * @return The height ratio.
	 */
	public float getHeightRatio() {
		return (this.heightRatio);
	}
	
	private void setWidth() {
		if (this.texWidth != 0) {
			this.widthRatio = this.width / this.texWidth;
		}
	}
	
	private void setHeight() {
		if (this.texHeight != 0) {
			this.heightRatio = this.height / this.texHeight;
		}
	}
}
