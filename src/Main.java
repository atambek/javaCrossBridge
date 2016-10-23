import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
    GridPane myPlayground;
    int height = 8;
    int width = 14;

    Button button;
    public static void main(String args[]) {
        launch(args);
        System.out.println("Silla ületamine...");
        System.out.println("Autor: Andres Tambek");
	    System.out.println("Esimesed katsetused Javas");
	    System.out.println("Aasta: 2016");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //primaryStage.setTitle("Silla ületamise mäng");
        //button = new Button();
        //button.setText("Start Game");

        //StackPane layout = new StackPane();
        //layout.getChildren().add(button);

        //Scene scene = new Scene(layout,900,500);
        //primaryStage.setScene((scene));
        //primaryStage.show();

        setupPlayground();
        setupGrid();

    }
    private void setupGrid() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Rectangle ruut = new Rectangle(50,50);
                if (((i == 4) && (j==2)) || ((i == 9) && (j==2)) || ((i == 4) && (j==5)) || ((i == 9) && (j==5))){
                    ruut.setFill(Color.BLACK);
                }
                else {
                    ruut.setFill(Color.BLUE);
                }
                ruut.setStroke(Color.RED);

                myPlayground.add(ruut,i,j);
            }
        }
    }
    private void setupPlayground() {
        myPlayground = new GridPane();
        Scene scene = new Scene(myPlayground,900,500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
