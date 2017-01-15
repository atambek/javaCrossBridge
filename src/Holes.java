import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * Created by ant on 8.01.2017.
 */
public class Holes {
    ArrayList<Hole> holes = new ArrayList();

    public Holes() {
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
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
        //System.out.println(holes.size());
        for (int k = 0; k < 4; k++) {
            //System.out.println(k);
            Hole hole = holes.get(k);
            boolean filled = hole.getStatus(new int[]{x,y});
            if (filled==true) {
                //System.out.println("kollane");
                return Color.YELLOW;
            }
            else if (filled == false)
                return Color.BLACK;
        }
        return Color.BLUE;
    }
    public void fillHole(int i) {
        for (int j = 0; j < 4; j++) {
            Hole hole = holes.get(j);
            hole.emptyHole();
        }
        Hole hole = holes.get(i);
        hole.fillHole();

    }
}
