package ch14_streams.create;

import java.util.stream.Stream;

/**
 * StreamOf: Stream.of(): 演示
 *
 * @Author 时少龙
 * @Date 2019-08-10 10:48
 * @Version 1.0
 */
public class StreamOf {

    public static void main(String[] args) {
        // 1. 打印字符串
        Stream.of(new String("1"), new String("2"), new String("3"))
                .forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++");
        Stream.of("It`s", "a ", "wonderful", "day", "for", "pie!").forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++++");
        Stream.of(3.1415926, 2.718, 1.618).forEach(System.out::println);
    }

}
