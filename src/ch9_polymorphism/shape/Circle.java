package ch9_polymorphism.shape;

/**
 * @author shishaolong
 * @datatime 2020/3/26 8:27
 */
public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }
}
