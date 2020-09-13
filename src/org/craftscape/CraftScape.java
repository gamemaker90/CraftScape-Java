package org.craftscape;

import static org.lwjgl.opengl.GL11.*;

// LWJGL 2 & 3 compatible (hopefully):
public class CraftScape {
	private final int windowSizeX;
	private final int windowSizeY;
	private final String windowTitle;
	
	public CraftScape(final int windowSizeX, final int windowSizeY, final String windowTitle) {
		this.windowSizeX = windowSizeX;
		this.windowSizeY = windowSizeY;
		this.windowTitle = windowTitle;
	}
	
	public void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, windowSizeX, windowSizeY, 0, -1, 1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public void update() {
		
	}
	
	public void renderGL() {
		
	}
	
	public int getWindowSizeX() {
		return (this.windowSizeX);
	}
	
	public int getWindowSizeY() {
		return (this.windowSizeY);
	}
	
	public String getWindowTitle() {
		return (this.windowTitle);
	}
}
