package ch24_concurrent.threed_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * SingleThreadExecutor3
 *
 * @author shishaolong
 * @datatime 2020/8/17 15:20
 */
public class SingleThreadExecutor3 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).mapToObj(InterferingTask::new).forEach(exec::execute);
        exec.shutdown();
    }
}
