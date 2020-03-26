package ch9_polymorphism.shape;

import java.util.Random;

/**
 * @author shishaolong
 * @datatime 2020/3/26 8:28
 */
public class RandomShapes {

    private Random rand = new Random(47);

    public Shape get() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Triangle();
            case 2:
                return new Square();
        }
    }

    public Shape[] array(int size){
        Shape[] shapes = new Shape[size];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = get();
        }

        return shapes;
    }
}
