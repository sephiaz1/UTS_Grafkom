package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Cylindric extends Circle{
    float radiusZ;
    int stackCount;
    int sectorCount;
    public Cylindric(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                    int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createCylinder();
        setupVAOVBO();
    }
    public void createCylinder()
    {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double i = 0; i < 360; i+=0.1)
        {
            double x = centerPoint.get(0) + radiusX * (float)Math.cos(Math.toRadians(i));
            double z = centerPoint.get(2) + radiusZ * (float)Math.sin(Math.toRadians(i));

            temp.add(new Vector3f((float)x, 0.0f, (float)z));
            temp.add(new Vector3f((float)x, -radiusY, (float)z));
        }

        vertices = temp;
    }
}
