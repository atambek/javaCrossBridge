import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * Created by ant on 8.01.2017.
 */
public class Holes {
    ArrayList <Hole> holes = new ArrayList();

    public Holes() {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                Hole hole = new Hole(4, 2, true);
                holes.add(hole);
            }
            else if (i == 1) {
                Hole hole = new Hole(9, 2, false);
                holes.add(hole);
            }
            else if (i==2) {
                Hole hole = new Hole(4, 5, false);
                holes.add(hole);
            }
            else if (i==3) {
                Hole hole = new Hole(9, 5, false);
                holes.add(hole);
            }
        }
    }

    public Color getColor(int x, int y) {
        for (int k = 0; k < holes.size(); k++) {
            Hole hole = holes.get(k);
            int filled = hole.getStatus(new int[]{x,y});
            if (filled==1) {
                return Color.YELLOW;
            }
            else if (filled == 0) {
                return Color.BLACK;
            }
        }
        return Color.BLUE;
    }
    public void fillHole(int i) {
        for (int j = 0; j < 4; j++) {
            Hole hole = holes.get(j);
            if (i==j)
                hole.fillHole();
            else
                hole.emptyHole();

        }
    }
    public int[] getFilledHoleCoordinates () {
        int[] coordinates;
        for (int i = 0; i < 4; i++) {
            Hole hole = holes.get(i);
            coordinates = hole.getCoordinates();
            if (coordinates[2] == 1)
                return coordinates;

        }
        return new int[2];
    }
}
