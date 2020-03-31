package ch10_interfaces;

/**
 * 测试接口默认实现
 * 接口中添加default 可以给接口方法添加默认实现
 *
 * @author shishaolong
 * @datatime 2020/3/30 17:57
 */
public interface InterfaceWithDefault {
    void firstMethod();

    void secondMethod();

    /*
     * 默认方法也称 虚拟方法、或守卫方法
     * 旨在 不破坏已使用接口的代码的情况下，在接口中增加新的方法
     * */
    default void newMethod() {
        System.out.println("this is InterfaceWithDefault.newMethod()");
    }

}
