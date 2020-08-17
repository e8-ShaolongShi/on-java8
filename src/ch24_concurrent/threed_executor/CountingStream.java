package ch24_concurrent.threed_executor;

import java.util.stream.IntStream;

/**
 * 不使用线程池调用Callable实现方法，而是使用Stream中的并行流直接手动调用方法
 *
 * @author shishaolong
 * @datatime 2020/8/17 16:13
 */
public class CountingStream {
    public static void main(String[] args) {
        System.out.println(
                IntStream.range(0, 10).parallel()
                        .mapToObj(CountingTask::new)
                        .map(ct -> ct.call())
                        .reduce(0, Integer::sum));
    }
}
