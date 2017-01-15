import javafx.event.EventHandler;
import javafx.scene.Node;
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
    Holes holes;
    public GridPane myPlayground = new GridPane();
    Scene scene = new Scene(myPlayground, 710, 410);
    public static int gridHeight = 8;
    public static int gridWidth = 14;
    public Rectangle junction1;
    public Rectangle junction2;
    public Rectangle junction3;
    public Rectangle junction4;

    public PlayGround() {
        setupPlayground();
        holes = new Holes();
        renderGrid();
    }


    public void setupPlayground() {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        System.out.println("andres");
        setupGrid();
    }

    public void renderGrid() {
        myPlayground.getChildren().clear();
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                Color status = holes.getColor(i,j);
                Rectangle square = new Rectangle(50,50,status);
                square.setStroke(Color.RED);
                myPlayground.add(square,i,j);
            }
        }
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
                switch (event.getCode()) {
                    case NUMPAD4:
                        holes.fillHole(0);
                    case NUMPAD5:
                        holes.fillHole(1);
                    case NUMPAD1:
                        holes.fillHole(2);
                    case NUMPAD2:
                        holes.fillHole(3);
                }
            }
        });
    }
}
