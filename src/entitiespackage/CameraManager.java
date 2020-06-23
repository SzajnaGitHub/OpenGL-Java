package entitiespackage;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class CameraManager {
	private Vector3f position = new Vector3f(0,0,0);
	private float rotation;
	private float yaw;
	
	public CameraManager() {}
	
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) { position.y+=0.2f; } // MOVE UP
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) { position.x+=0.2f; } // MOVE RIGHT
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) { position.x-=0.2f; } // MOVE LEFT
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) { position.y-=0.2f; } // MOVE DOWN
		if(Keyboard.isKeyDown(Keyboard.KEY_X)) { position.z-=0.2f; } // ZOOM IN
		if(Keyboard.isKeyDown(Keyboard.KEY_C)) { position.z+=0.2f; } // ZOOM OUT
	}

	public Vector3f getPosition() {	return position; }
	public float getRotation() { return rotation; }
	public float getYaw() { return yaw; }
}
