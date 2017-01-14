import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by ant on 8.01.2017.
 */
public class PlayGround {
    public static ArrayList<Hole> holes = new ArrayList();
    private GridPane myPlayground = new GridPane();
    Scene scene = new Scene(myPlayground, 710, 410);
    public static int gridHeight = 8;
    public static int gridWidth = 14;
    public Rectangle junction1;
    public Rectangle junction2;
    public Rectangle junction3;
    public Rectangle junction4;

    public PlayGround() {
        setupPlayground();
    }


    public void setupPlayground() {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        System.out.println("andres");
        //holes = new Holes(4); //add 4 holes
        renderGrid();
        listenKeyboard();
    }

    public void renderGrid() {
        myPlayground.getChildren().clear();
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                Color type = getType(new int[]{i, j});
                Rectangle square = new Rectangle(50,50,type);
                square.setStroke(Color.RED);
                myPlayground.add(square, i, j);
                System.out.println(i);
                System.out.println(j);
            }
        }
    }

    public static Color getType(int[] xy) {
        for (int i = 0; i < holes.size(); i++) {
            Hole hole = holes.get(i);
            boolean empty = hole.emptyHole(hole);
            if (empty)                             // hole not filled
                return Color.BLACK;
            else
                return  Color.YELLOW;            // hole filled
        }
        return Color.BLUE;
    }
    public int h;
    public void listenKeyboard() {
        myPlayground.requestFocus();
        myPlayground.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case NUMPAD4:
                        h = 1;
                    case NUMPAD5:
                        h = 2;
                    case NUMPAD1:
                        h = 3;
                    case NUMPAD2:
                        h = 4;
                }
            }
        });
    }
}
