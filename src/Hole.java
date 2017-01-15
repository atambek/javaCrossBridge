import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by ant on 8.01.2017.
 */
public class Hole {
    private boolean isFilled;
    public Hole(int x, int y, boolean filled) {
        isFilled = filled;
    }
    public void fillHole(Hole hole){
        isFilled = true;
    }

    public void emptyHole(){
        isFilled = false;
    }
    public boolean getStatus(int[] xy) {
        return isFilled;
    }
}
