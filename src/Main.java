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
    private final static double refreshRate = Math.pow(10,1);
    GridPane myPlayground;
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
}




