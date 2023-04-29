
package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class AipomCylindric extends Circle{

    float radiusZ;
    int stackCount;
    int sectorCount;

    public AipomCylindric(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                          int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createCylindric();
        setupVAOVBO();
    }

    public void createCylindric() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double v = -0.5; v <= -0.3; v += 0.01) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = 0.5f * (float) (Math.cos(u));
                float z = 0.5f * (float) (Math.sin(u));
                float y = (float) v;
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices = temp;
    }
}
