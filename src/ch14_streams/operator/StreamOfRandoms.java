package ch14_streams.operator;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 演示： flatMap 应用
 *
 * @Author 时少龙
 * @Date 2019-08-31 16:19
 * @Version 1.0
 */
public class StreamOfRandoms {

    static Random rand = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMapToInt(i -> IntStream.concat(
                        rand.ints(0, 100).limit(i), IntStream.of(-1))
                )
                .forEach(n -> System.out.format("%d ", n));
    }
}
