package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class ElipticParaboloid extends Circle{

    float radiusZ;
    int stackCount;
    int sectorCount;
    public ElipticParaboloid(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
//        createBox();
        createElipticParaboloid();
        setupVAOVBO();
    }
    public void createElipticParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();
        //Eliptic paraboloid
        for(double v = -7 ; v<= 0; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)((v) * Math.cos(u));
                float y = 0.5f * (float)((v) * Math.sin(u));
                float z = 0.5f * (float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
}
