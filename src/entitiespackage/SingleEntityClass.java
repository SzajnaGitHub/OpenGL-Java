package entitiespackage;

import org.lwjgl.util.vector.Vector3f;

import modelspackage.TexturedModel;

public class SingleEntityClass {
	private TexturedModel model;
	private Vector3f position;
	private float rotX, rotY, rotZ;
	private float scale;

	public SingleEntityClass(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super();
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}

	public void increseRotation(float dx, float dy, float dz) {
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}

	public TexturedModel getModel() { return model; }
	public Vector3f getPosition() { return position; }
	public float getRotX() { return rotX; }
	public float getRotY() { return rotY; }
	public float getRotZ() { return rotZ; }
	public float getScale() { return scale; }
}