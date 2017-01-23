import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by ant on 8.01.2017.
 */
public class MovingObject {
    private int[] coordinates;

    public MovingObject (int x, int y) {
        coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
    }

    public void moveObject () {
        coordinates[0]++;
    }

    public void fall () {
        coordinates[1]++;
    }

    public int[] getCoordinates() {
        return coordinates;
    }
}
