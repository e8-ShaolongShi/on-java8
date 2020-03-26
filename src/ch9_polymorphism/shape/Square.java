package ch9_polymorphism.shape;

/**
 * @author shishaolong
 * @datatime 2020/3/26 8:27
 */
public class Square extends Shape {

    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Square.erase()");
    }
}
