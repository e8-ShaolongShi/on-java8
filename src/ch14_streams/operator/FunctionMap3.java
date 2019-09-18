package ch14_streams.operator;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * map 如果map中方法返回的结果为  数值类型中的一种，我们需要使用合适的mapTo数值类型替代
 * 方法 输入流元素 输出还是流元素
 *
 * @Author 时少龙
 * @Date 2019-08-31 15:36
 * @Version 1.0
 */
public class FunctionMap3 {
    public static void main(String[] args) {
        System.out.println("1. mapToInt");
        Stream.of("5", "7", "9")
                .mapToInt(Integer::parseInt)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println("\n2. mapToLong");
        Stream.of("17", "19", "23")
                .mapToLong(Long::parseLong)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println("\n3. mapToDouble");
        Stream.of("17", "19", "23")
                .mapToDouble(Double::parseDouble)
                .forEach(n -> System.out.format("%f ", n));
    }
}
