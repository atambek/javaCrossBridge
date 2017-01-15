import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;


public class Main extends Application {
    long lastUpdate;
    long lastUpd;
    private final static double refreshRate = Math.pow(10,1);
    Rectangle junction1;
    Rectangle junction2;
    Rectangle junction3;
    Rectangle junction4;
    GridPane myPlayground;
    int height = 8;
    int width = 14;

    Button startGameButton;
    Button cancelButton;

    public static void main(String args[]) {
        launch(args);
        System.out.println("Silla ületamine...");
        System.out.println("Autor: Andres Tambek");
        System.out.println("Esimesed katsetused Javas");
        System.out.println("Aasta: 2016");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Silla ületamise mäng");
        startGameButton = new Button();
        startGameButton.setText("Start Game");
        startGameButton.setLayoutX(250);
        startGameButton.setLayoutY(200);
        startGameButton.setPrefWidth(100);
        startGameButton.setPrefHeight(50);

        cancelButton = new Button();
        cancelButton.setText("Exit");
        cancelButton.setLayoutX(500);
        cancelButton.setLayoutY(200);
        cancelButton.setPrefWidth(100);
        cancelButton.setPrefHeight(50);

        Pane startLayout = new Pane();
        startLayout.getChildren().addAll(startGameButton, cancelButton);


        Scene scene = new Scene(startLayout, 900, 500);
        primaryStage.setScene((scene));
        primaryStage.show();

        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                PlayGround grid = new PlayGround();
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                primaryStage.close();
            }
        });

    }

    private void setupGrid() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
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

    private void setupPlayground() {
        myPlayground = new GridPane();
        Scene scene = new Scene(myPlayground, 710, 410);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private void moveObject() {
        Circle object = new Circle();
        object.setFill(Color.RED);
        object.setRadius(25);
        object.setId("ring skip");

        Rectangle object2 = new Rectangle(50, 50);
        object2.setFill(Color.BLUE);
        object2.setId("regular skip");

        for (Node element : myPlayground.getChildren()) {
            if (element.getId().equals("ring")) {
                int i = GridPane.getRowIndex(element);
                int j = GridPane.getColumnIndex(element);
                if (i == 1 || i == 4) {
                    myPlayground.getChildren().remove(element);
                    myPlayground.add(object2, j, i);
                    myPlayground.add(object, j + 1, i);
                }
            }
        }
        for (Node element2 : myPlayground.getChildren()) {
            int i = GridPane.getRowIndex(element2);
            int j = GridPane.getColumnIndex(element2);
            if (i == 1 || i == 4) {
                if (element2.getId().equals("ring skip")) {
                    element2.setId("ring");
                } else if (element2.getId().equals("regular skip")) {
                    element2.setId("regular");
                }
            }
        }
    }

    private void setupNewGrid () {
        GridPane newPlayground = new GridPane();
        Rectangle square = new Rectangle(50, 50);
        square.setFill(Color.BLUE);
        square.setId("regular");

        Rectangle bridgesquare = new Rectangle(50, 50);
        bridgesquare.setFill(Color.YELLOW);
        bridgesquare.setId("bridge");

        Rectangle holesquare = new Rectangle(50, 50);
        holesquare.setFill(Color.BLACK);
        holesquare.setId("hole");

        Circle ring = new Circle();
        ring.setFill(Color.RED);
        ring.setId("ring");
        for (Node element : myPlayground.getChildren()) {
            int i = GridPane.getRowIndex(element);
            int j = GridPane.getColumnIndex(element);
            if (i == 1 || i == 4) {
                if (element.getId().equals("regular")) {
                    newPlayground.add(square, j + 1, i);
                }
                else if (element.getId().equals("ring")) {
                    newPlayground.add(ring, j + 1, i);
                }
            }
            else {
                if (element.getId().equals("regular")) {
                    newPlayground.add(square, j, i);
                }
                else if (element.getId().equals("hole")) {
                    newPlayground.add(holesquare, j, i);
                }
                else {
                    newPlayground.add(bridgesquare, j, i);
                }
            }
        }

        myPlayground.getChildren().removeAll();
        myPlayground.getChildren().addAll(newPlayground);
    }
}




