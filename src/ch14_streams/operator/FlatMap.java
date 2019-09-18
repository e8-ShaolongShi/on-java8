package ch14_streams.operator;

import java.util.stream.Stream;

/**
 * @Author 时少龙
 * @Date 2019-08-31 16:19
 * @Version 1.0
 */
public class FlatMap {

    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("shishaolong", "时小", "李龙"))
                .forEach(System.out::println);
    }
}
