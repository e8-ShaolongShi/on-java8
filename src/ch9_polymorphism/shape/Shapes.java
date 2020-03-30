package ch9_polymorphism.shape;

/**
 * @author shishaolong
 * @datatime 2020/3/26 8:32
 */
public class Shapes {

    private static ShapesGenerator generator = new ShapesGenerator();

    public static void main(String[] args) {
        RandomShapes gen = new RandomShapes();
//        Shape[] array = gen.array(8);
//        for (Shape shape : array) {
//            shape.draw();
//        }

        Shape[] shapes = generator.array(5);
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

}
