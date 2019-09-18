package ch14_streams.create;

import static onjava.Repeat.repeat;

/**
 * 使用自定义的工具 测试循环
 *
 * @Author 时少龙
 * @Date 2019-08-10 15:13
 * @Version 1.0
 */
public class Looping {

    static void hi() {
        System.out.println("Hi!");
    }

    static void hi2(int i) {
        System.out.println("Hi!  index:" + i);
    }

    public static void main(String[] args) {
        repeat(5, Looping::hi);
        repeat(2, () -> System.out.println("时少龙"));
        System.out.println("=======================");
        repeat(3, Looping::hi2);
        repeat(2, i -> System.out.println("时少龙 index:" + i));

    }
}
