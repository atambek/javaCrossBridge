import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by ant on 8.01.2017.
 */
public class Hole {
    private int[] coordinates;
    private int isFilled;

    public Hole(int x, int y, boolean filled) {
        coordinates = new int[3];
        coordinates[0] = x;
        coordinates[1] = y;
        if (filled) {
            System.out.println("täidetud");
            coordinates[2] = 1;
        }
        else {
            System.out.println("tühi");
            coordinates[2] = 0;
        }
    }
    public void fillHole(){
        coordinates[2] = 1;
    }

    public void emptyHole(){
        coordinates[2] = 0;
    }
    public boolean getStatus(int[] xy) {
        if (coordinates[2] == 1)
            return true;
        return false;
    }
}
