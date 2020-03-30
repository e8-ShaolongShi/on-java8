package ch9_polymorphism.shape;

import java.util.Random;

/**
 * @author shishaolong
 * @datatime 2020/3/27 17:20
 */
public class ShapesGenerator {

    private Random random = new Random(47);

    public Shape get() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Triangle();
            case 1:
                return new Circle();
            case 2:
                return new Square();
        }
    }

    public Shape[] array(int n) {
        Shape[] shapes = new Shape[n];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = get();
        }
        return shapes;
    }

}
