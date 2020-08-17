package ch24_concurrent.threed_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * CachedTreadPool2
 *
 * @author shishaolong
 * @datatime 2020/8/17 15:16
 */
public class CachedThreadPool2 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 10).mapToObj(InterferingTask::new).forEach(exec::execute);
        exec.shutdown();
    }
}
