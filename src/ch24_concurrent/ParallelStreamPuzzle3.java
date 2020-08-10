package ch24_concurrent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author shishaolong
 * @datatime 2020/8/10 11:13
 */
public class ParallelStreamPuzzle3 {

    public static void main(String[] args) throws Exception {
        List<Integer> x = IntStream.range(0, 30)
                .peek(e -> System.out.println(e + ": " + Thread.currentThread().getName()))
                .limit(10)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(x);
    }
}
