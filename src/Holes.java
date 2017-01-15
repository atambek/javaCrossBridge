import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by ant on 8.01.2017.
 */
public class Holes {
    ArrayList<Hole> holes = new ArrayList();

    public Holes() {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                Hole hole = new Hole(4, 2, true);
            }
            if (i == 1) {
                Hole hole = new Hole(9, 2, false);
            }
            if (i==2) {
                Hole hole = new Hole(4, 5, false);
            }
            if (i==3) {
                Hole hole = new Hole(9, 5, false);
            }
        }
    }
    public Color getColor(int x, int y) {
        for (int i = 0; i < holes.size(); i++) {
            Hole hole = holes.get(i);
            boolean filled = hole.getStatus(new int[]{x,y});
            if (filled)
                return Color.YELLOW;
            else
                return Color.BLACK;
        }
        return Color.BLUE;
    }

}
