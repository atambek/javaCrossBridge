import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by ant on 8.01.2017.
 */
public class MovingObject {
    //Circle ring = new Circle();

    public int addObject () {
        //Otsusta juhuslikkuse alusel, kas objekt üldse lisada
        int i = (int) (Math.random() * 1.2);
        if (i == 1) {
            return 0;
        }

        //Otsusta juhuslikkuse alusel, kas objekt lisada 1. või 2. tasandile
        int level = (int) (Math.random() * 2);
        if (level == 1) {
            return 1;
        }
        else {
            //myPlayground.add(object, 0, 4);
            return 4;
        }
    }

    public void moveObject () {

    }

    public void fall () {

    }
}
