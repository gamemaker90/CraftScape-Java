package org.craftscape;

public class GameObject {
	protected boolean visible;
	protected boolean persistent;
	protected boolean solid;
	protected boolean active;
	
	public boolean isVisible() {
		return (this.visible);
	}
	
	public boolean isPersistent() {
		return (this.persistent);
	}
	
	public boolean isSolid() {
		return (this.solid);
	}
	
	public boolean isActive() {
		return (this.active);
	}
}
