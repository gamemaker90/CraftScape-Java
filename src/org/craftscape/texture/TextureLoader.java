package org.craftscape.texture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL12;

/**
 * 
 * TextureLoader is the class responsible for loading textures into the game. It starts by loading
 * a single PNG file into memory, then it stores the pixel data into a buffer, then it converts the
 * PNG image to a format that OpenGL can read and understand. Once it's read, it binds the texture
 * to a model, in this case a SimpleModel2D, and renders it through the model.  
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

public class TextureLoader {
	private static final int BYTES_PER_PIXEL = 4;
	private static boolean interpolate = false;
	
	/**
	 * 
	 * Gets a resource (PNG) from a file.
	 * 
	 * @param inputStream The filename of the image to load.
	 * @return A new instance of the Texture class.
	 * @throws IOException Throws an IOException when a file cannot be found at the location.
	 */
	public static Texture getResource(InputStream inputStream){
		BufferedImage image = null;
		try {
			image = ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int[] pixels = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
		ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * BYTES_PER_PIXEL);
		
		int i, j;
		for (j = 0; j < image.getHeight(); j++) {
			for (i = 0; i < image.getWidth(); i++) {
				int pixel = pixels[i + image.getWidth() * j];
				buffer.put((byte) ((pixel >> 16) & 0xFF));
				buffer.put((byte) ((pixel >> 8) & 0xFF));
				buffer.put((byte) (pixel & 0xFF));
				buffer.put((byte) ((pixel >> 24) & 0xFF));
				
			}
		}
		
		buffer.flip();
		
		int textureID = glGenTextures();
		Texture texture = new Texture(GL_TEXTURE_2D, textureID);
		texture.setWidth(image.getWidth());
		texture.setHeight(image.getHeight());
		texture.setTextureWidth(image.getWidth());
		texture.setTextureHeight(image.getHeight());
		texture.bind();
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ONE_MINUS_SRC_ALPHA);
		glEnd();
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
		
		if (interpolate) {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		} else {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		}
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, texture.getWidth(), texture.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		//GLU.gluBuild2DMipmaps(GL_TEXTURE, GL_RGBA8, texture.getWidth(), texture.getHeight(), GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		
		return (texture);
	}
	
	public static Texture getResource(String fname){
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(fname));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int[] pixels = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
		ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * BYTES_PER_PIXEL);
		
		int i, j;
		for (j = 0; j < image.getHeight(); j++) {
			for (i = 0; i < image.getWidth(); i++) {
				int pixel = pixels[i + image.getWidth() * j];
				buffer.put((byte) ((pixel >> 16) & 0xFF));
				buffer.put((byte) ((pixel >> 8) & 0xFF));
				buffer.put((byte) (pixel & 0xFF));
				buffer.put((byte) ((pixel >> 24) & 0xFF));
				
			}
		}
		
		buffer.flip();
		
		int textureID = glGenTextures();
		Texture texture = new Texture(GL_TEXTURE_2D, textureID);
		texture.setWidth(image.getWidth());
		texture.setHeight(image.getHeight());
		texture.setTextureWidth(image.getWidth());
		texture.setTextureHeight(image.getHeight());
		texture.bind();
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ONE_MINUS_SRC_ALPHA);
		glEnd();
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
		
		if (interpolate) {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		} else {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		}
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, texture.getWidth(), texture.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		//GLU.gluBuild2DMipmaps(GL_TEXTURE, GL_RGBA8, texture.getWidth(), texture.getHeight(), GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		
		return (texture);
	}
	
	public static void setInterpolate(boolean interp) {
		interpolate = interp;
	}
}
