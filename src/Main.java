import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
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
}




