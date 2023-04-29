package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Curve extends Object{
    private List<float[]> PointControl;
    public Curve(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<float[]> PointControl) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint= Arrays.asList(PointControl.get(0)[0], PointControl.get(0)[1], PointControl.get(0)[2]);
        this.PointControl = PointControl;
        makeCurva();
        setupVAOVBO();
    }

    @Override
    public void draw(Camera camera, Projection projection) {
        super.draw(camera, projection);
    }

    int factorial(int angka){
        int hasil = 1;
        for(int i = 1; i <= angka; i++){
            hasil = i * hasil;
        }
        return hasil;
    }

    int kombinasi(int n, int r){
        return factorial(n)/(factorial(r) * factorial(n-r));
    }

    int[] pascal(List<float[]> temp){
        int[] hasil_pascal = new int[temp.size()];

        for (int i =0; i < temp.size(); i++){
            hasil_pascal[i] = kombinasi(temp.size()-1, i);
        }

        return hasil_pascal;
    }

    ArrayList<float[]> bezier(){

        ArrayList<float[]> bezier_point = new ArrayList<>();
        int[] pascal = pascal(this.PointControl);

        for (float t = 0f; t <= 1; t += 0.01f){

            float x = 0;
            int temp = this.PointControl.size()-1;
            for (int a = 0; a < this.PointControl.size(); a++){
                x += pascal[a]*Math.pow((1-t),temp) * Math.pow(t,a) * this.PointControl.get(a)[0];
                temp--;
            }

            float y = 0;
            temp = this.PointControl.size()-1;
            for (int a = 0; a < this.PointControl.size(); a++){
                y += pascal[a]*Math.pow((1-t),temp) * Math.pow(t,a) * this.PointControl.get(a)[1];
                temp--;
            }

            float z = 0;
            temp = this.PointControl.size()-1;
            for (int a = 0; a < this.PointControl.size(); a++){
                z += pascal[a]*Math.pow((1-t),temp) * Math.pow(t, a) * this.PointControl.get(a)[1];
                temp--;
            }

            float[] point = {x, y, z};
            bezier_point.add(point);
        }
        return bezier_point;
    }

    public void makeCurva(){
        if (this.PointControl.size() == 0){
            return;
        }
        ArrayList<float[]> bezier_point = bezier();
        for (float[] i: bezier_point) {
            vertices.add(new Vector3f(i[0],i[1],0));
        }
    }
}