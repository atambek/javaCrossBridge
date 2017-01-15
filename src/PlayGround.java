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
        holes = new Holes();
        renderGrid();
    }


    public void setupPlayground() {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        System.out.println("andres");
        holes = new Holes(); //add 4 holes
        setupGrid();
        renderGrid();
        listenKeyboard();
    }

    public void renderGrid() {
        myPlayground.getChildren().clear();
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                //Color type = getType(new int[]{i, j});
                //Rectangle square = new Rectangle(50,50);
                //square.setStroke(Color.RED);
                //myPlayground.add(square, i, j);
                //System.out.println(i);
                //System.out.println(j);
                Color status = holes.getColor(i,j);
                Rectangle square = new Rectangle(50,50,status);
                square.setStroke(Color.RED);
                myPlayground.add(square,i,j);
            }
        }
    }

    //public Color getType(int[] xy) {
    //    for (Node element : myPlayground.getChildren()) {
    //        Rectangle renderedSquare;
    //        if (element.getId().equals("regular")) {
    //            renderedSquare = (Rectangle) element;
                //renderedSquare.setFill(Color);
    //            int i = GridPane.getRowIndex(element);
    //            int j = GridPane.getColumnIndex(element);
    //            if (i == 1 || i == 4) {
    //                myPlayground.getChildren().remove(element);
    //                myPlayground.add(renderedSquare, j, i);
    //            }
    //        }
    //    }
        //for (int i = 0; i < holes.size(); i++) {
        //    Hole hole = holes.get(i);
        //    boolean empty = hole.emptyHole(hole);
        //    if (empty)                             // hole not filled
        //        return Color.BLACK;
        //    else
        //        return  Color.YELLOW;            // hole filled
        //}
        //return Color.BLUE;
    //}
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
    private void setupGrid() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                Rectangle square = new Rectangle(50, 50);
                if ((i == 4) && (j == 2)) {
                    //square.setFill(Color.YELLOW);
                    square.setId("bridge");
                    junction1 = square;
                } else if ((i == 9) && (j == 2)) {
                    //square.setFill(Color.BLACK);
                    square.setId("hole");
                    junction2 = square;
                } else if ((i == 4) && (j == 5)) {
                    //square.setFill(Color.BLACK);
                    square.setId("hole");
                    junction3 = square;
                } else if ((i == 9) && (j == 5)) {
                    //square.setFill(Color.BLACK);
                    square.setId("hole");
                    junction4 = square;
                } else {
                    //square.setFill(Color.BLUE);
                    square.setId("regular");
                }
                square.setStroke(Color.RED);

                myPlayground.add(square, i, j);
            }
        }
    }
}
