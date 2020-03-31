package ch10_interfaces;

/**
 * @author shishaolong
 * @datatime 2020/3/30 17:59
 */
public class Implementation2 implements InterfaceWithDefault {
    @Override
    public void firstMethod() {
        System.out.println("firstMethod()");
    }

    @Override
    public void secondMethod() {
        System.out.println("secondMethod()");
    }

    public static void main(String[] args) {
        InterfaceWithDefault i = new Implementation2();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();
    }
}
