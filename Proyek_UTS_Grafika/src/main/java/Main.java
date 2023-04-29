import Engine.Object;
import Engine.*;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.*;

public class Main {
    static float posY = 0f;
    private Window window =
            new Window
                    (1080, 960, "Proyek GrafKom");
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private MouseInput mouseInput;
    int countDegree = 0;
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    Camera camera = new Camera();
    static float tanganSnorlax = 0f;
    static boolean turnTanganSnorlax = false;

    static float mulutSnorlax = 0f;
    static float kakiSnorlax = 0f;
    static boolean turnKakiSnorlax = false;
    static float kakiAipom= 0f;
    static boolean turnKakiAipom = false;


    static boolean kepalaTurnX = true;
    static boolean kepalaTurnY = true;
    static float kepalaDegX = 0f;
    static float kepalaDegY = 0f;

    static boolean badanTurnX = true;
    static float badanTurnY = 0f;
    static float badanDeg = 0f;

    static boolean mataTurnX = true;
    static boolean mataTurnY = true;
    static float mataDegX = 0f;
    static float yMata=0f;
    static float mataDegY = 0f;
    static float tanganSnorlaxBuka = 0f;
    static boolean turnTanganSnorlaxBuka = false;


    static boolean kakiTurn = true;
    static float kakiDeg = 0f;
    static float x=0f;
    static float y=0f;
    static float z=0f;

    static boolean kakiB=true;
    static float kaki=0f;

    static boolean tanganTurnX = true;
    static boolean tanganTurnY = true;
    static float tanganDegX = 0f;
    static float tanganDegY = 0f;

    // Jason - Natu
    static boolean turnLeg = true;
    static boolean turnWing = true;
    static float posYNatu = 0f;
    static float posYAipom = 0f;

    static float legDegree = 0f;
    static float wingDegree = 0f;
    static float s_x = 0f;
    static float s_y = 0f;
    static float s_z = 0f;

    public static void setKakiSnorlax(float kakiSnorlax) {
        Main.kakiSnorlax += kakiSnorlax;
    }
    public static void setKakiAipom(float kakiAipom) {
        Main.kakiAipom += kakiAipom;
    }

    public static void setyBadan(float badanTurnY) {
        Main.badanTurnY += badanTurnY;
    }

    public static void setKepalaTurnX(boolean kepalaTurnX) {
        Main.kepalaTurnX = kepalaTurnX;
    }

    public static void setKepalaDegX(float kepalaDegX) {
        Main.kepalaDegX += kepalaDegX;
    }

    public static void setKepalaTurnY(boolean kepalaTurnY) {
        Main.kepalaTurnY = kepalaTurnY;
    }

    public static void setKepalaDegY(float kepalaDegY) {
        Main.kepalaDegY += kepalaDegY;
    }

    public static void setMataTurnX(boolean mataTurnX) {
        Main.mataTurnX = mataTurnX;
    }

    public static void setMataDegX(float MataDegX) {
        Main.mataDegX += MataDegX;
    }

    public static void setMataTurnY(boolean MataTurnY) {
        Main.mataTurnY = MataTurnY;
    }

    public static void setMataDegY(float MataDegY) {
        Main.mataDegY += MataDegY;
    }

    public static void setBadanTurn(boolean BadanTurn) {
        Main.badanTurnX = BadanTurn;
    }

    public static void setBadanDeg(float BadanDeg) {
        Main.badanDeg += BadanDeg;
    }

    public static void setKakiTurn(boolean KakiTurn) {
        Main.kakiTurn = KakiTurn;
    }

    public static void setKakiDeg(float KakiDeg) {
        Main.kakiDeg += KakiDeg;
    }

    public static void setTanganTurnX(boolean TanganTurnX) {
        Main.tanganTurnX = TanganTurnX;
    }

    public static void setTanganDegX(float TanganDegX) {
        Main.tanganDegX += TanganDegX;
    }

    public static void setTanganTurnY(boolean TanganTurnY) {
        Main.tanganTurnY = TanganTurnY;
    }

    public static void setTanganDegY(float TanganDegY) {
        Main.tanganDegY += TanganDegY;
    }

    public void init() {
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();

        // posisi camera
        camera.setPosition(0.5f, 1f, 2f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));


        // JOSEPH - SNORLAX --> OBJECT 0+1
        {
            // Kepala
            objects.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.46f, 0.63f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    10000
            ));
            objects.get(0).scaleObject(0.325f, 0.25f, 0.25f);
            objects.get(0).translateObject(0.0f, 0.25f, 0.0f);

            // muncung 1
            objects.get(0).getChildObject().add(new ParaboloidModified(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.46f, 0.63f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(0).getChildObject().get(0).scaleObject(0.0225f, 0.023f, 0.023f);
            objects.get(0).getChildObject().get(0).translateObject(0.07f, 0.0f, -0.45f);
            objects.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(30f), 0f, 0f, 1f);

            // muncung 2
            objects.get(0).getChildObject().add(new ParaboloidModified(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.46f, 0.63f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    10000
            ));
            objects.get(0).getChildObject().get(1).scaleObject(0.0225f, 0.023f, 0.023f);
            objects.get(0).getChildObject().get(1).translateObject(-0.07f, 0.0f, -0.45f);
            objects.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(-30f), 0f, 0f, 1f);

            // depan
            objects.get(0).getChildObject().add(new SphereDepan(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.94f, 0.9f, 0.49f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    10000
            ));
            objects.get(0).getChildObject().get(2).scaleObject(0.22f, 0.2f, 0.1f);
            objects.get(0).getChildObject().get(2).translateObject(0.0f, 0.25f, 0.1f);

            // garis di kepala
            objects.get(0).getChildObject().add(new ParaboloidModified(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.46f, 0.63f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(0).getChildObject().get(3).scaleObject(0.0225f, 0.01f, 0.023f);
            objects.get(0).getChildObject().get(3).translateObject(0.0f, -0.35f, -0.009f);
            objects.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(210f), 1f, 0f, 0f);

            // mata kanan
            objects.get(0).getChildObject().add(new Curve(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0f, 0f, 0f, 1.0f),
                    Arrays.asList(
                            new float[]{0, 0, 0},
                            new float[]{0.06f, -0.02f, 0}
                    )
            ));
            objects.get(0).getChildObject().get(4).translateObject(-0.13f, -0.255f, 0.15f);
            objects.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(189f), 0f, 0f, 1f);

            // mata kiri
            objects.get(0).getChildObject().add(new Curve(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0f, 0f, 0f, 1.0f),
                    Arrays.asList(
                            new float[]{0, 0, 0},
                            new float[]{0.06f, -0.02f, 0}
                    )
            ));
            objects.get(0).getChildObject().get(5).translateObject(-0.11f, -0.26f, 0.15f);
            objects.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(210f), 0f, 0f, 1f);

            // lengkungan mulut
            objects.get(0).getChildObject().add(new Curve(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0f, 0f, 0f, 1.0f),
                    Arrays.asList(
                            new float[]{0, 0.005f, -0.1f},
                            new float[]{0.06f, -0.02f, 0},
                            new float[]{.1f, 0.007f, 0}
                    )
            ));
            objects.get(0).getChildObject().get(6).translateObject(-0.05f, 0.205f, 0.15f);
            objects.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(0f), 0f, 0f, 1f);


            // perut belakang
            objects.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.46f, 0.63f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    10000
            ));
            objects.get(1).scaleObject(0.5f, 0.5f, 0.5f);
            objects.get(1).translateObject(0.0f, -0.08f, 0.0f);

            // perut depan
            objects.get(1).getChildObject().add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.94f, 0.9f, 0.49f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    10000
            ));
            objects.get(1).getChildObject().get(0).scaleObject(0.4f, 0.4f, 0.4f);
            objects.get(1).getChildObject().get(0).translateObject(0.0f, -0.05f, 0.10f);

            // leher
            objects.get(1).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.94f, 0.9f, 0.49f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    10000
            ));
            objects.get(1).getChildObject().get(1).scaleObject(0.0f, 0.0f, 0.0f);
            objects.get(1).getChildObject().get(1).translateObject(0.0f, 0.05f, 0.10f);


            // kaki kanan
            objects.get(1).getChildObject().add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.94f, 0.9f, 0.49f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    10000
            ));
            objects.get(1).getChildObject().get(2).scaleObject(0.55f, 0.75f, 0.3f);
            objects.get(1).getChildObject().get(2).translateObject(0.09f, -0.03f, 0.32f);
            objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(30f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(10f), 0f, 1f, 0f);

            // kaki kiri
            objects.get(1).getChildObject().add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.94f, 0.9f, 0.49f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    10000
            ));
            objects.get(1).getChildObject().get(3).scaleObject(0.55f, 0.75f, 0.3f);
            objects.get(1).getChildObject().get(3).translateObject(-0.09f, -0.03f, 0.32f);
            objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(30f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(10f), 0f, -1f, 0f);

            // depan kaki baru
            objects.get(1).getChildObject().add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1f, 0.7f, 0.49f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    10000
            ));
            objects.get(1).getChildObject().get(4).scaleObject(0.3f, 0.55f, 0.15f);
            objects.get(1).getChildObject().get(4).translateObject(-0.1f, -0.02f, 0.35f);
            objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(30f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(10f), 0f, -1f, 0f);

            // depan kaki baru
            objects.get(1).getChildObject().add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1f, 0.7f, 0.49f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    10000
            ));
            objects.get(1).getChildObject().get(5).scaleObject(0.3f, 0.55f, 0.15f);
            objects.get(1).getChildObject().get(5).translateObject(0.09f, -0.02f, 0.35f);
            objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(30f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(10f), 0f, 1f, 0f);

            // tangan kiri
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.46f, 0.63f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(6).scaleObject(0.03f, 0.025f, 0.015f);
            objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
            objects.get(1).getChildObject().get(6).translateObject(-0.5f, 0.05f, 0.0f);

            // tangan kanan
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.46f, 0.63f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(7).scaleObject(0.03f, 0.025f, 0.015f);
            objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(-90f), 0f, 1f, 0f);
            objects.get(1).getChildObject().get(7).translateObject(0.5f, 0.05f, 0.0f);

            // kuku kaki tengah
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(8).scaleObject(0.005f, 0.00005f, 0.001f);
            objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(8).translateObject(0.03f, 0.025f, 0.32f);
            objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(10f), 2f, -1f, 0f);
            objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);

            // kuku kaki kanan
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(9).scaleObject(0.005f, 0.00005f, 0.001f);
            objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(9).translateObject(0.063f, 0.015f, 0.32f);
            objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(10f), 2f, -1f, 0f);
            objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);

            // kuku kaki kanan kiri
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(10).scaleObject(0.005f, 0.00005f, 0.001f);
            objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(10).translateObject(-0.005f, 0.06f, 0.315f);
            objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(10f), 2f, -1f, 0f);
            objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
            objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(10f), 1f, 0f, 0f);

            // kuku kaki kiri
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(11).scaleObject(0.005f, 0.00005f, 0.001f);
            objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(11).translateObject(-0.12f, -0.05f, 0.32f);
            objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);

            // kuku kaki kiri
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(12).scaleObject(0.005f, 0.00005f, 0.001f);
            objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(12).translateObject(-0.09f, -0.03f, 0.32f);
            objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);

            // kuku kaki kiri
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(13).scaleObject(0.005f, 0.00005f, 0.001f);
            objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(13).translateObject(-0.06f, -0.045f, 0.32f);
            objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);

            // gigi kanan
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(14).scaleObject(0.003f, 0.00003f, 0.0006f);
            objects.get(1).getChildObject().get(14).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(14).translateObject(0.08f, 0.24f, 0.105f);
            objects.get(1).getChildObject().get(14).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);
            objects.get(1).getChildObject().get(14).rotateObject((float) Math.toRadians(5f), 0f, 0f, 1f);

            // gigi kiri
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(15).scaleObject(0.003f, 0.00003f, 0.0006f);
            objects.get(1).getChildObject().get(15).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(15).translateObject(-0.0125f, 0.245f, 0.125f);
            objects.get(1).getChildObject().get(15).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);

            // kuku kiri tengah
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(16).scaleObject(0.003f, 0.00003f, 0.0006f);
            objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(16).translateObject(0.05f, 0.5f, -0.1f);
            objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);
            objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(91f), 0f, 0f, 1f);

            // kuku kiri bawah
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(17).scaleObject(0.003f, 0.00003f, 0.0006f);
            objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(17).translateObject(0.05f, 0.485f, -0.1f);
            objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);
            objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(93f), 0f, 0f, 1f);

            // kuku kiri atas
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(18).scaleObject(0.003f, 0.00003f, 0.0006f);
            objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(18).translateObject(0.045f, 0.485f, -0.1f);
            objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);
            objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(88.5f), 0f, 0f, 1f);

            // kuku kanan atas
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(19).scaleObject(0.003f, 0.00003f, 0.0006f);
            objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(19).translateObject(0.045f, 0.485f, -0.1f);
            objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);
            objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(88.5f), 0f, 0f, 1f);
            objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);

            // kuku kanan tengah
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(20).scaleObject(0.003f, 0.00003f, 0.0006f);
            objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(20).translateObject(0.05f, 0.5f, -0.1f);
            objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);
            objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(91f), 0f, 0f, 1f);
            objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);

            // kuku kanan bawah
            objects.get(1).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(1).getChildObject().get(21).scaleObject(0.003f, 0.00003f, 0.0006f);
            objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(1).getChildObject().get(21).translateObject(0.05f, 0.485f, -0.1f);
            objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(10f), 1f, -1f, 0f);
            objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(93f), 0f, 0f, 1f);
            objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);

            // mulut
            objects.get(0).getChildObject().add(new SnorlaxElipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.00125f,
                    0.00125f,
                    36,
                    10000
            ));

            objects.get(0).getChildObject().get(7).scaleObject(0.14f, 0.08f, 0.095f);
            objects.get(0).getChildObject().get(7).translateObject(0.0f, 0.23f, 0.11f);
            objects.get(0).getChildObject().get(7).rotateObjectSelf((float) Math.toRadians(15f), 1f, 0f, 0f);


            // penutup mulut
            objects.get(0).getChildObject().add(new halfSphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.94f, 0.9f, 0.49f, 0.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    10000
            ));
            objects.get(0).getChildObject().get(8).scaleObject(0.55f, 0.255f, 0.455f);
            objects.get(0).getChildObject().get(8).translateObject(0.0f, 0.238f, 0.11f);
            objects.get(0).getChildObject().get(8).rotateObjectSelf((float) Math.toRadians(-334f), 1f, 0f, 0f);

            // kayu
            objects.add(new Cylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.45f, 0.38f, 0.34f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    1000
            ));
            objects.get(2).translateObject(-0.8f, 0.245f, -0.5f);
            objects.get(2).scaleObject(0.5f, 1f, 0.3f);
            objects.get(2).rotateObject((float) Math.toRadians(90f), 0f, 0f, 1f);

            // geser joseph hilang
            for (int i = 0; i <= 2; i++) {
                objects.get(i).translateObject(0f, -0.1f, 0.0f);
            }

            setS(1f, 0.25f, 0f);
        }


        // JASON-NATU --> OBJECT 3-1
        {
            // Badan
            objects.add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 1.0f, 0.2f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(3).scaleObject(0.5f, 0.5f, 0.5f);
            objects.get(3).translateObject(0.0f, 0.0f, 0.0f);


            // Paruh --> child 0 body
            objects.get(3).getChildObject().add(new Paruh(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.8f, 1.0f, 0.2f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(3).getChildObject().get(0).scaleObject(0.038f, 0.038f, 0.03f);
            objects.get(3).getChildObject().get(0).rotateObject((float) Math.toRadians(180f), 1f, 0f, 0f);
            objects.get(3).getChildObject().get(0).translateObject(0.0f, -0.03f, 0.36f);

            // Mata Putih Kiri --> child 1 body
            objects.get(3).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(3).getChildObject().get(1).scaleObject(0.08f, 0.07f, 0.04f);
            objects.get(3).getChildObject().get(1).translateObject(-0.1f, 0.085f, 0.225f);

            // Mata Putih Kanan --> child 2 body
            objects.get(3).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(3).getChildObject().get(2).scaleObject(0.08f, 0.07f, 0.04f);
            objects.get(3).getChildObject().get(2).translateObject(0.1f, 0.085f, 0.225f);

            // curva tanduk --> child 3 body
            objects.get(3).getChildObject().add(new Curve(Arrays.asList(
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
            ),
                    new ArrayList<>(),
                    new Vector4f(1f, 1f, 1f, 1.0f),
                    Arrays.asList(
                            new float[]{0, 0, 0f},
                            new float[]{0.1f, 0.1f, 0},
                            new float[]{0.2f, 0.14f, 0},
                            new float[]{0.14f, 0.1f, 0},
                            new float[]{.15f, 0.12f, 0},
                            new float[]{0.1f, 0.1f, 0},
                            new float[]{0.14f, 0.11f, 0},
                            new float[]{.13f, 0.3f, 0},
                            new float[]{0.1f, 0.1f, 0}
                    )
            ));
//        objects.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(180f), 0f, 0f, 1f);
            objects.get(3).getChildObject().get(3).rotateObject((float) Math.toRadians(-90f), 0f, 1f, 0f);
            objects.get(3).getChildObject().get(3).rotateObject((float) Math.toRadians(40f), 1f, 0f, 0f);
            objects.get(3).getChildObject().get(3).translateObject(0.0f, 0.17f, 0.f);


//        // Dasi --> child 3 body
//        objects.get(0).getChildObject().add(new Dasi(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(3).scaleObject(0.001f,0.001f,0.001f);
//        objects.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(0f),-1f,0f,0f);
//        objects.get(0).getChildObject().get(3).translateObject(0.f,0.0f,0.5f);


            // Bola Mata Kiri
            objects.add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(4).scaleObject(0.037f, 0.037f, 0.037f);
            objects.get(4).translateObject(-0.095f, 0.08f, 0.25f);


            // Bola Mata Kanan --> child bola mata kiri
            objects.get(4).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(4).getChildObject().get(0).scaleObject(0.037f, 0.037f, 0.037f);
            objects.get(4).getChildObject().get(0).translateObject(0.095f, 0.08f, 0.25f);


            // Jambul
            objects.add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.3f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(5).scaleObject(0.1f, 0.3f, 0.01f);
            objects.get(5).rotateObject((float) Math.toRadians(45f), -1f, 0f, 0f);
            objects.get(5).translateObject(0.0f, 0.27f, -0.22f);


            // Sayap Kiri
            objects.add(new ParaboloidModified(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 0.5f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(6).scaleObject(0.01f, 0.04f, 0.03f);
            objects.get(6).rotateObject((float) Math.toRadians(45f), 0f, 1f, 0f);
            objects.get(6).translateObject(-0.34f, 0.0f, -0.1f);

            // Sayap Kanan
            objects.add(new ParaboloidModified(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 0.5f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(7).scaleObject(0.01f, 0.04f, 0.03f);
            objects.get(7).rotateObject((float) Math.toRadians(45f), 0f, -1f, 0f);
            objects.get(7).translateObject(0.34f, 0.0f, -0.1f);


            // Paha kiri
            objects.add(new NatuCylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(8).scaleObject(0.02f, 0.12f, 0.02f);
            objects.get(8).translateObject(-0.1f, -0.25f, 0.0f);

            // Kaki kiri
            objects.get(8).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(8).getChildObject().get(0).scaleObject(0.01f, 0.02f, 0.003f);
            objects.get(8).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(8).getChildObject().get(0).translateObject(-0.1f, -0.27f, 0.0f);

            // Kaki kiri
            objects.get(8).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(8).getChildObject().get(1).scaleObject(0.02f, 0.01f, 0.003f);
            objects.get(8).getChildObject().get(1).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(8).getChildObject().get(1).translateObject(-0.1f, -0.27f, 0.0f);


            // Paha kanan
            objects.add(new NatuCylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(9).scaleObject(0.02f, 0.12f, 0.02f);
            objects.get(9).translateObject(0.1f, -0.25f, 0.0f);

            // Kaki kanan
            objects.get(9).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(9).getChildObject().get(0).scaleObject(0.01f, 0.02f, 0.003f);
            objects.get(9).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(9).getChildObject().get(0).translateObject(0.1f, -0.27f, 0.0f);

            // Kaki kanan
            objects.get(9).getChildObject().add(new ElipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(9).getChildObject().get(1).scaleObject(0.02f, 0.01f, 0.003f);
            objects.get(9).getChildObject().get(1).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(9).getChildObject().get(1).translateObject(0.1f, -0.27f, 0.0f);


            // Ekor tengah
            objects.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(10).scaleObject(0.2f, 0.75f, 0.4f);
            objects.get(10).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(10).translateObject(0.f, 0f, -0.28f);

            // Ekor atas
            objects.get(10).getChildObject().add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(10).getChildObject().get(0).scaleObject(0.2f, 0.8f, 0.35f);
            objects.get(10).getChildObject().get(0).rotateObject((float) Math.toRadians(120f), 1f, 0f, 0f);
            objects.get(10).getChildObject().get(0).translateObject(0.f, 0.05f, -0.28f);

            // Ekor bawah
            objects.get(10).getChildObject().add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(10).getChildObject().get(1).scaleObject(0.2f, 0.8f, 0.35f);
            objects.get(10).getChildObject().get(1).rotateObject((float) Math.toRadians(60f), 1f, 0f, 0f);
            objects.get(10).getChildObject().get(1).translateObject(0.f, -0.05f, -0.28f);

            // titik sumbu ekor --> body child 4
            objects.get(3).getChildObject().add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 1.0f, 0.2f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    18
            ));
            objects.get(3).getChildObject().get(4).translateObject(0f, 0f, -0.25f);
            objects.get(3).getChildObject().get(4).scaleObject(0.1f, 0.1f, 0.1f);

            // geser joseph hilang
            for (int i = 0; i <= 2; i++) {
                objects.get(i).translateObject(1f, 0.35f, 0.0f);
            }

            // geser jason
//        for (int i = 3; i <= 10; i++) {
//            objects.get(i).translateObject(2f, 0.0f, 0.0f);
//        }

            // geser jason hilang
//        for (int i = 3; i <= 10; i++) {
//            objects.get(i).translateObject(1.3f, 0.2f, 1f);
//        }


        }

        // ABIEL- AIPOM --> OBJECT 11+12
        {
            // kepala ungu
            objects.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).translateObject(0f, 0.5f, 0.0f);
            objects.get(11).scaleObject(0.73f, 0.35f, 0.31f);

            // telinga ungu 1
            objects.get(11).getChildObject().add(new AipomCylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(0).translateObject(-1.3f, 0.8f, 0.4f);
            objects.get(11).getChildObject().get(0).scaleObject(0.20f, 0.35f, 0.20f);

            // telinga ungu 2
            objects.get(11).getChildObject().add(new AipomCylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(1).translateObject(1.3f, 0.8f, 0.4f);
            objects.get(11).getChildObject().get(1).scaleObject(0.20f, 0.35f, 0.20f);

            // muka kuning 1
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(2).translateObject(0f, 0.57f, 0.3f);
            objects.get(11).getChildObject().get(2).scaleObject(0.3f, 0.17f, 0.3f);

            // muka kuning 2
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(3).translateObject(-0.9f, 0.95f, 1f);
            objects.get(11).getChildObject().get(3).scaleObject(0.13f, 0.17f, 0.13f);

            // muka kuning 3
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(4).translateObject(0.9f, 0.95f, 1f);
            objects.get(11).getChildObject().get(4).scaleObject(0.13f, 0.17f, 0.13f);

            // mulut putih
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 1f, 1f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(5).translateObject(0f, 0.8f, 2f);
            objects.get(11).getChildObject().get(5).scaleObject(0.2f, 0.08f, 0.105f);

            // mata putih 1
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1f, 1f, 1f, 1f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(6).translateObject(-1.2f, 1.7f, 2.7f);
            objects.get(11).getChildObject().get(6).scaleObject(0.08f, 0.08f, 0.08f);

            // mata hitam 1
            objects.get(11).getChildObject().get(6).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0f, 0f, 0f, 0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(6).getChildObject().get(0).translateObject(-1.7f, 2.6f, 5f);
            objects.get(11).getChildObject().get(6).getChildObject().get(0).scaleObject(0.05f, 0.05f, 0.05f);

            // mata putih 2
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1f, 1f, 1f, 1f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(7).translateObject(1.2f, 1.7f, 2.7f);
            objects.get(11).getChildObject().get(7).scaleObject(0.08f, 0.08f, 0.08f);

            // mata hitam 2
            objects.get(11).getChildObject().get(7).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0f, 0f, 0f, 0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(7).getChildObject().get(0).translateObject(1.7f, 2.6f, 5f);
            objects.get(11).getChildObject().get(7).getChildObject().get(0).scaleObject(0.05f, 0.05f, 0.05f);//

            // gendang telinga 1
            objects.get(11).getChildObject().add(new AipomCylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(8).translateObject(-2.5f, 1.5f, 1f);
            objects.get(11).getChildObject().get(8).scaleObject(0.1f, 0.15f, 0.05f);

            // gendang telinga 2
            objects.get(11).getChildObject().add(new AipomCylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(9).translateObject(2.5f, 1.5f, 1f);
            objects.get(11).getChildObject().get(9).scaleObject(0.1f, 0.15f, 0.05f);

            // jambul 1
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.07f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(10).translateObject(0f, 1.65f, 0f);
            objects.get(11).getChildObject().get(10).scaleObject(0.1f, 0.2f, 0.4f);

            // jambul 2
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.07f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(11).translateObject(0.7f, 2f, 0f);
            objects.get(11).getChildObject().get(11).scaleObject(0.1f, 0.15f, 0.4f);

            // jambul 3
            objects.get(11).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.07f,
                    36,
                    18
            ));
            objects.get(11).getChildObject().get(12).translateObject(-0.7f, 2f, 0f);
            objects.get(11).getChildObject().get(12).scaleObject(0.1f, 0.15f, 0.4f);


            // bagian badan
            // badan ungu
            objects.add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).translateObject(0f, 0.3f, 0.0f);
            objects.get(12).scaleObject(0.35f, -0.5f, 0.35f);

            // perut kuning
            objects.get(12).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(0).translateObject(0f, -0.53f, 0.33f);
            objects.get(12).getChildObject().get(0).scaleObject(0.25f, 0.35f, 0.25f);


            // bagian tangan
            // tangan ungu 1
            objects.get(12).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(1).translateObject(-0.65f, 0.2f, 0.0f);
            objects.get(12).getChildObject().get(1).scaleObject(0.5f, 0.1f, 0.1f);

            // tangan ungu 2
            objects.get(12).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(2).translateObject(0.65f, 0.2f, 0.0f);
            objects.get(12).getChildObject().get(2).scaleObject(0.5f, 0.1f, 0.1f);


            // bagian kaki
            // kaki ungu 1
            objects.get(12).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(3).translateObject(-0.6f, -1f, 0.0f);
            objects.get(12).getChildObject().get(3).scaleObject(0.15f, 0.4f, 0.15f);


            // kaki ungu 2
            objects.get(12).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(4).translateObject(0.6f, -1f, 0.0f);
            objects.get(12).getChildObject().get(4).scaleObject(0.15f, 0.4f, 0.15f);

            // alas kaki 1
            objects.get(12).getChildObject().get(3).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(3).getChildObject().get(0).translateObject(-0.6f, -3.55f, 0.1f);
            objects.get(12).getChildObject().get(3).getChildObject().get(0).scaleObject(0.16f, 0.15f, 0.30f);

            // alas kaki 2
            objects.get(12).getChildObject().get(4).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(4).getChildObject().get(0).translateObject(0.6f, -3.55f, 0.1f);
            objects.get(12).getChildObject().get(4).getChildObject().get(0).scaleObject(0.16f, 0.15f, 0.30f);

            // garis pada kaki 1
            objects.get(12).getChildObject().get(3).getChildObject().get(0).getChildObject().add(new AipomCylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0f, 0.0f, 0.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(3).getChildObject().get(0).getChildObject().get(0).translateObject(-5f, -5f, 0.62f);
            objects.get(12).getChildObject().get(3).getChildObject().get(0).getChildObject().get(0).scaleObject(0.02f, 0.1f, 0.6f);

            // garis pada kaki 2
            objects.get(12).getChildObject().get(4).getChildObject().get(0).getChildObject().add(new AipomCylindric(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0f, 0.0f, 0.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(4).getChildObject().get(0).getChildObject().get(0).translateObject(5f, -5f, 0.62f);
            objects.get(12).getChildObject().get(4).getChildObject().get(0).getChildObject().get(0).scaleObject(0.02f, 0.1f, 0.6f);


            // bagian ekor
            // ekor ungu
            objects.get(12).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 0.1f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(5).translateObject(0f, -2.6f, -0.5f);
            objects.get(12).getChildObject().get(5).scaleObject(0.1f, 0.1f, 0.65f);


            // gumpalan ekor kuning
            objects.get(12).getChildObject().get(5).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(5).getChildObject().get(0).translateObject(0.1f, -1.5f, -2.8f);
            objects.get(12).getChildObject().get(5).getChildObject().get(0).scaleObject(0.2f, 0.17f, 0.23f);

            // garis ekor 1
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).translateObject(0.5f, -1f, -9.2f);
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).scaleObject(0.07f, 0.15f, 0.07f);


            // garis ekor 2
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.7f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(1).translateObject(0.5f, -2.5f, -9.2f);
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(1).scaleObject(0.07f, 0.15f, 0.07f);

            // garis ekor 3
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.07f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(2).translateObject(0.5f, -3.7f, -5f);
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(2).scaleObject(0.07f, 0.07f, 0.15f);


            // bulatan pada ekor 1
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.07f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.3f, -0.55f, -5.35f);
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.12f, 0.12f, 0.12f);

            // bulatan pada ekor 2
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.07f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.3f, -3.7f, -5.35f);
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.12f, 0.12f, 0.12f);


            // bulatan pada ekor 3
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(2).getChildObject().add(new Elipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1f, 0.3f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.3f,
                    0.5f,
                    0.07f,
                    36,
                    18
            ));
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).translateObject(0.3f, -2.2f, -6.95f);
            objects.get(12).getChildObject().get(5).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.12f, 0.12f, 0.12f);


//        // geser abiel
//        objects.get(11).translateObject(-1.2f, 0.03f, -0.03f);
//        objects.get(12).translateObject(-1.2f, 0.03f, -0.03f);
//        objects.get(11).scaleObject(0.9f, 0.9f, 0.9f);
//        objects.get(12).scaleObject(0.9f, 0.9f, 0.9f);


            // geser abiel supaya hilang
            for (int i = 11; i <= 12; i++) {
                objects.get(i).translateObject(-0.5f, 0.4f, 0.3f);
//            objects.get(i).scaleObject(0f, 0.9f, 0.9f);
            }


        }

        // Enviroment
        // tanah
        objects.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.75f, 0.31f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                5f,
                5f, 1f, 36, 10000
        ));
        objects.get(13).scaleObject(3f, 3f, 1f);
        objects.get(13).translateObject(0.07f, 0f, -0.3f);
        objects.get(13).rotateObject((float)Math.toRadians(-90f),1f, 0f, 0f);

        // bikin batu 1
        objects.add(new halfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.33f, 0.33f, 0.33f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.125f,
                0.125f, 0.125f, 36, 10000
        ));
        objects.get(14).scaleObject(2f, 2.5f, 3f);
        objects.get(14).translateObject(0.07f, -1f, -0.2f);
        objects.get(14).rotateObject((float)Math.toRadians(-90f),1f, 0f, 0f);

        // anak batu kanan
        objects.get(14).getChildObject().add(new halfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.58f, 0.58f, 0.58f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.125f,
                0.125f,0.125f, 36, 10000
        ));
        objects.get(14).getChildObject().get(0).scaleObject(1.5f, 1.5f, 1.5f);
        objects.get(14).getChildObject().get(0).translateObject(0.23f, -1f, -0.2f);
        objects.get(14).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);

        // anak batu kiri
        objects.get(14).getChildObject().add(new halfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.58f, 0.58f, 0.58f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.125f,
                0.125f,  0.125f, 36, 1000
        ));
        objects.get(14).getChildObject().get(1).scaleObject(1.5f, 1.5f, 1.5f);
        objects.get(14).getChildObject().get(1).translateObject(-0.15f, -1f, -0.2f);
        objects.get(14).getChildObject().get(1).rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);

        // pohon
        objects.add(new Elipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.6f, 0.38f, 0.22f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.3f,
                0.5f,
                0.7f,
                36,
                18
        ));
        objects.get(15).translateObject(-0.5f, -0.1f, -1.8f);
        objects.get(15).scaleObject(1f, 4f, 1f);

        // daun 1
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(16).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(16).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);

        objects.get(16).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(16).translateObject(0f, 1.3f, -1.6f);

        // daun 2
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(17).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(17).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);
        objects.get(17).rotateObjectSelf((float) Math.toRadians(90f), 0f, 1f, 0f);

        objects.get(17).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(17).translateObject(-0.3f, 1.3f, -2.2f);

        // daun 3
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(18).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(18).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);
        objects.get(18).rotateObjectSelf((float) Math.toRadians(180f), 0f, 1f, 0f);

        objects.get(18).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(18).translateObject(-0.9f, 1.3f, -1.89f);

        // daun 4
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(19).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(19).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);
        objects.get(19).rotateObjectSelf((float) Math.toRadians(270f), 0f, 1f, 0f);

        objects.get(19).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(19).translateObject(-0.6f, 1.3f, -1.3f);

        // daun 5
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(20).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(20).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);
        objects.get(20).rotateObjectSelf((float) Math.toRadians(310f), 0f, 1f, 0f);

        objects.get(20).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(20).translateObject(-0.3f, 1.3f, -1.3f);

        // sungai
        objects.add(new halfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0f, 1f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                1f,
                5f, 1f, 36, 10000
        ));
        objects.get(21).scaleObject(3f, 1f, 1f);
        objects.get(21).translateObject(-3.5f, 0f, -1f);
        objects.get(21).rotateObject((float)Math.toRadians(-90f),1f, 0f, 0f);

        // pohon
        objects.add(new Elipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.6f, 0.38f, 0.22f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.3f,
                0.5f,
                0.7f,
                36,
                18
        ));
        objects.get(22).translateObject(2.5f, -0.1f, -1.8f);
        objects.get(22).scaleObject(1f, 4f, 1f);

        // daun 1
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(23).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(23).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);

        objects.get(23).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(23).translateObject(3f, 1.3f, -1.6f);

        // daun 2
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,0.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(24).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(24).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);
        objects.get(24).rotateObjectSelf((float) Math.toRadians(90f), 0f, 1f, 0f);

        objects.get(24).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(24).translateObject(2.8f, 1.3f, -2.2f);

        // daun 3
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(25).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(25).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);
        objects.get(25).rotateObjectSelf((float) Math.toRadians(180f), 0f, 1f, 0f);

        objects.get(25).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(25).translateObject(2f, 1.3f, -1.89f);

        // daun 4
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(26).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(26).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);
        objects.get(26).rotateObjectSelf((float) Math.toRadians(270f), 0f, 1f, 0f);

        objects.get(26).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(26).translateObject(2.2f, 1.3f, -1.3f);

        // daun 5
        objects.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                Arrays.asList(
                        new float[]{1f,0,0},
                        new float[]{0f, 1f, 0},
                        new float[]{-2f,0,0},
                        new float[]{0,-1f,0},
                        new float[]{1f,0,0}

                )
        ));
        objects.get(27).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(27).rotateObject((float) Math.toRadians(-40f), 0f, 1f, 1f);
        objects.get(27).rotateObjectSelf((float) Math.toRadians(310f), 0f, 1f, 0f);

        objects.get(27).scaleObject(0.7f, 0.7f, 0.7f);
        objects.get(27).translateObject(2.8f, 1.3f, -1.3f);




        objects.get(3).translateObject(2f, 0.2f, 0f);
        objects.get(4).translateObject(2f, 0.2f, 0f);
        objects.get(5).translateObject(2f, 0.2f, 0f);
        objects.get(6).translateObject(2f, 0.2f, 0f);
        objects.get(7).translateObject(2f, 0.2f, 0f);
        objects.get(8).translateObject(2f, 0.2f, 0f);
        objects.get(9).translateObject(2f, 0.2f, 0f);
        objects.get(10).translateObject(2f, 0.2f, 0f);

    }















    public void input() {
        // ROTATE KAMERA
        if (window.isKeyPressed(GLFW_KEY_W) && window.isKeyPressed(GLFW_KEY_C)) {
            countDegree++;
            camera.moveDown((float)Math.toRadians(3f));
            camera.addRotation((float)Math.toRadians(-2f),0);
        }
        if (window.isKeyPressed(GLFW_KEY_S) && window.isKeyPressed(GLFW_KEY_C)) {
            countDegree++;
            camera.moveUp((float)Math.toRadians(3f));
            camera.addRotation((float)Math.toRadians(2f),0);
        }
        if (window.isKeyPressed(GLFW_KEY_A) && window.isKeyPressed(GLFW_KEY_C)) {
            countDegree++;
            camera.moveRight((float)Math.toRadians(3f));
            camera.addRotation(0,(float)Math.toRadians(-2f));
        }
        if (window.isKeyPressed(GLFW_KEY_D) && window.isKeyPressed(GLFW_KEY_C)) {
            countDegree++;
            camera.moveLeft((float)Math.toRadians(3f));
            camera.addRotation(0,(float)Math.toRadians(2f));
        }
        // CAMERA ZOOM IN OUT
        if (window.isKeyPressed(GLFW_KEY_Q) && window.isKeyPressed(GLFW_KEY_C)) {
            countDegree++;
            camera.moveForward((float)Math.toRadians(3f));
        }
        if (window.isKeyPressed(GLFW_KEY_E) && window.isKeyPressed(GLFW_KEY_C)) {
            countDegree++;
            camera.moveBackwards((float)Math.toRadians(3f));
        }
        // CAMERA TRANSLATE
        if(window.isKeyPressed(GLFW_KEY_Z) && window.isKeyPressed(GLFW_KEY_C)){
            countDegree++;
            camera.moveRight((float)Math.toRadians(3f));
        }
        if(window.isKeyPressed(GLFW_KEY_Y) && window.isKeyPressed(GLFW_KEY_C)){
            countDegree++;
            camera.moveLeft((float)Math.toRadians(3f));
        }

//

        // JOSEPH - SNORLAX -- ANIMATION --> Kode gerakan "CTRL"
        {
            // rotate
            // rotate x+
            if (window.isKeyPressed(GLFW_KEY_Q) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).rotateSendiri((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f, s_x, s_y, s_z);
                objects.get(1).rotateSendiri((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f, s_x, s_y, s_z);
                objects.get(2).rotasiSumbu((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f, objects.get(1).getPosition());

                setPosY(1f);
            }


            // rotate x-
            if (window.isKeyPressed(GLFW_KEY_E) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).rotateSendiri((float) Math.toRadians(-1f), 1.0f, 0.0f, 0.0f, s_x, s_y, s_z);
                objects.get(1).rotateSendiri((float) Math.toRadians(-1f), 1.0f, 0.0f, 0.0f, s_x, s_y, s_z);
                objects.get(2).rotateObject((float) Math.toRadians(-1f), 1.0f, 0.0f, 0.0f);

                setPosY(1f);

            }

            // rotate y+
            if (window.isKeyPressed(GLFW_KEY_A) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).rotateSendiri((float) Math.toRadians(1f), 0.0f, 1.0f, 0.0f, s_x, s_y, s_z);
                objects.get(1).rotateSendiri((float) Math.toRadians(1f), 0.0f, 1.0f, 0.0f, s_x, s_y, s_z);
                objects.get(2).rotateObject((float) Math.toRadians(1f), 0.0f, 1.0f, 0.0f);

                setPosY(1f);

            }
            // rotate y-
            if (window.isKeyPressed(GLFW_KEY_D) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).rotateSendiri((float) Math.toRadians(-1f), 0.0f, 1.0f, 0.0f, s_x, s_y, s_z);
                objects.get(1).rotateSendiri((float) Math.toRadians(-1f), 0.0f, 1.0f, 0.0f, s_x, s_y, s_z);
                objects.get(2).rotateObject((float) Math.toRadians(-1f), 0.0f, 1.0f, 0.0f);

                setPosY(-1f);

            }

            // rotate z+
            if (window.isKeyPressed(GLFW_KEY_W) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).rotateSendiri((float) Math.toRadians(1f), 0.0f, 0.0f, 1.0f, s_x, s_y, s_z);
                objects.get(1).rotateSendiri((float) Math.toRadians(1f), 0.0f, 0.0f, 1.0f, s_x, s_y, s_z);
                objects.get(2).rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, 1.0f);

                setPosY(1f);

            }
            // rotate z-
            if (window.isKeyPressed(GLFW_KEY_S) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).rotateSendiri((float) Math.toRadians(-1f), 0.0f, 0.0f, 1.0f, s_x, s_y, s_z);
                objects.get(1).rotateSendiri((float) Math.toRadians(-1f), 0.0f, 0.0f, 1.0f, s_x, s_y, s_z);
                objects.get(2).rotateObject((float) Math.toRadians(-1f), 0.0f, 0.0f, 1.0f);

                setPosY(1f);

            }

            // translate
            if (window.isKeyPressed(GLFW_KEY_1) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).translateObject(0.0f, 0.1f, 0.0f);
                objects.get(1).translateObject(0.0f, 0.1f, 0.00f);
                objects.get(2).translateObject(0.0f, 0.1f, 0.00f);
                setS(0f, 0.1f, 0f);
//            setPosY(1f);
            }

            if (window.isKeyPressed(GLFW_KEY_6) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).translateObject(0.0f, 0.0f, 0.1f);
                objects.get(1).translateObject(0.0f, 0.0f, 0.1f);
                objects.get(2).translateObject(0.0f, 0.0f, 0.1f);
                setS(0f, 0f, 0.001f);
//            setPosY(1f);
            }

            if (window.isKeyPressed(GLFW_KEY_3) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).translateObject(0.1f, 0.0f, 0.0f);
                objects.get(1).translateObject(0.1f, 0.0f, 0.0f);
                objects.get(2).translateObject(0.1f, 0.0f, 0.0f);
                setS(0.001f, 0f, 0f);
//            setPosY(1f);
            }

            if (window.isKeyPressed(GLFW_KEY_2) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).translateObject(0.0f, -0.1f, 0.0f);
                objects.get(1).translateObject(0.0f, -0.1f, 0.00f);
                objects.get(2).translateObject(0.0f, -0.1f, 0.00f);
                setS(0f, -0.001f, 0f);
//            setPosY(1f);
            }

            if (window.isKeyPressed(GLFW_KEY_5) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).translateObject(0.0f, 0.0f, -0.1f);
                objects.get(1).translateObject(0.0f, 0.0f, -0.1f);
                objects.get(2).translateObject(0.0f, 0.0f, -0.1f);
                setS(0f, 0f, -0.001f);
//            setPosY(1f);
            }

            if (window.isKeyPressed(GLFW_KEY_4) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                countDegree++;
                objects.get(0).translateObject(-0.1f, 0.0f, 0.0f);
                objects.get(1).translateObject(-0.1f, 0.0f, 0.0f);
                objects.get(2).translateObject(-0.1f, 0.0f, 0.0f);
                setS(-0.001f, 0f, 0f);
//            setPosY(1f);
            }

//        tangan naik turun
            if (window.isKeyPressed(GLFW_KEY_M) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                if (tanganSnorlax>= 30f) {
                    turnTanganSnorlax = false;
                } else if (tanganSnorlax <= -30f) {
                    turnTanganSnorlax = true;
                }
                if (turnTanganSnorlax == true) {
                    objects.get(1).translateObject(-s_x, -s_y, -s_z);

                    // TANGAN NAIK
                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(-1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(6).translateObject(-0.0f, -0.001f, 0.0f);
                    objects.get(1).getChildObject().get(7).translateObject(-0.0f, -0.001f, 0.0f);

                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                    // KUKU KANAN
                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(19).translateObject(0.0f, -0.001f, 0.0f);
                    objects.get(1).getChildObject().get(20).translateObject(0.0f, -0.001f, 0.0f);
                    objects.get(1).getChildObject().get(21).translateObject(0.0f, -0.001f, 0.0f);

                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                    // KUKU KIRI
                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(1f), 0f, 0f, -1f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(1f), 0f, 0f, -1f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(1f), 0f, 0f, -1f);
                    objects.get(1).getChildObject().get(16).translateObject(0.0f, -0.001f, 0.0f);
                    objects.get(1).getChildObject().get(17).translateObject(0.0f, -0.001f, 0.0f);
                    objects.get(1).getChildObject().get(18).translateObject(0.0f, -0.001f, 0.0f);

                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).translateObject(s_x, s_y, s_z);
                    setTanganSnorlax(0.7f);
                } else {
                    countDegree++;

                    objects.get(1).translateObject(-s_x, -s_y, -s_z);
                    // TANGAN TURUN
                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(-1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(6).translateObject(0.0f, 0.001f, 0.0f);
                    objects.get(1).getChildObject().get(7).translateObject(0.0f, 0.001f, 0.0f);

                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                    // KUKU KIRI
                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    objects.get(1).getChildObject().get(16).translateObject(-0.0f, 0.001f, 0.0f);
                    objects.get(1).getChildObject().get(17).translateObject(-0.0f, 0.001f, 0.0f);
                    objects.get(1).getChildObject().get(18).translateObject(-0.0f, 0.001f, 0.0f);

                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                    // KUKU KANAN
                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(1f), 0f, 0f, -1f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(1f), 0f, 0f, -1f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(1f), 0f, 0f, -1f);
                    objects.get(1).getChildObject().get(19).translateObject(-0.0f, 0.001f, 0.0f);
                    objects.get(1).getChildObject().get(20).translateObject(-0.0f, 0.001f, 0.0f);
                    objects.get(1).getChildObject().get(21).translateObject(-0.0f, 0.001f, 0.0f);

                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).translateObject(s_x, s_y, s_z);
                    setTanganSnorlax(-0.7f);

                }
                countDegree++;
            }

            // tangan buka tutup
            // tangan buka
            if (window.isKeyPressed(GLFW_KEY_V) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                if (tanganSnorlaxBuka>= 30f) {
                    turnTanganSnorlaxBuka = false;
                } else if (tanganSnorlaxBuka <= -30f) {
                    turnTanganSnorlaxBuka = true;
                }
                if (turnTanganSnorlaxBuka == true) {
                    countDegree++;
                    objects.get(1).translateObject(-s_x, -s_y, -s_z);

                    // TANGAN BUKA
                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(-1f), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(1f), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(6).translateObject(-0.0001f, -0.00045f, 0.001f);
                    objects.get(1).getChildObject().get(7).translateObject(0.0001f, -0.00045f, 0.001f);

                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                    // KUKU KANAN
                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(1f), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(1f), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(1f), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(19).translateObject(0.0001f, -0.00045f, 0.001f);
                    objects.get(1).getChildObject().get(20).translateObject(0.0001f, -0.00045f, 0.001f);
                    objects.get(1).getChildObject().get(21).translateObject(0.0001f, -0.00045f, 0.001f);

                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                    // KUKU KIRI
                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(16).translateObject(-0.0001f, -0.00045f, 0.001f);
                    objects.get(1).getChildObject().get(17).translateObject(-0.0001f, -0.00045f, 0.001f);
                    objects.get(1).getChildObject().get(18).translateObject(-0.0001f, -0.00045f, 0.001f);

                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).translateObject(s_x, s_y, s_z);
                    setTanganSnorlaxBuka(0.7f);
                } else {
                    objects.get(1).translateObject(-s_x, -s_y, -s_z);

                    countDegree++;
                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    // TANGAN NUTUP
                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(1f), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(-1f), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(6).translateObject(0.0001f, 0.00045f, -0.001f);
                    objects.get(1).getChildObject().get(7).translateObject(-0.0001f, 0.00045f, -0.001f);

                    objects.get(1).getChildObject().get(6).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                    // KUKU KANAN
                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(19).translateObject(-0.0001f, 0.00045f, -0.001f);
                    objects.get(1).getChildObject().get(20).translateObject(-0.0001f, 0.00045f, -0.001f);
                    objects.get(1).getChildObject().get(21).translateObject(-0.0001f, 0.00045f, -0.001f);

                    objects.get(1).getChildObject().get(19).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(20).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(21).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                    // KUKU KIRI
                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(-1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(-1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(-1f), 0f, -1f, 0f);
                    objects.get(1).getChildObject().get(16).translateObject(0.0001f, 0.00045f, -0.001f);
                    objects.get(1).getChildObject().get(17).translateObject(0.0001f, 0.00045f, -0.001f);
                    objects.get(1).getChildObject().get(18).translateObject(0.0001f, 0.00045f, -0.001f);

                    objects.get(1).getChildObject().get(16).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(17).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(18).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).translateObject(s_x, s_y, s_z);

                    setTanganSnorlaxBuka(-0.7f);
                }

            }

            // kaki naik turun
            // kaki turun
            if (window.isKeyPressed(GLFW_KEY_K) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                if (kakiSnorlax >= 30f) {
                    turnKakiSnorlax = false;
                } else if (kakiSnorlax <= -30f) {
                    turnKakiSnorlax = true;
                }
                if (turnKakiSnorlax == true) {
                    objects.get(1).translateObject(-s_x, -s_y, -s_z);

                    objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

                    objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);

                    objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);

                    objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).translateObject(s_x, s_y, s_z);

                    setKakiSnorlax(0.7f);
                } else {
                    objects.get(1).translateObject(-s_x, -s_y, -s_z);

                    objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);


//             INI PENTING BUAT NURUNIN KAKI
                    objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);

                    objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                    objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);

                    objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);


                    objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                    objects.get(1).translateObject(s_x, s_y, s_z);
                    setKakiSnorlax(-0.7f);

                }

                // kaki naik
                if (window.isKeyPressed(GLFW_KEY_L)) {
                    countDegree++;

                }
                countDegree++;
            }

            // mulut buka tutup
            // mulut buka
            if (window.isKeyPressed(GLFW_KEY_Z) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                objects.get(0).translateObject(-s_x, -s_y, -s_z);
                objects.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(0).getChildObject().get(8).rotateObjectSelf((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(0).translateObject(s_x, s_y, s_z);
            }

            // mulut tutup
            if (window.isKeyPressed(GLFW_KEY_X) && window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
                objects.get(0).translateObject(-s_x, -s_y, -s_z);
                objects.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(0).getChildObject().get(8).rotateObjectSelf((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(0).translateObject(s_x, s_y, s_z);

            }

            // naikin kaki
            if (window.isKeyPressed(GLFW_KEY_H)) {
                objects.get(1).translateObject(-s_x, -s_y, -s_z);
                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(2).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

//             INI PENTING BUAT NURUNIN KAKI
                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(2).translateObject(0f, 0f, 0.01f);

                objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(-1f), 1f, 0f, 0f);

                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(2).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).translateObject(s_x, s_y, s_z);

            }

            // nurunin kaki
            if (window.isKeyPressed(GLFW_KEY_J)) {
                objects.get(1).translateObject(-s_x, -s_y, -s_z);

                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);
                objects.get(2).rotateObject((float) Math.toRadians(-posY), 0f, 1f, 0f);

//             INI PENTING BUAT NURUNIN KAKI
                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);

                objects.get(2).translateObject(0f, 0f, -0.01f);

                objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
                objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);

                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);

                objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(8).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(9).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(10).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(11).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(12).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(1).getChildObject().get(13).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);
                objects.get(2).rotateObject((float) Math.toRadians(posY), 0f, 1f, 0f);


                objects.get(1).translateObject(s_x, s_y, s_z);

            }
        }

        // ABIEL - AIPOM -- ANIMATION --> Kode gerakan "Left_Shift"
        {
            // rotate seluruh object
            // rotate kanan --> D
            if (window.isKeyPressed(GLFW_KEY_D) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                setPosYAipom(1f);
                countDegree++;
                objects.get(12).rotateObjectSelf((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f);
                objects.get(12).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(1).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(2).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(3).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(4).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(5).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(11).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(12).getPosition());
                setyMata(1f);



            }
            // rotate kiri --> A
            if (window.isKeyPressed(GLFW_KEY_A) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                setPosYAipom(-1f);
                countDegree++;
                objects.get(12).rotateObjectSelf((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f);
                objects.get(12).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(1).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(2).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(3).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(4).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(12).getChildObject().get(5).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(12).getPosition());
                objects.get(11).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(12).getPosition());
                setyMata(-1f);


            }
            // Translate seluruh object
            // geser atas
            if (window.isKeyPressed(GLFW_KEY_UP) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).translateObject(0f, 0.1f, 0f);
                objects.get(12).translateObject(0f, 0.1f, 0f);
                setKor(0f,0.1f,0f);

            }
            // geser bawah
            if (window.isKeyPressed(GLFW_KEY_DOWN) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).translateObject(0f, -0.1f, 0f);
                objects.get(12).translateObject(0f, -0.1f, 0f);
                setKor(0f,-0.1f,0f);

            }
            // geser kiri
            if (window.isKeyPressed(GLFW_KEY_LEFT) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).translateObject(-0.1f, 0f, 0f);
                objects.get(12).translateObject(-0.1f, 0f, 0f);
                setKor(-0.1f,0f,0f);

            }
            // geser kanan
            if (window.isKeyPressed(GLFW_KEY_RIGHT) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).translateObject(0.1f, 0f, 0f);
                objects.get(12).translateObject(0.1f, 0f, 0f);
                setKor(0.1f,0f,0f);

            }
            // geser depan
            if (window.isKeyPressed(GLFW_KEY_M) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).translateObject(0f, 0f, 0.1f);
                objects.get(12).translateObject(0f, 0f, 0.1f);

            }
            // geser belakang
            if (window.isKeyPressed(GLFW_KEY_N) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).translateObject(0f, 0f, -0.1f);
                objects.get(12).translateObject(0f, 0f, -0.1f);
            }


            // gerakan mata --> 1234

            // gerakan mata ke kiri
            if (window.isKeyPressed(GLFW_KEY_1) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).getChildObject().get(6).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.0f, -0.1f, 0.0f, objects.get(11).getPosition());
                objects.get(11).getChildObject().get(7).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.0f, -0.1f, 0.0f, objects.get(11).getPosition());
            }
            // gerakan mata ke kanan
            if (window.isKeyPressed(GLFW_KEY_2) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).getChildObject().get(6).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.0f, 0.1f, 0.0f, objects.get(11).getPosition());
                objects.get(11).getChildObject().get(7).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.0f, 0.1f, 0.0f, objects.get(11).getPosition());
            }
            // gerakan mata ke atas
            if (window.isKeyPressed(GLFW_KEY_3) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).getChildObject().get(6).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), -0.1f, 0.0f, 0.0f, objects.get(11).getPosition());
                objects.get(11).getChildObject().get(7).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), -0.1f, 0.0f, 0.0f, objects.get(11).getPosition());
            }
            // gerakan mata ke bawah
            if (window.isKeyPressed(GLFW_KEY_4) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(11).getChildObject().get(6).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.1f, 0.0f, 0.0f, objects.get(11).getPosition());
                objects.get(11).getChildObject().get(7).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.1f, 0.0f, 0.0f, objects.get(11).getPosition());
            }



            // gerakan tangan --> T 5 6
            // gerakan kedua tangan --> T
            if (window.isKeyPressed(GLFW_KEY_T) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                if (legDegree >= 10f) {
                    turnWing = false;
                } else if (legDegree <= -90f) {
                    turnWing = true;
                }
                if (turnWing == true) {
                    objects.get(12).getChildObject().get(1).rotasiSumbu((float) Math.toRadians(1f), -0.f, -0.7f, 0.f, objects.get(12).getPosition());
                    objects.get(12).getChildObject().get(2).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.f, objects.get(12).getPosition());
                    setLegDegree(0.7f);
                } else {
                    objects.get(12).getChildObject().get(1).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.f, objects.get(12).getPosition());
                    objects.get(12).getChildObject().get(2).rotasiSumbu((float) Math.toRadians(1f), -0.f, -0.7f, 0.f, objects.get(12).getPosition());
                    setLegDegree(-0.7f);
                }
            }

            // gerakan tangan kiri --> 5
//            if (window.isKeyPressed(GLFW_KEY_5) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
//                countDegree++;
//                if (legDegree >= 10f) {
//                    turnWing = false;
//                } else if (legDegree <= -90f) {
//                    turnWing = true;
//                }
//                if (turnWing == true) {
//                    objects.get(12).getChildObject().get(1).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.f, objects.get(12).getPosition());
//                    setLegDegree(0.7f);
//                } else {
//                    objects.get(12).getChildObject().get(1).rotasiSumbu((float) Math.toRadians(1f), 0.f, -0.7f, 0.f, objects.get(12).getPosition());
//                    setLegDegree(-0.7f);
//                }
//            }
//
//
//            // gerakan tangan kanan --> 6
//            if (window.isKeyPressed(GLFW_KEY_6) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
//                countDegree++;
//                if (legDegree >= 10f) {
//                    turnWing = false;
//                } else if (legDegree <= -90f) {
//                    turnWing = true;
//                }
//                if (turnWing == true) {
//                    objects.get(12).getChildObject().get(2).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.f, objects.get(12).getPosition());
//                    setLegDegree(0.7f);
//                } else {
//                    objects.get(12).getChildObject().get(2).rotasiSumbu((float) Math.toRadians(1f), -0f, -0.7f, 0.f, objects.get(12).getPosition());
//                    setLegDegree(-0.7f);
//                }
//            }

            // Gerakan kaki --> Y U I

            // Gerak Kaki Berjalan --> Y
//            if (window.isKeyPressed(GLFW_KEY_Y) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
//                if (kaki==30f)
//                    setKakiB(false);
//                else if(kaki==-30f)
//                    setKakiB(true);
//
//                if (kakiB){
//
//                    objects.get(12).rotateObject((float)Math.toRadians(-yMata),0f,1f,0f);
//
//                    objects.get(12).getChildObject().get(4).rotateObjectSelf((float)Math.toRadians(-1f),1f,0f,0f);
//                    objects.get(12).getChildObject().get(4).translateObject(0f,0.0005f,0.0005f);
//
//                    objects.get(12).getChildObject().get(3).rotateObjectSelf((float)Math.toRadians(1f),1f,0f,0f);
//                    objects.get(12).getChildObject().get(3).translateObject(0f,-0.0005f,-0.0005f);
//
//                    objects.get(12).rotateObject((float)Math.toRadians(yMata),0f,1f,0f);
//
//                    setKaki(1f);
//                }
//                else{
//
//                    objects.get(12).rotateObject((float)Math.toRadians(-yMata),0f,1f,0f);
//
//                    objects.get(12).getChildObject().get(3).rotateObjectSelf((float)Math.toRadians(-1f),1f,0f,0f);
//                    objects.get(12).getChildObject().get(3).translateObject(0.0f,0.0005f,0.0005f);
//
//                    objects.get(12).getChildObject().get(4).rotateObjectSelf((float)Math.toRadians(1f),1f,0f,0f);
//                    objects.get(12).getChildObject().get(4).translateObject(0f,-0.0005f,-0.0005f);
//
//                    objects.get(12).rotateObject((float)Math.toRadians(yMata),0f,1f,0f);
//
//                    setKaki(-1f);
//                }
//            }
            // Gerak Kaki Berjalan --> Y
            if (window.isKeyPressed(GLFW_KEY_Y) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                objects.get(12).rotateObject((float) Math.toRadians(-posYNatu), 0f, 1f, 0.f);
                objects.get(12).getChildObject().get(3).rotateObject((float) Math.toRadians(-posYNatu), 0f, 1f, 0.f);
                objects.get(12).getChildObject().get(4).rotateObject((float) Math.toRadians(-posYNatu), 0f, 1f, 0.f);

                objects.get(12).getChildObject().get(3).translateObject(0f, -0.00001f, 0.f);
                objects.get(12).getChildObject().get(4).translateObject(0f, -0.00001f, 0.f);

                if (legDegree >= 45f) {
                    turnLeg = false;
                } else if (legDegree <= -45f) {
                    turnLeg = true;
                }
                if (turnLeg == true) {
                    objects.get(12).rotateObject((float)Math.toRadians(-posYNatu),0f,1f,0f);
                    objects.get(12).getChildObject().get(3).rotasiSumbu((float) Math.toRadians(1f), -1f, 0.f, 0.f, objects.get(12).getPosition());
                    objects.get(12).getChildObject().get(4).rotasiSumbu((float) Math.toRadians(1f), 1f, 0.f, 0.f, objects.get(12).getPosition());
                    objects.get(12).rotateObject((float)Math.toRadians(posYNatu),0f,1f,0f);
                    setLegDegree(1f);
                } else {
                    objects.get(12).rotateObject((float)Math.toRadians(-posYNatu),0f,1f,0f);
                    objects.get(12).getChildObject().get(3).rotasiSumbu((float) Math.toRadians(1f), 1f, 0.f, 0.f, objects.get(12).getPosition());
                    objects.get(12).getChildObject().get(4).rotasiSumbu((float) Math.toRadians(1f), -1f, 0.f, 0.f, objects.get(12).getPosition());
                    objects.get(12).rotateObject((float)Math.toRadians(posYNatu),0f,1f,0f);
                    setLegDegree(-1f);
                }

                objects.get(12).rotateObject((float) Math.toRadians(posYNatu), 0f, 1f, 0.f);
                objects.get(12).getChildObject().get(3).rotateObject((float) Math.toRadians(posYNatu), 0f, 1f, 0.f);
                objects.get(12).getChildObject().get(4).rotateObject((float) Math.toRadians(posYNatu), 0f, 1f, 0.f);
            }





            // Gerakan ekor --> KL

            // Ekor ke keatas --> K
            if (window.isKeyPressed(GLFW_KEY_K) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                if (legDegree >= 10f) {
                    turnWing = false;
                } else if (legDegree <= -20f) {
                    turnWing = true;
                }
                if (turnWing == true) {
                    objects.get(12).getChildObject().get(5).rotasiSumbu((float) Math.toRadians(1f), -0.7f, -0.0f, 0.0f, objects.get(12).getChildObject().get(5).getPosition());
                    setLegDegree(-0.7f);
                } else {
                    objects.get(12).getChildObject().get(5).rotasiSumbu((float) Math.toRadians(1f), 0.7f, 0.0f, 0.0f, objects.get(12).getChildObject().get(5).getPosition());
                    setLegDegree(-0.7f);
                }
            }
            // Ekor ke bawah --> L
            if (window.isKeyPressed(GLFW_KEY_L) && window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
                countDegree++;
                if (legDegree >= 10f) {
                    turnWing = false;
                } else if (legDegree <= -20f) {
                    turnWing = true;
                }
                if (turnWing == true) {
                    objects.get(12).getChildObject().get(5).rotasiSumbu((float) Math.toRadians(1f), 0.7f, 0.0f, 0.0f, objects.get(12).getChildObject().get(5).getPosition());
                    setLegDegree(-0.7f);
                } else {
                    objects.get(12).getChildObject().get(5).rotasiSumbu((float) Math.toRadians(1f), -0.7f, 0.0f, 0.0f, objects.get(12).getChildObject().get(5).getPosition());
                    setLegDegree(-0.7f);
                }
            }




        }










        // JASON - NATU -- ANIMATION --> Kode gerakan "="
        {

            // rotate seluruh object
            // rotate kanan --> A
            if (window.isKeyPressed(GLFW_KEY_A) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                setPosYNatu(1f);
                countDegree++;
                objects.get(3).rotateObjectSelf((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f);
                objects.get(3).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(3).getChildObject().get(1).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(3).getChildObject().get(2).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(3).getChildObject().get(3).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(3).getChildObject().get(4).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(4).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(5).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(6).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(7).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(8).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(9).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(10).rotasiSumbu((float) Math.toRadians(1f), 0.f, 1.0f, 0.0f, objects.get(3).getPosition());


            }
            // rotate kiri natu --> D
            if (window.isKeyPressed(GLFW_KEY_D) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                setPosYNatu(-1f);
//                for (int i =3; i<=10; i++){
//                    objects.get(i).rotateObjectSelf((float) Math.toRadians(posYNatu), 0.f, 1.0f, 0.0f);
//                }
                countDegree++;
                objects.get(3).rotateObjectSelf((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f);
                objects.get(3).getChildObject().get(0).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(3).getChildObject().get(1).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(3).getChildObject().get(2).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(3).getChildObject().get(3).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(3).getChildObject().get(4).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(4).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(5).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(6).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(7).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(8).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(9).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());
                objects.get(10).rotasiSumbu((float) Math.toRadians(1f), 0.f, -1.0f, 0.0f, objects.get(3).getPosition());

//                for (int i =3; i<=10; i++){
//                    objects.get(i).rotateObjectSelf((float) Math.toRadians(-posYNatu), 0.f, 1.0f, 0.0f);
//                }

            }

            // Translate seluruh object
            // geser atas
            if (window.isKeyPressed(GLFW_KEY_UP) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(3).translateObject(0f, 0.1f, 0f);
                objects.get(4).translateObject(0f, 0.1f, 0f);
                objects.get(5).translateObject(0f, 0.1f, 0f);
                objects.get(6).translateObject(0f, 0.1f, 0f);
                objects.get(7).translateObject(0f, 0.1f, 0f);
                objects.get(8).translateObject(0f, 0.1f, 0f);
                objects.get(9).translateObject(0f, 0.1f, 0f);
                objects.get(10).translateObject(0f, 0.1f, 0f);
            }
            // geser bawah
            if (window.isKeyPressed(GLFW_KEY_DOWN) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(3).translateObject(0f, -0.1f, 0f);
                objects.get(4).translateObject(0f, -0.1f, 0f);
                objects.get(5).translateObject(0f, -0.1f, 0f);
                objects.get(6).translateObject(0f, -0.1f, 0f);
                objects.get(7).translateObject(0f, -0.1f, 0f);
                objects.get(8).translateObject(0f, -0.1f, 0f);
                objects.get(9).translateObject(0f, -0.1f, 0f);
                objects.get(10).translateObject(0f, -0.1f, 0f);
            }
            // geser kiri
            if (window.isKeyPressed(GLFW_KEY_LEFT) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(3).translateObject(-0.1f, 0f, 0f);
                objects.get(4).translateObject(-0.1f, 0f, 0f);
                objects.get(5).translateObject(-0.1f, 0f, 0f);
                objects.get(6).translateObject(-0.1f, 0f, 0f);
                objects.get(7).translateObject(-0.1f, 0f, 0f);
                objects.get(8).translateObject(-0.1f, 0f, 0f);
                objects.get(9).translateObject(-0.1f, 0f, 0f);
                objects.get(10).translateObject(-0.1f, 0f, 0f);
            }
            // geser kanan
            if (window.isKeyPressed(GLFW_KEY_RIGHT) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(3).translateObject(0.1f, 0f, 0f);
                objects.get(4).translateObject(0.1f, 0f, 0f);
                objects.get(5).translateObject(0.1f, 0f, 0f);
                objects.get(6).translateObject(0.1f, 0f, 0f);
                objects.get(7).translateObject(0.1f, 0f, 0f);
                objects.get(8).translateObject(0.1f, 0f, 0f);
                objects.get(9).translateObject(0.1f, 0f, 0f);
                objects.get(10).translateObject(0.1f, 0f, 0f);
            }
            // geser depan
            if (window.isKeyPressed(GLFW_KEY_M) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(3).translateObject(0f, 0f, 0.1f);
                objects.get(4).translateObject(0f, 0f, 0.1f);
                objects.get(5).translateObject(0f, 0f, 0.1f);
                objects.get(6).translateObject(0f, 0f, 0.1f);
                objects.get(7).translateObject(0f, 0f, 0.1f);
                objects.get(8).translateObject(0f, 0f, 0.1f);
                objects.get(9).translateObject(0f, 0f, 0.1f);
                objects.get(10).translateObject(0f, 0f, 0.1f);
            }
            // geser belakang
            if (window.isKeyPressed(GLFW_KEY_N) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(3).translateObject(0f, 0f, -0.1f);
                objects.get(4).translateObject(0f, 0f, -0.1f);
                objects.get(5).translateObject(0f, 0f, -0.1f);
                objects.get(6).translateObject(0f, 0f, -0.1f);
                objects.get(7).translateObject(0f, 0f, -0.1f);
                objects.get(8).translateObject(0f, 0f, -0.1f);
                objects.get(9).translateObject(0f, 0f, -0.1f);
                objects.get(10).translateObject(0f, 0f, -0.1f);
            }


            // gerakan mata --> 1234

            // gerakan mata ke kiri
            if (window.isKeyPressed(GLFW_KEY_1) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(4).rotasiSumbu((float) Math.toRadians(1f), 0.0f, -0.1f, 0.0f, objects.get(3).getPosition());
            }
            // gerakan mata ke kanan
            if (window.isKeyPressed(GLFW_KEY_2) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(4).rotasiSumbu((float) Math.toRadians(1f), 0.0f, 0.1f, 0.0f, objects.get(3).getPosition());
            }
            // gerakan mata ke atas
            if (window.isKeyPressed(GLFW_KEY_3) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(4).rotasiSumbu((float) Math.toRadians(1f), -0.1f, 0.0f, 0.0f, objects.get(3).getPosition());
            }
            // gerakan mata ke bawah
            if (window.isKeyPressed(GLFW_KEY_4) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(4).rotasiSumbu((float) Math.toRadians(1f), 0.1f, 0.0f, 0.0f, objects.get(3).getPosition());
            }


            // gerakan sayap --> T 5 6
            // gerakan kedua sayap --> T
            if (window.isKeyPressed(GLFW_KEY_T) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                if (legDegree >= 20f) {
                    turnWing = false;
                } else if (legDegree <= -10f) {
                    turnWing = true;
                }
                if (turnWing == true) {
                    objects.get(6).rotasiSumbu((float) Math.toRadians(1f), -0.f, -0.7f, 0.f, objects.get(3).getPosition());
                    objects.get(7).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.f, objects.get(3).getPosition());
                    setLegDegree(0.7f);
                } else {
                    objects.get(6).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.f, objects.get(3).getPosition());
                    objects.get(7).rotasiSumbu((float) Math.toRadians(1f), -0.f, -0.7f, 0.f, objects.get(3).getPosition());
                    setLegDegree(-0.7f);
                }
            }

            // gerakan sayap kiri --> 5
            if (window.isKeyPressed(GLFW_KEY_5) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                if (legDegree >= 20f) {
                    turnWing = false;
                } else if (legDegree <= -10f) {
                    turnWing = true;
                }
                if (turnWing == true) {
                    objects.get(6).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.f, objects.get(3).getPosition());
                    setLegDegree(0.7f);
                } else {
                    objects.get(6).rotasiSumbu((float) Math.toRadians(1f), 0.f, -0.7f, 0.f, objects.get(3).getPosition());
                    setLegDegree(-0.7f);
                }
            }


            // gerakan sayap kanan --> 6
            if (window.isKeyPressed(GLFW_KEY_6) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                if (legDegree >= 20f) {
                    turnWing = false;
                } else if (legDegree <= -10f) {
                    turnWing = true;
                }
                if (turnWing == true) {
                    objects.get(7).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.f, objects.get(3).getPosition());
                    setLegDegree(0.7f);
                } else {
                    objects.get(7).rotasiSumbu((float) Math.toRadians(1f), -0f, -0.7f, 0.f, objects.get(3).getPosition());
                    setLegDegree(-0.7f);
                }
            }


            // Jambul --> 90
            if (window.isKeyPressed(GLFW_KEY_9) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(5).rotasiSumbu((float) Math.toRadians(posYNatu), -0.5f, 0.f, 0.f, objects.get(3).getPosition());
            }
            if (window.isKeyPressed(GLFW_KEY_0) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(5).rotasiSumbu((float) Math.toRadians(posYNatu), 0.5f, 0.f, 0.f, objects.get(3).getPosition());
            }


            // Gerakan kaki --> Y U I

            // Gerak Kaki Berjalan --> Y
            if (window.isKeyPressed(GLFW_KEY_Y) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(3).rotateObject((float) Math.toRadians(-posYNatu), 0f, 1f, 0.f);
                objects.get(8).rotateObject((float) Math.toRadians(-posYNatu), 0f, 1f, 0.f);
                objects.get(9).rotateObject((float) Math.toRadians(-posYNatu), 0f, 1f, 0.f);

                objects.get(8).translateObject(0f, -0.00001f, 0.f);
                objects.get(9).translateObject(0f, -0.00001f, 0.f);

                if (legDegree >= 45f) {
                    turnLeg = false;
                } else if (legDegree <= -45f) {
                    turnLeg = true;
                }
                if (turnLeg == true) {
                    objects.get(8).rotasiSumbu((float) Math.toRadians(1f), -1f, 0.f, 0.f, objects.get(3).getPosition());
                    objects.get(9).rotasiSumbu((float) Math.toRadians(1f), 1f, 0.f, 0.f, objects.get(3).getPosition());
                    setLegDegree(1f);
                } else {
                    objects.get(8).rotasiSumbu((float) Math.toRadians(1f), 1f, 0.f, 0.f, objects.get(3).getPosition());
                    objects.get(9).rotasiSumbu((float) Math.toRadians(1f), -1f, 0.f, 0.f, objects.get(3).getPosition());
                    setLegDegree(-1f);
                }

                objects.get(3).rotateObject((float) Math.toRadians(posYNatu), 0f, 1f, 0.f);
                objects.get(8).rotateObject((float) Math.toRadians(posYNatu), 0f, 1f, 0.f);
                objects.get(9).rotateObject((float) Math.toRadians(posYNatu), 0f, 1f, 0.f);
            }

            // gerakan kaki kiri --> U
            if (window.isKeyPressed(GLFW_KEY_U) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                if (legDegree >= 45f) {
                    turnLeg = false;
                } else if (legDegree <= -45f) {
                    turnLeg = true;
                }
                if (turnLeg == true) {
                    objects.get(8).rotasiSumbu((float) Math.toRadians(1f), -0.7f, 0.f, 0.f, objects.get(3).getPosition());
                    setLegDegree(0.7f);
                } else {
                    objects.get(8).rotasiSumbu((float) Math.toRadians(1f), 0.7f, 0.f, 0.f, objects.get(3).getPosition());
                    setLegDegree(-0.7f);
                }
            }


            // Gerakan kaki kanan --> I
            if (window.isKeyPressed(GLFW_KEY_I) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                if (legDegree >= 45f) {
                    turnLeg = false;
                } else if (legDegree <= -45f) {
                    turnLeg = true;
                }
                if (turnLeg == true) {
                    objects.get(9).rotasiSumbu((float) Math.toRadians(1f), 0.7f, 0.f, 0.f, objects.get(3).getPosition());
                    setLegDegree(0.7f);
                } else {
                    objects.get(9).rotasiSumbu((float) Math.toRadians(1f), -0.7f, 0.f, 0.f, objects.get(3).getPosition());
                    setLegDegree(-0.7f);
                }
            }


            // Gerakan ekor --> KL

            // Ekor ke kiri --> K
            if (window.isKeyPressed(GLFW_KEY_K) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(10).rotasiSumbu((float) Math.toRadians(1f), 0.f, -0.7f, 0.0f, objects.get(3).getChildObject().get(4).getPosition());
            }
            // Ekor ke kanan --> L
            if (window.isKeyPressed(GLFW_KEY_L) && window.isKeyPressed(GLFW_KEY_EQUAL)) {
                countDegree++;
                objects.get(10).rotasiSumbu((float) Math.toRadians(1f), 0.f, 0.7f, 0.0f, objects.get(3).getChildObject().get(4).getPosition());
            }
        }
    }


    public void loop(){
        while (window.isOpen()) {
            window.update();
            // warna bg
            glClearColor(0.33f, 0.45f, 1f,
                    0.0f);
            GL.createCapabilities();
            input();

            for(Object object: objects){
                object.draw(camera,projection);
            }

            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }

    public static void setPosY(float posY) {
        Main.posY += posY;
    }
    public static void setPosYNatu(float posY) {
        Main.posYNatu += posY;
    }
    public static void setPosYAipom(float posY) {
        Main.posYAipom += posY;
    }
    public static void setKakiB(boolean kakiB) {
       Main.kakiB = kakiB;
    }

    public static void setKaki(float kaki) {
        Main.kaki += kaki;
    }

    public static void setKor(float x, float y, float z) {
        Main.x += x;
        Main.y += y;
        Main.z += z;
    }




    public static void setLegDegree(float legDegree) {
        Main.legDegree += legDegree;
    }



    public static void setTanganSnorlax(float tanganSnorlax) {
        Main.tanganSnorlax += tanganSnorlax;
    }

    public static void setTanganSnorlaxBuka(float tanganSnorlaxBuka) {
        Main.tanganSnorlaxBuka += tanganSnorlaxBuka;
    }
    public static void setyMata(float yMata) {
        Main.yMata += yMata;
    }

    public static void setS(float x, float y, float z) {
        Main.s_x += x;
        Main.s_y += y;
        Main.s_z += z;
    }
}
