import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;

/**
 * Created by ant on 8.01.2017.
 */
public class PlayGround {
    public int noOfLives = 3;
    public long lastUpdate;
    public double refreshRate = Math.pow(1.5,1);
    Holes holes;
    public GridPane myPlayground = new GridPane();
    Scene scene = new Scene(myPlayground, 710, 410);
    public static int gridHeight = 8;
    public static int gridWidth = 14;
    public ArrayList<MovingObject> objects = new ArrayList();

    public PlayGround() {
        setupPlayground();
        holes = new Holes();
        renderGrid();
        listenKeyboard();
        AnimationTimer timer = new AnimationTimer() { //start adding and moving the objects
            @Override
            public void handle(long now) {
                if (now - lastUpdate > (Math.pow(10, 9)) / refreshRate) {
                    lastUpdate = now;
                    handleMovingObjects();
                }
            }
        };
        timer.start();
    }


    public void setupPlayground() {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        setupGrid();
    }

    public void renderGrid() {
        myPlayground.getChildren().clear();
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                Color status = holes.getColor(i,j);
                if (status == Color.BLUE) {
                    status = getColor(i,j);
                }
                Rectangle square = new Rectangle(50,50,status);
                square.setStroke(Color.RED);
                myPlayground.add(square,i,j);
            }
        }
    }

    public Color getColor(int x, int y) {
        for (int k = 0; k < objects.size(); k++) {
            MovingObject object = objects.get(k);
            int[] coordinates = object.getCoordinates();
            if (coordinates[0] == x && coordinates[1] == y)
                return Color.RED;
        }
        return Color.BLUE;
    }

    public void setupGrid() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                Rectangle square = new Rectangle(50, 50);
                square.setStroke(Color.RED);
                myPlayground.add(square, i, j);
            }
        }
    }

    public void listenKeyboard() {
        myPlayground.requestFocus();
        myPlayground.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.NUMPAD4) {
                    holes.fillHole(0);
                } else if (event.getCode() == KeyCode.NUMPAD5) {
                    holes.fillHole(1);
                } else if (event.getCode() == KeyCode.NUMPAD1) {
                    holes.fillHole(2);
                } else if (event.getCode() == KeyCode.NUMPAD2) {
                    holes.fillHole(3);
                }
                renderGrid();
            }
        });
    }

    public void handleMovingObjects() {
        //System.out.println(objects.size());

        //Liiguta olemasolevaid objekte
        for (int i = 0; i < objects.size(); i++) {
            MovingObject object = objects.get(i);
            object.moveObject();
            int[] coordinates = object.getCoordinates();
            if (coordinates[0] == 4 || coordinates[0] == 9) {
                int[] filledHoleCoordinates = holes.getFilledHoleCoordinates();
                if (filledHoleCoordinates[0] != coordinates[0]) {
                    object.fall();
                    noOfLives--;
                }
                else if (coordinates[1] != filledHoleCoordinates[1] - 1) {
                    object.fall();
                    noOfLives--;
                }
            }
        }

        //Otsusta juhuslikkuse alusel, kas objekt üldse lisada
        int j = (int) (Math.random() * 1.2);
        System.out.println(j);
        if (j == 1) {
            //Otsusta juhuslikkuse alusel, kas objekt lisada 1. või 2. tasandile
            int level = (int) (Math.random() * 2);
            if (level == 1) {
                MovingObject newObject = new MovingObject(0, 1);
                objects.add(newObject);
            }
            else {
                MovingObject newObject = new MovingObject(0, 4);
                objects.add(newObject);
            }
        }
        renderGrid();
        isGameOver();
    }
    public void isGameOver() {
        if (noOfLives <= 0) {
            StackPane stack = new StackPane();
            Label message = new Label("Game Over");
            message.setFont(Font.font("Arial Black",24));
            stack.getChildren().add(message);
            scene.setRoot(stack);
        }
    }
}
