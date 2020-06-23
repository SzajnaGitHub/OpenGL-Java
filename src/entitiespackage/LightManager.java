package entitiespackage;

import org.lwjgl.util.vector.Vector3f;

public class LightManager {
	private Vector3f postion;
	private Vector3f color;
	
	public LightManager(Vector3f postion, Vector3f color) {
		super();
		this.postion = postion;
		this.color = color;
	}

	public Vector3f getPostion() { return postion; }
	public Vector3f getColor() { return color; }	
}
