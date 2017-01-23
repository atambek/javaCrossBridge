import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by ant on 8.01.2017.
 */
public class Hole {
    private int[] coordinates; // 0 -> x-coordinate, 1 -> y-coordinate, 2 - tühi/täidetud

    public Hole(int x, int y, boolean filled) {
        coordinates = new int[3];
        coordinates[0] = x;
        coordinates[1] = y;
        if (filled) {
            coordinates[2] = 1;
        }
        else {
            coordinates[2] = 0;
        }
    }
    public void fillHole(){
        coordinates[2] = 1;
    }

    public void emptyHole(){
        coordinates[2] = 0;
    }
    public int getStatus(int[] xy) {
        // 1 -> filled, 0 -> empty,-1 -> not hole at all
        if (coordinates[0] == xy[0] && coordinates[1] == xy[1])
            return (coordinates[2]);
        return -1;
    }
}
