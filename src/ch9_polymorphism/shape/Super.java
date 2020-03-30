package ch9_polymorphism.shape;

/**
 * 多态： 缺陷，属性不会多态的， 子类属性不会覆盖掉父类的属性的
 *
 * @author shishaolong
 * @datatime 2020/3/27 18:41
 */
public class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    private int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }

    public static void main(String[] args) {
        Super sup = new Sub(); // Upcast
        System.out.println("sup.field = " + sup.field +
                ", sup.getField() = " + sup.getField());

        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field +
                ", sub.getField() = " + sub.getField()
                + ", sub.getSuperField() = " + sub.getSuperField());
    }
}
