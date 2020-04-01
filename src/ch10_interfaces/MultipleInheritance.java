package ch10_interfaces;

interface One {
    default void first() {
        System.out.println("One.first!");
    }
}

interface Two {
    default void second() {
        System.out.println("Two.Second!");
    }
}

interface Three {
    default void third() {
        System.out.println("One.third!!");
    }
}

interface Three2 {
    default void third() {
        System.out.println("One.third!!");
    }
}

// 多接口方法 合并
class Comp implements One, Two, Three, Three2{

    /**
     * 实现的接口中有相同的方法，需要覆盖提供一个自己的版本
     */
    @Override
    public void third() {
        System.out.println("my third");
    }
}

/**
 * 间接多继承: 组合多个方法
 *
 * @author shishaolong
 * @datatime 2020/3/31 11:34
 */
public class MultipleInheritance {
    public static void main(String[] args) {
        Comp comp = new Comp();
        comp.first();
        comp.second();
        comp.third();
    }
}
