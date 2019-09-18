package ch14_streams.operator;

import java.util.stream.Stream;

/**
 * 设计用来 引出flatMap
 * <p>
 * 如果一个方法产生的是流而不是元素，map将无法应对
 *
 * @Author 时少龙
 * @Date 2019-08-31 16:16
 * @Version 1.0
 */
public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("shishaolong", "时小", "李龙"))
                .forEach(System.out::println);
    }
}
