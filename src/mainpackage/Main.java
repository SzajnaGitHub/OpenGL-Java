package mainpackage;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entitiespackage.CameraManager;
import entitiespackage.LightManager;
import entitiespackage.SingleEntityClass;
import modelspackage.ModelTexture;
import modelspackage.RawModel;
import modelspackage.TexturedModel;
import shaderspackage.StaticShaderManager;

public class Main {

	public static void main(String[] args) {
		DisplayManager.createDisplay();
		LoaderClass loader = new LoaderClass();
		StaticShaderManager shader = new StaticShaderManager();
		RendererClass renderer = new RendererClass(shader);
		RawModel model = OBJLoaderClass.loadOBJModel("swordInTheMountain", loader);
		TexturedModel textureModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("tex2")));
		SingleEntityClass entity = new SingleEntityClass(textureModel, new Vector3f(0, -1f, -50), 0, 0, 0, 1);
		CameraManager camera = new CameraManager();

		while (!Display.isCloseRequested()) {
			entity.increseRotation(0, 0.2f, 0);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadLight(new LightManager(new Vector3f(10, 5, 10f), new Vector3f(1, 1, 1)));
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.disposeList();
		DisplayManager.closeDisplay();
	}
}
