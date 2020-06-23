package shaderspackage;

import org.lwjgl.util.vector.Matrix4f;

import entitiespackage.CameraManager;
import entitiespackage.LightManager;
import utilspackage.MathUtils;

public class StaticShaderManager extends ShaderManager {

	private static final String VERTEX_FILE = "src/shaderspackage/vertexShader.txt";
	private static final String FRAGMMENT_FILE = "src/shaderspackage/fragmentShader.txt";

	private int location_transormationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	private int location_lightPosition;
	private int location_lightColor;

	public StaticShaderManager() {
		super(VERTEX_FILE, FRAGMMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
		super.bindAttribute(2, "normal");
	}

	@Override
	protected void getAllUniformLocations() {
		location_transormationMatrix = super.getUnitformLocation("transormationMatrix");
		location_projectionMatrix = super.getUnitformLocation("projectionMatrix");
		location_viewMatrix = super.getUnitformLocation("viewMatrix");
		location_lightPosition = super.getUnitformLocation("lightPosition");
		location_lightColor = super.getUnitformLocation("lightColor");
	}

	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(location_transormationMatrix, matrix);
	}

	public void loadLight(LightManager light) {
		super.loadVector(location_lightPosition, light.getPostion());
		super.loadVector(location_lightColor, light.getColor());
	}

	public void loadProjectionMatrix(Matrix4f projection) {
		super.loadMatrix(location_projectionMatrix, projection);
	}

	public void loadViewMatrix(CameraManager camera) {
		Matrix4f viewMatrix = MathUtils.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
}
