package ch9_polymorphism.shape;

/**
 * @author shishaolong
 * @datatime 2020/3/26 8:28
 */
public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }
}
