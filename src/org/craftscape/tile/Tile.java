package org.craftscape.tile;

public class Tile {
	private final int id;
	protected float x;
	protected float y;
	
	public Tile(final int id) {
		this.id = id;
	}
	
	public int getID() {
		return (this.id);
	}
}
