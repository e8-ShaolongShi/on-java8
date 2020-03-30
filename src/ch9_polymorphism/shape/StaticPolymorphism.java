package ch9_polymorphism.shape;

/**
 * 测试静态方法重写
 */

class StaticSuper {
    public static String staticGet() {
        return "Basic StaticGet()";
    }

    public String dynamicGet() {
        return "Basic DynamicGet";
    }
}

/**
 * 子类继承父类 测试覆盖静态方法
 */
class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived StaticGet()";
    }

    @Override
    public String dynamicGet() {
        return "Derived DynamicGet";
    }
}

/**
 * @author shishaolong
 * @datatime 2020/3/27 18:50
 */
public class StaticPolymorphism {

    public static void main(String[] args) {

        StaticSuper aSuper = new StaticSub();
        System.out.println(aSuper.dynamicGet());
    }
}
