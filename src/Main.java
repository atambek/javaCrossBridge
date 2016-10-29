import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.Node;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main extends Application {
    Rectangle junction1;
    Rectangle junction2;
    Rectangle junction3;
    Rectangle junction4;
    //Rectangle ruut;
    Random timeGap;
    double speed;
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
        ;
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
                setupPlayground();
                setupGrid();
                listenKeyboard();
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
                    square.setFill(Color.YELLOW);
                    junction1 = square;
                } else if ((i == 9) && (j == 2)) {
                    square.setFill(Color.BLACK);
                    junction2 = square;
                } else if ((i == 4) && (j == 5)) {
                    square.setFill(Color.BLACK);
                    junction3 = square;
                } else if ((i == 9) && (j == 5)) {
                    square.setFill(Color.BLACK);
                    junction4 = square;
                } else {
                    square.setFill(Color.BLUE);
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

    private void createObject() {
        Circle circle = new Circle(0, 0, 3, Color.YELLOW);

    }

    private void listenKeyboard() {
        myPlayground.requestFocus();
        myPlayground.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.PAGE_UP) {
                    //System.out.println("Klahv");
                    //Rectangle ruut2 = (Rectangle) getNodeFromGridPane(4,2);
                    //ruut2.setFill(Color.YELLOW);
                    junction1.setFill(Color.YELLOW);
                    junction2.setFill(Color.BLACK);
                    junction3.setFill(Color.BLACK);
                    junction4.setFill(Color.BLACK);
                } else if (event.getCode() == KeyCode.PAGE_DOWN) {
                    //System.out.println("Klahv");
                    //Rectangle ruut2 = (Rectangle) getNodeFromGridPane(9, 2);
                    //ruut2.setFill(Color.YELLOW);
                    junction1.setFill(Color.BLACK);
                    junction2.setFill(Color.YELLOW);
                    junction3.setFill(Color.BLACK);
                    junction4.setFill(Color.BLACK);
                } else if (event.getCode() == KeyCode.LEFT) {
                    //System.out.println("Klahv");
                    //Rectangle ruut2 = (Rectangle) getNodeFromGridPane(4, 5);
                    //ruut2.setFill(Color.YELLOW);
                    junction1.setFill(Color.BLACK);
                    junction2.setFill(Color.BLACK);
                    junction3.setFill(Color.YELLOW);
                    junction4.setFill(Color.BLACK);
                } else if (event.getCode() == KeyCode.RIGHT) {
                    //System.out.println("Klahv");
                    //Rectangle ruut2 = (Rectangle) getNodeFromGridPane(9, 5);
                    //ruut2.setFill(Color.YELLOW);
                    junction1.setFill(Color.BLACK);
                    junction2.setFill(Color.BLACK);
                    junction3.setFill(Color.BLACK);
                    junction4.setFill(Color.YELLOW);
                }
            }
        });
    }
}


