package ch14_streams;

import java.util.stream.Stream;

/**
 * @Author 时少龙
 * @Date 2019-08-10 15:39
 * @Version 1.0
 */
public class Bubbles {

    public static void main(String[] args) {
        Stream.generate(Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}
