package Engine;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

public class MouseInput {

    private Vector2f currentPos;
    private Vector2f displVec;
    private Vector2f scroll;
    private boolean inWindow;
    private boolean leftButtonPressed;
    private Vector2f previousPos;
    private boolean rightButtonPressed;

    public MouseInput(long windowHandle) {
        previousPos = new Vector2f(-1, -1);
        currentPos = new Vector2f();
        scroll = new Vector2f();
        displVec = new Vector2f();
        leftButtonPressed = false;
        rightButtonPressed = false;
        inWindow = false;
        glfwSetCursorPosCallback(windowHandle, (handle, xpos, ypos) -> {
            currentPos.x = (float) xpos;
            currentPos.y = (float) ypos;
        });
        glfwSetCursorEnterCallback(windowHandle, (handle, entered) -> inWindow = entered);
        glfwSetScrollCallback(windowHandle, (handle, xoffset, yoffset)->{
            scroll.x = (float)xoffset;
            scroll.y = (float)yoffset;
        });
        glfwSetMouseButtonCallback(windowHandle, (handle, button, action, mode) -> {
            leftButtonPressed = button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS;
            rightButtonPressed = button == GLFW_MOUSE_BUTTON_2 && action == GLFW_PRESS;
        });
    }

    public Vector2f getCurrentPos() {
        return currentPos;
    }

    public Vector2f getScroll() {
        return scroll;
    }

    public Vector2f getDisplVec() {
        return displVec;
    }

    public void input() {
        displVec.x = 0;
        displVec.y = 0;
        if (previousPos.x > 0 && previousPos.y > 0 && inWindow) {
            double deltax = currentPos.x - previousPos.x;
            double deltay = currentPos.y - previousPos.y;
            boolean rotateX = deltax != 0;
            boolean rotateY = deltay != 0;
            if (rotateX) {
                displVec.y = (float) deltax;
            }
            if (rotateY) {
                displVec.x = (float) deltay;
            }
        }
        previousPos.x = currentPos.x;
        previousPos.y = currentPos.y;
    }

    public boolean isLeftButtonPressed() {

        return leftButtonPressed;
    }

    public boolean isRightButtonPressed() {
        return rightButtonPressed;
    }

    public static class SphereDepan extends Circle{
        float radiusZ;
        int stackCount;
        int sectorCount;
        public SphereDepan(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                           int sectorCount, int stackCount) {
            super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
            this.radiusZ = radiusZ;
            this.stackCount = stackCount;
            this.sectorCount = sectorCount;
            createSphere();
            setupVAOVBO();
        }
        public void createSphere(){
            float pi = (float)Math.PI;

            float sectorStep = 2 * (float)Math.PI / sectorCount;
            float stackStep = (float)Math.PI / stackCount;
            float sectorAngle, StackAngle, x, y, z;

            for (int i = 0; i <= stackCount; ++i)
            {
                StackAngle = pi / 2 - i * stackStep;
                x = radiusX * (float)Math.cos(StackAngle);
                y = radiusY * (float)Math.cos(StackAngle);
                z = radiusZ * (float)Math.sin(StackAngle);

                for (int j = 0; j <= sectorCount; ++j)
                {
                    sectorAngle = j * sectorStep;
                    Vector3f temp_vector = new Vector3f();
                    temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
                    temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
                    temp_vector.z = centerPoint.get(2) + z;
                    vertices.add(temp_vector);
                }
            }
        }
    }
}
